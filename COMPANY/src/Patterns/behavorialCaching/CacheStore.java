package Patterns.behavorialCaching;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Patterns.behavorialCaching.database.DbManager;
import lombok.extern.slf4j.Slf4j;

/**
 * The caching strategies are implemented in this class.
 */
@Slf4j
public class CacheStore {
    /**
     * Cache capacity.
     */
    private static final int CAPACITY = 3;

    /**
     * Lru cache see {@link LruCache}.
     */
    private LruCache cache;
    /**
     * DbManager.
     */
    private final DbManager dbManager;

    /**
     * Cache Store.
     * @param dataBaseManager {@link DbManager}
     */
    public CacheStore(final DbManager dataBaseManager) {
        this.dbManager = dataBaseManager;
        initCapacity(CAPACITY);
    }

    /**
     * Init cache capacity.
     * @param capacity int
     */
    public void initCapacity(final int capacity) {
        if (cache == null) {
            cache = new LruCache(capacity);
        } else {
            cache.setCapacity(capacity);
        }
    }

    /**
     * Get user account using read-through cache.
     * @param userId {@link String}
     * @return {@link UserAccount}
     */
    public UserAccount readThrough(final String userId) {
        if (cache.contains(userId)) {
            System.out.println("# Found in Cache!");
            return cache.get(userId);
        }
        System.out.println("# Not found in cache! Go to DB!!");
        UserAccount userAccount = dbManager.readFromDb(userId);
        cache.set(userId, userAccount);
        return userAccount;
    }

    /**
     * Get user account using write-through cache.
     * @param userAccount {@link UserAccount}
     */
    public void writeThrough(final UserAccount userAccount) {
        if (cache.contains(userAccount.getUserId())) {
            dbManager.updateDb(userAccount);
        } else {
            dbManager.writeToDb(userAccount);
        }
        cache.set(userAccount.getUserId(), userAccount);
    }

    /**
     * Get user account using write-around cache.
     * @param userAccount {@link UserAccount}
     */
    public void writeAround(final UserAccount userAccount) {
        if (cache.contains(userAccount.getUserId())) {
            dbManager.updateDb(userAccount);
            // Cache data has been updated -- remove older
            cache.invalidate(userAccount.getUserId());
            // version from cache.
        } else {
            dbManager.writeToDb(userAccount);
        }
    }

    /**
     * Get user account using read-through cache with write-back policy.
     * @param userId {@link String}
     * @return {@link UserAccount}
     */
    public UserAccount readThroughWithWriteBackPolicy(final String userId) {
        if (cache.contains(userId)) {
            System.out.println("# Found in cache!");
            return cache.get(userId);
        }
        System.out.println("# Not found in Cache!");
        UserAccount userAccount = dbManager.readFromDb(userId);
        if (cache.isFull()) {
            System.out.println("# Cache is FULL! Writing LRU data to DB...");
            UserAccount toBeWrittenToDb = cache.getLruData();
            dbManager.upsertDb(toBeWrittenToDb);
        }
        cache.set(userId, userAccount);
        return userAccount;
    }

    /**
     * Set user account.
     * @param userAccount {@link UserAccount}
     */
    public void writeBehind(final UserAccount userAccount) {
        if (cache.isFull() && !cache.contains(userAccount.getUserId())) {
            System.out.println("# Cache is FULL! Writing LRU data to DB...");
            UserAccount toBeWrittenToDb = cache.getLruData();
            dbManager.upsertDb(toBeWrittenToDb);
        }
        cache.set(userAccount.getUserId(), userAccount);
    }

    /**
     * Clears cache.
     */
    public void clearCache() {
        if (cache != null) {
            cache.clear();
        }
    }

    /**
     * Writes remaining content in the cache into the DB.
     */
    public void flushCache() {
        System.out.println("# flushCache...");
        Optional.ofNullable(cache)
                .map(LruCache::getCacheDataInListForm)
                .orElse(List.of())
                .forEach(dbManager::updateDb);
        dbManager.disconnect();
    }

    /**
     * Print user accounts.
     * @return {@link String}
     */
    public String print() {
        return Optional.ofNullable(cache)
                .map(LruCache::getCacheDataInListForm)
                .orElse(List.of())
                .stream()
                .map(userAccount -> userAccount.toString() + "\n")
                .collect(Collectors.joining("", "\n--CACHE CONTENT--\n", "----"));
    }

    /**
     * Delegate to backing cache store.
     * @param userId {@link String}
     * @return {@link UserAccount}
     */
    public UserAccount get(final String userId) {
        return cache.get(userId);
    }

    /**
     * Delegate to backing cache store.
     * @param userId {@link String}
     * @param userAccount {@link UserAccount}
     */
    public void set(final String userId, final UserAccount userAccount) {
        cache.set(userId, userAccount);
    }

    /**
     * Delegate to backing cache store.
     * @param userId {@link String}
     */
    public void invalidate(final String userId) {
        cache.invalidate(userId);
    }
}
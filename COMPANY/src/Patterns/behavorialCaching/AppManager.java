package Patterns.behavorialCaching;

import java.util.Optional;

import Patterns.behavorialCaching.database.DbManager;
import lombok.extern.slf4j.Slf4j;

/**
 * AppManager helps to bridge the gap in communication between the main class
 * and the application's back-end. DB connection is initialized through this
 * class. The chosen  caching strategy/policy is also initialized here.
 * Before the cache can be used, the size of the  cache has to be set.
 * Depending on the chosen caching policy, AppManager will call the
 * appropriate function in the CacheStore class.
 */
@Slf4j
public class AppManager {
    /**
     * Caching Policy.
     */
    private CachingPolicy cachingPolicy;
    /**
     * Database Manager.
     */
    private final DbManager dbManager;
    /**
     * Cache Store.
     */
    private final CacheStore cacheStore;

    /**
     * Constructor.
     *
     * @param newDbManager database manager
     */
    public AppManager(final DbManager newDbManager) {
        this.dbManager = newDbManager;
        this.cacheStore = new CacheStore(newDbManager);
    }

    /**
     * Developer/Tester is able to choose whether the application should use
     * MongoDB as its underlying data storage or a simple Java data structure
     * to (temporarily) store the data/objects during runtime.
     */
    public void initDb() {
        dbManager.connect();
    }

    /**
     * Initialize caching policy.
     *
     * @param policy is a {@link CachingPolicy}
     */
    public void initCachingPolicy(final CachingPolicy policy) {
        cachingPolicy = policy;
        if (cachingPolicy == CachingPolicy.BEHIND) {
            Runtime.getRuntime().addShutdownHook(new Thread(cacheStore::flushCache));
        }
        cacheStore.clearCache();
    }

    /**
     * Find user account.
     *
     * @param userId String
     * @return {@link UserAccount}
     */
    public UserAccount find(final String userId) {
        System.out.println("Trying to find "+userId+" in cache");
        if (cachingPolicy == CachingPolicy.THROUGH
                || cachingPolicy == CachingPolicy.AROUND) {
            return cacheStore.readThrough(userId);
        } else if (cachingPolicy == CachingPolicy.BEHIND) {
            return cacheStore.readThroughWithWriteBackPolicy(userId);
        } else if (cachingPolicy == CachingPolicy.ASIDE) {
            return findAside(userId);
        }
        return null;
    }

    /**
     * Save user account.
     *
     * @param userAccount {@link UserAccount}
     */
    public void save(final UserAccount userAccount) {
        System.out.println("Save record!");
        if (cachingPolicy == CachingPolicy.THROUGH) {
            cacheStore.writeThrough(userAccount);
        } else if (cachingPolicy == CachingPolicy.AROUND) {
            cacheStore.writeAround(userAccount);
        } else if (cachingPolicy == CachingPolicy.BEHIND) {
            cacheStore.writeBehind(userAccount);
        } else if (cachingPolicy == CachingPolicy.ASIDE) {
            saveAside(userAccount);
        }
    }

    /**
     * Returns String.
     *
     * @return String
     */
    public String printCacheContent() {
        return cacheStore.print();
    }

    /**
     * Cache-Aside save user account helper.
     *
     * @param userAccount {@link UserAccount}
     */
    private void saveAside(final UserAccount userAccount) {
        dbManager.updateDb(userAccount);
        cacheStore.invalidate(userAccount.getUserId());
    }

    /**
     * Cache-Aside find user account helper.
     *
     * @param userId String
     * @return {@link UserAccount}
     */
    private UserAccount findAside(final String userId) {
        return Optional.ofNullable(cacheStore.get(userId))
                .or(() -> {
                    Optional<UserAccount> userAccount =
                            Optional.ofNullable(dbManager.readFromDb(userId));
                    userAccount.ifPresent(account -> cacheStore.set(userId, account));
                    return userAccount;
                })
                .orElse(null);
    }
}
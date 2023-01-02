package Patterns.behavorialCaching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * Data structure/implementation of the application's cache. The data structure
 * consists of a hash table attached with a DOUBLY linked-list. The linked-list
 * helps in capturing and maintaining the LRU data in the cache. When a data is
 * queried (from the cache), added (to the cache), or updated, the data is
 * moved to the front of the list to depict itself as the most-recently-used
 * data. The LRU data is always at the end of the list.
 */
@Slf4j
public class LruCache {
    /**
     * Static class Node.
     */
    static class Node {
        /**
         * user id.
         */
        private final String userId;
        /**
         * User Account.
         */
        private UserAccount userAccount;
        /**
         * previous.
         */
        private Node previous;
        /**
         * next.
         */
        private Node next;

        /**
         * Node definition.
         *
         * @param id      String
         * @param account {@link UserAccount}
         */
        Node(final String id, final UserAccount account) {
            this.userId = id;
            this.userAccount = account;
        }
    }

    /**
     * Capacity of Cache.
     */
    private int capacity;
    /**
     * Cache {@link HashMap}.
     */
    private Map<String, Node> cache = new HashMap<>();
    /**
     * Head.
     */
    private Node head;
    /**
     * End.
     */
    private Node end;

    /**
     * Constructor.
     *
     * @param cap Integer.
     */
    public LruCache(final int cap) {
        this.capacity = cap;
    }

    /**
     * Get user account.
     *
     * @param userId String
     * @return {@link UserAccount}
     */
    public UserAccount get(final String userId) {
        if (cache.containsKey(userId)) {
            var node = cache.get(userId);
            remove(node);
            setHead(node);
            return node.userAccount;
        }
        return null;
    }

    /**
     * Remove node from linked list.
     *
     * @param node {@link Node}
     */
    public void remove(final Node node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            end = node.previous;
        }
    }

    /**
     * Move node to the front of the list.
     *
     * @param node {@link Node}
     */
    public void setHead(final Node node) {
        node.next = head;
        node.previous = null;
        if (head != null) {
            head.previous = node;
        }
        head = node;
        if (end == null) {
            end = head;
        }
    }

    /**
     * Set user account.
     *
     * @param userAccount {@link UserAccount}
     * @param userId      {@link String}
     */
    public void set(final String userId, final UserAccount userAccount) {
        if (cache.containsKey(userId)) {
            var old = cache.get(userId);
            old.userAccount = userAccount;
            remove(old);
            setHead(old);
        } else {
            var newNode = new Node(userId, userAccount);
            if (cache.size() >= capacity) {
                System.out.println("# Cache is FULL! Removing "+end.userId+" from cache...");
                cache.remove(end.userId); // remove LRU data from cache.
                remove(end);
                setHead(newNode);
            } else {
                setHead(newNode);
            }
            cache.put(userId, newNode);
        }
    }

    /**
     * Check if Cache contains the userId.
     *
     * @param userId {@link String}
     * @return boolean
     */
    public boolean contains(final String userId) {
        return cache.containsKey(userId);
    }

    /**
     * Invalidate cache for user.
     *
     * @param userId {@link String}
     */
    public void invalidate(final String userId) {
        var toBeRemoved = cache.remove(userId);
        if (toBeRemoved != null) {
            System.out.println("# "+userId+" has been updated! "
                    + "Removing older version from cache...");
            remove(toBeRemoved);
        }
    }

    /**
     * Check if the cache is full.
     * @return boolean
     */
    public boolean isFull() {
        return cache.size() >= capacity;
    }

    /**
     * Get LRU data.
     *
     * @return {@link UserAccount}
     */
    public UserAccount getLruData() {
        return end.userAccount;
    }

    /**
     * Clear cache.
     */
    public void clear() {
        head = null;
        end = null;
        cache.clear();
    }

    /**
     * Returns cache data in list form.
     *
     * @return {@link List}
     */
    public List<UserAccount> getCacheDataInListForm() {
        var listOfCacheData = new ArrayList<UserAccount>();
        var temp = head;
        while (temp != null) {
            listOfCacheData.add(temp.userAccount);
            temp = temp.next;
        }
        return listOfCacheData;
    }

    /**
     * Set cache capacity.
     *
     * @param newCapacity int
     */
    public void setCapacity(final int newCapacity) {
        if (capacity > newCapacity) {
            // Behavior can be modified to accommodate
            // for decrease in cache size. For now, we'll
            clear();
            // just clear the cache.
        } else {
            this.capacity = newCapacity;
        }
    }
}
package Patterns.behavorialCaching;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CachingPolicy {
    /**
     * Through.
     */
    THROUGH("through"),
    /**
     * AROUND.
     */
    AROUND("around"),
    /**
     * BEHIND.
     */
    BEHIND("behind"),
    /**
     * ASIDE.
     */
    ASIDE("aside");

    /**
     * Policy value.
     */
    private final String policy;
}

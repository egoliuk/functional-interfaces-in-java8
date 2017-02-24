package introduction;

/**
 * Represents an operation that accepts no input argument and returns no result.
 * This interface is expected to operate via side-effects.
 */
@FunctionalInterface
public interface SimpleFI {

    /**
     * Single abstract method
     */
    void apply();
}

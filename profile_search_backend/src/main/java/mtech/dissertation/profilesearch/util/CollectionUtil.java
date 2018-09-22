package mtech.dissertation.profilesearch.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Utility class for Collection related operations.
 * 
 * @author Abhijit.Daund
 */
public abstract class CollectionUtil {

    /**
     * Returns a list made from given array of certain type.
     * 
     * @param array
     *            the array
     * @return a list of given type
     */
    public static <T> List<T> toList(final T[] array) {
        final List<T> list = new LinkedList<T>();

        for (final T t : array) {
            list.add(t);
        }

        return list;
    }

    /**
     * Returns a list made from given iterable of certain type.
     * 
     * @param iterable
     *            the iterable
     * @return a list of given type
     */
    public static <T> List<T> toList(final Iterable<T> iterable) {
        final List<T> list = new LinkedList<T>();

        for (final T t : iterable) {
            list.add(t);
        }

        return list;
    }

    /**
     * Returns a set made from given iterable of certain type.
     * 
     * @param iterable
     *            the iterable
     * @return a set of given type
     */
    public static <T> Set<T> toSet(final Iterable<T> iterable) {
        final Set<T> set = new HashSet<T>();

        for (final T t : iterable) {
            set.add(t);
        }

        return set;
    }
}

package mtech.dissertation.profilesearch.util;

/**
 * Class for utility methods.
 * 
 * @author Abhijit.Daund
 */
public class Util {

    /**
     * Checks if given object is not null.
     * 
     * @param obj
     *            an object
     * @return true if the given object is not null, false otherwise
     */
    public static boolean ifNotNull(final Object obj) {
        return null != obj;
    }

    /**
     * Checks if given string is not null and empty.
     * 
     * @param string
     *            an object
     * @return true if the given string is not null and empty, false otherwise
     */
    public static boolean ifNotEmpty(final String string) {
        return null != string && !string.isEmpty();
    }
}

package mtech.dissertation.profilesearch.exception;

/**
 * A base exception class
 * 
 * @author Abhijit.Daund
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = -6611814149568040884L;

    private String category;

    /**
     * Creates and returns a new instance of this class initialized with given
     * parameters.
     * 
     * @param message
     *            the message
     * @param category
     *            the category
     */
    public BaseException(final String message, final String category) {
        super(message);
        this.category = category;
    }

    /**
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(final String category) {
        this.category = category;
    }

    /**
     * Category Class used to describe how front-end will handle this error.
     * Front-end may show Error page, or Just a pop-up message according to this
     * field.
     */
    public static class Category {
        /**
         * This Category describes that front-end should show just a pop-up message for
         * this error.
         */
        public static final String MESSAGE = "message";

        /**
         * This Category describes that front-end should show 404 Error page this error.
         */
        public static final String PAGE = "page";
    }
}

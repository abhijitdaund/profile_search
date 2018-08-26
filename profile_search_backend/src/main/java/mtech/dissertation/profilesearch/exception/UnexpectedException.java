package mtech.dissertation.profilesearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Unexpected exception to be thrown when something goes wrong while serving a
 * request.
 * 
 * @author Abhijit.Daund
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error occurred. Please try again.") // 404
public class UnexpectedException extends BaseException {

    private static final long serialVersionUID = 1127271938507247398L;

    private static final String REASON_PHRASE = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

    /**
     * Creates and returns a new instance of this class initialized with given
     * parameters.
     * 
     * @param stackTraceElements
     *            the stack trace elements
     */
    public UnexpectedException(final StackTraceElement[] stackTraceElements) {
        super(REASON_PHRASE, Category.MESSAGE);
        setStackTrace(stackTraceElements);
    }
}

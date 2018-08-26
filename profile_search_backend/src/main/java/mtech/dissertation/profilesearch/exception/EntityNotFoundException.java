package mtech.dissertation.profilesearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Entity")
public class EntityNotFoundException extends BaseException {

    private static final long serialVersionUID = 7375408241902093073L;

    /**
     * Creates and returns a new instance of this class initialized with given
     * parameters.
     * 
     * @param entityName
     *            the entity name
     * @param id
     *            the id
     */
    public EntityNotFoundException(final String entityName, final String id) {
        super("No Such " + entityName + ": " + id, Category.MESSAGE);
    }
}

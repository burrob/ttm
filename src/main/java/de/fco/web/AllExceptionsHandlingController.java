/**
 *
 */
package de.fco.web;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller with an {@link ExceptionHandler} which catches all {@link Exception}s and returns the stack trace
 * including an {@link HttpStatus#BAD_REQUEST}.
 *
 * @author Ralf Hellriegel
 */
public class AllExceptionsHandlingController {

    /**
     * @param e exception which was thrown
     * @return stack trace of the catched exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleAllUnknownExceptions(final Exception e) {
        return ExceptionUtils.getStackTrace(e);
    }

}

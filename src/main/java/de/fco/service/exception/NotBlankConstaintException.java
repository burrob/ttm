/**
 *
 */
package de.fco.service.exception;

/**
 * @author Ralf Hellriegel
 */
public class NotBlankConstaintException extends ServiceException {

    private static final long serialVersionUID = -6667227675403983613L;

    public NotBlankConstaintException(final String msg) {
        super(msg);
    }

}

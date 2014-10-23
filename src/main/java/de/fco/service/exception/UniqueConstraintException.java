/**
 *
 */
package de.fco.service.exception;

/**
 * @author Ralf Hellriegel
 */
public class UniqueConstraintException extends ServiceException {

    private static final long serialVersionUID = -5335027848199361278L;

    public UniqueConstraintException(final String msg) {
        super(msg);
    }

}

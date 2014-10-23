/**
 *
 */
package de.fco.service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ralf Hellriegel
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = 2621819072893949170L;
    private final Logger log = LoggerFactory.getLogger(ServiceException.class);

    public ServiceException(final String msg) {
        super(msg);
        log.error(msg);
    }

}

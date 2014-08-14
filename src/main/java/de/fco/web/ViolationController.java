/**
 *
 */
package de.fco.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.fco.domain.Violation;
import de.fco.service.ViolationService;

/**
 * @author Ralf Hellriegel
 */
@RestController
@RequestMapping(value = "/violation")
public class ViolationController {

    private final ViolationService violationService;

    /**
     * @param violationService
     */
    @Autowired
    public ViolationController(final ViolationService violationService) {
        this.violationService = violationService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Violation> getAllViolations() {
        return violationService.findAllViolations();
    }

}

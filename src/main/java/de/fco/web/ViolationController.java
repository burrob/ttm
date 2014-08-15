/**
 *
 */
package de.fco.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

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
    public Map<String, List<Violation>> getAllViolations() {
        final List<Violation> allViolations = violationService.findAllViolationsOrderByCategory();

        final Map<String, List<Violation>> catalogue = Maps.newTreeMap();

        for (final Violation violation : allViolations) {
            if (!catalogue.containsKey(violation.getCategory().getName())) {
                catalogue.put(violation.getCategory().getName(), Lists.newArrayList(violation));
            } else {
                catalogue.get(violation.getCategory().getName()).add(violation);
            }
        }

        return catalogue;
    }

}

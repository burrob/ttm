package de.fco.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.fco.domain.Violation;
import de.fco.service.ViolationService;

/**
 * @author Ralf Hellriegel
 */
@RestController
@RequestMapping(value = "/admin/violation")
public class ViolationManagementController {

    private final ViolationService violationService;

    /**
     * @param violationService
     */
    @Autowired
    public ViolationManagementController(final ViolationService violationService) {
        this.violationService = violationService;
    }

    /**
     * Create a new {@link Violation} via {@link ViolationService#createViolation(Violation)}. The data should be
     * provided in the request payload.
     *
     * @param violation the new object to create in the database
     * @return the violation which was actually created
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Violation createViolation(@RequestBody final Violation violation) {
        final long categoryId = violation.getCategory().getId();
        violation.setCategory(violationService.findCategoryById(categoryId));

        final long currencyId = violation.getCurrency().getId();
        violation.setCurrency(violationService.findCurrencyById(currencyId));

        return violationService.createViolation(violation);
    }

}

package de.fco.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.fco.domain.ViolationCategory;
import de.fco.service.ViolationService;

/**
 * @author Ralf Hellriegel
 */
@RestController
@RequestMapping(value = "/admin/violation/category")
public class ViolationCategoryManagementController {

    private final ViolationService violationService;

    /**
     * @param violationService
     */
    @Autowired
    public ViolationCategoryManagementController(final ViolationService violationService) {
        this.violationService = violationService;
    }

    /**
     * @return all existing {@link ViolationCategory}s
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ViolationCategory> getAllCategories() {
        return violationService.findAllCategories();
    }

    /**
     * Create a new {@link ViolationCategory} via {@link ViolationService#createCategory(ViolationCategory)}. The data
     * should be provided in the request payload.
     *
     * @param violationCategory the new object to create in the database
     * @return the category which was actually created
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ViolationCategory createViolationCategory(@RequestBody final ViolationCategory violationCategory) {
        return violationService.createCategory(violationCategory);
    }

}

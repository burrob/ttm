package de.fco.web.admin;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import de.fco.domain.Currency;
import de.fco.domain.CurrencyDto;
import de.fco.domain.Violation;
import de.fco.domain.ViolationCategory;
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
     * @return all existing {@link ViolationCategory}s
     */
    @RequestMapping(value = "/category/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ViolationCategory> getAllCategories() {
        return violationService.findAllCategories();
    }

    /**
     * @return all constants of enum {@link Currency}
     */
    @RequestMapping(value = "/currency/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CurrencyDto> getAllCurrencies() {
        final List<Currency> currencyValues = Arrays.asList(Currency.values());
        return Lists.transform(currencyValues, new Function<Currency, CurrencyDto>() {
            @Override
            public CurrencyDto apply(final Currency currency) {
                return new CurrencyDto(currency.name(), currency.getSingular());
            }
        });
    }

    /**
     * Create a new {@link ViolationCategory} via {@link ViolationService#createCategory(ViolationCategory)}. The data
     * should be provided in the request payload.
     *
     * @param violationCategory the new object to create in the database
     * @return the category which was actually created
     */
    @RequestMapping(value = "/category/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ViolationCategory createViolationCategory(@RequestBody final ViolationCategory violationCategory) {
        return violationService.createCategory(violationCategory);
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
        final String categoryId = violation.getCategory().getName();
        violation.setCategory(violationService.findCategoryById(Long.valueOf(categoryId)));
        return violationService.createViolation(violation);
    }

}

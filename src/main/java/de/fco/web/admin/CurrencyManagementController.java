/**
 *
 */
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

import de.fco.domain.Currency;
import de.fco.service.ViolationService;

/**
 * @author Ralf Hellriegel
 */
@RestController
@RequestMapping(value = "/admin/violation/currency")
public class CurrencyManagementController {

    private final ViolationService violationService;

    /**
     * @param violationService
     */
    @Autowired
    public CurrencyManagementController(final ViolationService violationService) {
        this.violationService = violationService;
    }

    /**
     * @return all existing {@link Currency}s
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Currency> findAll() {
        return violationService.findAllCurrencies();
    }

    /**
     * Create a new {@link Currency} via {@link ViolationService#createCurrency(Currency)}. The data should be provided
     * in the request payload.
     *
     * @param currency the new object to create in the database
     * @return the currency which was actually created
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Currency createViolationCategory(@RequestBody final Currency currency) {
        return violationService.createCurrency(currency);
    }

}

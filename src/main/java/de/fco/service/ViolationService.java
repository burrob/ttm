package de.fco.service;

import java.util.List;

import de.fco.domain.Currency;
import de.fco.domain.Violation;
import de.fco.domain.ViolationCategory;

/**
 * @author Ralf Hellriegel
 */
public interface ViolationService {

    List<Violation> findAllViolations();

    List<ViolationCategory> findAllCategories();

    List<Currency> findAllCurrencies();

    ViolationCategory findCategoryById(Long id);

    Currency findCurrencyById(Long id);

    ViolationCategory createCategory(ViolationCategory category);

    List<ViolationCategory> createCategories(List<ViolationCategory> categories);

    Violation createViolation(Violation violation);

    List<Violation> createViolations(List<Violation> violation);

    Currency createCurrency(Currency currency);

    List<Currency> createCurrencies(List<Currency> currencies);

}

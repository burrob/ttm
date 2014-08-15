/**
 *
 */
package de.fco.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import de.fco.domain.Currency;
import de.fco.domain.Violation;
import de.fco.domain.ViolationCategory;
import de.fco.repository.CurrencyRepository;
import de.fco.repository.ViolationCategoryRepository;
import de.fco.repository.ViolationRepository;

/**
 * @author Ralf Hellriegel
 */
@Service
public class ViolationServiceImpl implements ViolationService {

    private final Logger log = LoggerFactory.getLogger(ViolationServiceImpl.class);

    private final ViolationCategoryRepository violationCategoryRepository;
    private final ViolationRepository violationRepository;
    private final CurrencyRepository currencyRepository;

    /**
     * @param violationCategoryRepository
     * @param violationRepository
     * @param currencyRepository
     */
    @Autowired
    public ViolationServiceImpl(final ViolationCategoryRepository violationCategoryRepository,
            final ViolationRepository violationRepository, final CurrencyRepository currencyRepository) {
        this.violationCategoryRepository = violationCategoryRepository;
        this.violationRepository = violationRepository;
        this.currencyRepository = currencyRepository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.ViolationService#findAll()
     */
    @Override
    public List<Violation> findAllViolations() {
        return (List<Violation>) violationRepository.findAll();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.fco.service.ViolationService#findAllCategories()
     */
    @Override
    public List<ViolationCategory> findAllCategories() {
        return (List<ViolationCategory>) violationCategoryRepository.findAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.ViolationService#findAllCurrencies()
     */
    @Override
    public List<Currency> findAllCurrencies() {
        return (List<Currency>) currencyRepository.findAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.ViolationService#findCategoryById(java.lang.Long)
     */
    @Override
    public ViolationCategory findCategoryById(final Long id) {
        return violationCategoryRepository.findOne(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.ViolationService#findCurrencyById(java.lang.Long)
     */
    @Override
    public Currency findCurrencyById(final Long id) {
        return currencyRepository.findOne(id);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.fco.service.ViolationService#createCategory(de.fco.domain.ViolationCategory)
     */
    @Override
    public ViolationCategory createCategory(final ViolationCategory category) {
        final ViolationCategory createdCategory = violationCategoryRepository.save(category);
        log.info("created " + createdCategory);
        return createdCategory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.ViolationService#createCategories(java.util.List)
     */
    @Override
    public List<ViolationCategory> createCategories(final List<ViolationCategory> categories) {
        final List<ViolationCategory> createdCategories = Lists.newArrayList();
        for (final ViolationCategory categoryToCreate : categories) {
            createdCategories.add(createCategory(categoryToCreate));
        }
        return createdCategories;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.fco.service.ViolationService#createViolation(de.fco.domain.Violation)
     */
    @Override
    public Violation createViolation(final Violation violation) {
        final Violation createdViolation = violationRepository.save(violation);
        log.info("created " + createdViolation);
        return createdViolation;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.fco.service.ViolationService#createViolations(java.util.List)
     */
    @Override
    public List<Violation> createViolations(final List<Violation> violations) {
        final List<Violation> createdViolations = Lists.newArrayList();
        for (final Violation violationToCreate : violations) {
            createdViolations.add(createViolation(violationToCreate));
        }
        return createdViolations;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.fco.service.ViolationService#createCurrency(de.fco.domain.Currency)
     */
    @Override
    public Currency createCurrency(final Currency currency) {
        final Currency createdCurrency = currencyRepository.save(currency);
        log.info("created " + currency);
        return createdCurrency;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.fco.service.ViolationService#createCurrencies(java.util.List)
     */
    @Override
    public List<Currency> createCurrencies(final List<Currency> currencies) {
        final List<Currency> createdCurrencies = Lists.newArrayList();
        for (final Currency currency : currencies) {
            createdCurrencies.add(createCurrency(currency));
        }
        return createdCurrencies;
    }

}

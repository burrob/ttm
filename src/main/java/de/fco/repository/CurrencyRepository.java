/**
 *
 */
package de.fco.repository;

import org.springframework.data.repository.CrudRepository;

import de.fco.domain.Currency;

/**
 * @author Ralf Hellriegel
 */
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

}

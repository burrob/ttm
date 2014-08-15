/**
 *
 */
package de.fco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.fco.domain.Violation;

/**
 * @author Ralf Hellriegel
 */
public interface ViolationRepository extends CrudRepository<Violation, Long> {

    @Query(value = "SELECT v FROM Violation v ORDER BY v.category.name,v.currency,v.amount")
    Iterable<Violation> findAllOrderByCategory();

}

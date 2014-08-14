/**
 *
 */
package de.fco.repository;

import org.springframework.data.repository.CrudRepository;

import de.fco.domain.Violation;

/**
 * @author Ralf Hellriegel
 */
public interface ViolationRepository extends CrudRepository<Violation, Long> {

}

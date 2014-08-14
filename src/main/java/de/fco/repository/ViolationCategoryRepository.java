/**
 *
 */
package de.fco.repository;

import org.springframework.data.repository.CrudRepository;

import de.fco.domain.ViolationCategory;

/**
 * @author Ralf Hellriegel
 */
public interface ViolationCategoryRepository extends CrudRepository<ViolationCategory, Long> {

}

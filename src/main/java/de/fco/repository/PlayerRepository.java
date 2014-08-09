/**
 * 
 */
package de.fco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.fco.domain.Player;

/**
 * @author Ralf Hellriegel
 */
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}

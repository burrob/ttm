/**
 *
 */
package de.fco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.fco.domain.Player;

/**
 * @author Ralf Hellriegel
 */
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    /**
     * @param email attribute to search for
     * @return the matching player if it exists in the repo
     */
    Player findByEmail(String email);

    /**
     * @return all players ordered by their first name
     */
    @Query(value = "SELECT p FROM Player p ORDER BY p.firstname")
    Iterable<Player> findAllOrderByFirstname();

}

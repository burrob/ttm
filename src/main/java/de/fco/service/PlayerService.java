/**
 *
 */
package de.fco.service;

import java.util.List;

import de.fco.domain.Player;
import de.fco.service.exception.ServiceException;

/**
 * @author Ralf Hellriegel
 */
public interface PlayerService {

    List<Player> findAll();

    List<Player> findAllOrderByFirstname();

    Player find(String playerId);

    Player save(Player player) throws ServiceException;

    Player update(Player player) throws ServiceException;

    List<Player> saveAll(List<Player> players);

    Player delete(String playerId);

}

/**
 *
 */
package de.fco.service;

import java.util.List;

import de.fco.domain.Player;

/**
 * @author Ralf Hellriegel
 */
public interface PlayerService {

    List<Player> findAll();

    Player find(String playerId);

    Player save(Player player);

    Player update(Player player);

    List<Player> saveAll(List<Player> players);

    Player delete(String playerId);

}

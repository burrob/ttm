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

	public List<Player> findAll();

	public Player find(String playerId);

	public Player save(Player player);

	public List<Player> saveAll(List<Player> players);

	/**
	 * @param playerId player to delete
	 * @return the player which was deleted
	 */
	public Player delete(String playerId);

}

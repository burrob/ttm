/**
 * 
 */
package de.fco.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.fco.domain.Player;
import de.fco.service.PlayerService;

/**
 * @author Ralf Hellriegel
 */
@RestController
@RequestMapping(value = "/player")
public class PlayerController {

	private final PlayerService playerService;

	/**
	 * @param playerService
	 */
	@Autowired
	public PlayerController(final PlayerService playerService) {
		this.playerService = playerService;
	}

	/**
	 * @return all existing players
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Player> getAllPlayers() {
		return playerService.findAll();
	}

	/**
	 * @param playerId
	 * @return
	 */
	@RequestMapping(value = "/{playerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Player getPlayer(@PathVariable final String playerId) {
		return playerService.find(playerId);
	}

}

/**
 *
 */
package de.fco.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.fco.domain.Player;
import de.fco.service.PlayerService;
import de.fco.service.exception.ServiceException;
import de.fco.web.AllExceptionsHandlingController;

/**
 * @author Ralf Hellriegel
 */
@RestController
@RequestMapping(value = "/admin/player")
public class PlayerManagementController extends AllExceptionsHandlingController {

    private final PlayerService playerService;

    /**
     * @param playerService
     */
    @Autowired
    public PlayerManagementController(final PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * Create a new player via {@link PlayerService#save(Player)}. The data should be provided in the request payload.
     *
     * @param player the new object to create in the database
     * @return the player which was actually created
     * @throws ServiceException
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Player createPlayer(@RequestBody final Player player) throws ServiceException {
        return playerService.save(player);
    }

    /**
     * Delete a player via {@link PlayerService#delete(String)}.
     *
     * @param playerId the database id of the player to delete
     * @return the player which was actually deleted
     */
    @RequestMapping(value = "/delete/{playerId}", method = RequestMethod.DELETE)
    public Player deletePlayer(@PathVariable final String playerId) {
        return playerService.delete(playerId);
    }

    /**
     * Update an existing player via {@link PlayerService#update(Player)}.
     *
     * @param player the object to update in the database
     * @return the updated player
     * @throws ServiceException
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Player updatePlayer(@RequestBody final Player player) throws ServiceException {
        return playerService.update(player);
    }

}

/**
 *
 */
package de.fco.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.primitives.Longs;

import de.fco.domain.Player;
import de.fco.repository.PlayerRepository;
import de.fco.service.exception.NotBlankConstaintException;
import de.fco.service.exception.ServiceException;
import de.fco.service.exception.UniqueConstraintException;

/**
 * @author Ralf Hellriegel
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    private final Logger log = LoggerFactory.getLogger(PlayerServiceImpl.class);

    private final PlayerRepository playerRepository;

    /**
     * @param playerRepository
     */
    @Autowired
    public PlayerServiceImpl(final PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.PlayerService#findAll()
     */
    @Override
    public List<Player> findAll() {
        return (List<Player>) playerRepository.findAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.PlayerService#findAllOrderByFirstname()
     */
    @Override
    public List<Player> findAllOrderByFirstname() {
        return (List<Player>) playerRepository.findAllOrderByFirstname();
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.PlayerService#find(long)
     */
    @Override
    public Player find(final String playerId) {
        Player player = null;
        if (Longs.tryParse(playerId) != null) {
            player = playerRepository.findOne(Longs.tryParse(playerId));
        }
        return player;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.PlayerService#save(de.fco.domain.Player)
     */
    @Override
    public Player save(final Player player) throws ServiceException {
        if (StringUtils.isBlank(player.getEmail())) {
            throw new NotBlankConstaintException("email must not be null");

        } else if (playerRepository.findByEmail(player.getEmail()) != null) {
            throw new UniqueConstraintException("email already exists");
        }

        final Player createdPlayer = playerRepository.save(player);
        log.info("created " + createdPlayer);
        return createdPlayer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.PlayerService#saveAll(java.util.List)
     */
    @Override
    public List<Player> saveAll(final List<Player> players) {
        final List<Player> createdPlayers = (List<Player>) playerRepository.save(players);
        log.info("created " + createdPlayers);
        return createdPlayers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.PlayerService#update(de.fco.domain.Player)
     */
    @Override
    public Player update(final Player player) throws ServiceException {
        final Player oldPlayerData = find(String.valueOf(player.getId()));
        log.info("update " + oldPlayerData);
        return save(player);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.fco.service.PlayerService#delete(java.lang.String)
     */
    @Override
    public Player delete(final String playerId) {
        final Player playerToDelete = playerRepository.findOne(Longs.tryParse(playerId));
        playerRepository.delete(playerToDelete);
        log.info("deleted " + playerToDelete);
        return playerToDelete;
    }

}

/**
 * 
 */
package de.fco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.primitives.Longs;

import de.fco.domain.Player;
import de.fco.repository.PlayerRepository;

/**
 * @author Ralf Hellriegel
 */
@Service
public class PlayerServiceImpl implements PlayerService {

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
	public Player save(final Player player) {
		return playerRepository.save(player);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fco.service.PlayerService#saveAll(java.util.List)
	 */
	@Override
	public List<Player> saveAll(final List<Player> players) {
		return (List<Player>) playerRepository.save(players);
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
		return playerToDelete;
	}

}

package de.fco;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import de.fco.domain.Player;
import de.fco.service.PlayerService;

/**
 * @author Ralf Hellriegel
 */
@Component
public class ImportTestData {

	private final PlayerService playerService;

	/**
	 * @param playerService
	 */
	@Autowired
	public ImportTestData(final PlayerService playerService) {
		this.playerService = playerService;
	}

	@PostConstruct
	public void importData() {
		final List<Player> players = Lists.newArrayList();
		players.add(new Player("Ralf", "Hellriegel", "ralfhellriegel@gmx.de"));
		players.add(new Player("Kalle", "Grabowski", "kalle@grabowski.org"));
		players.add(new Player("Zinedine", "Zidane", "zizu@fifa.com"));
		players.add(new Player("Lothar", "Matthäus", "loddar@bayern.by"));
		players.add(new Player("Zlatan", "Ibrahimovic", "zlatan@psg.se"));
		players.add(new Player("Olli", "Kahn", "der-motivator@fb.de"));
		players.add(new Player("Mats", "Hummels", "mats@bvb.de"));
		players.add(new Player("Franz", "Beckenbauer", "franz.der-kaiser@olympusmail.de"));
		players.add(new Player("Roberto", "Carlos", "roberto@brasil.com"));
		players.add(new Player("Rudi", "Völler", "kaethe@bayer.de"));
		players.add(new Player("Vinnie", "Jones", "the-axe@psycho.uk"));
		players.add(new Player("Paul", "Gascoine", "paul.g@gmail.com"));
		playerService.saveAll(players);
	}

}

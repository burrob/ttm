package de.fco;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import de.fco.domain.Currency;
import de.fco.domain.Player;
import de.fco.domain.Violation;
import de.fco.domain.ViolationCategory;
import de.fco.service.PlayerService;
import de.fco.service.ViolationService;

/**
 * @author Ralf Hellriegel
 */
@Component
public class ImportTestData {

    private final PlayerService playerService;
    private final ViolationService violationService;

    /**
     * @param playerService
     * @param violationService
     */
    @Autowired
    public ImportTestData(final PlayerService playerService, final ViolationService violationService) {
        this.playerService = playerService;
        this.violationService = violationService;
    }

    @PostConstruct
    public void importData() {
        importPlayers();
        importCurrencies();
        importViolationCategories();
        importViolations();
    }

    private void importPlayers() {
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

    private void importCurrencies() {
        final List<Currency> currencies = Lists.newArrayList();
        currencies.add(new Currency("€", "Euro", "Euro"));
        currencies.add(new Currency("B", "Bier", "Bier"));
        currencies.add(new Currency("BK", "Kiste Bier", "Kisten Bier"));
        violationService.createCurrencies(currencies);
    }

    private void importViolationCategories() {
        final List<ViolationCategory> categories = Lists.newArrayList();
        categories.add(new ViolationCategory("Training"));
        categories.add(new ViolationCategory("Spiel"));
        categories.add(new ViolationCategory("Sonstiges"));
        violationService.createCategories(categories);
    }

    private void importViolations() {
        final List<ViolationCategory> categories = violationService.findAllCategories();
        final List<Currency> currencies = violationService.findAllCurrencies();

        final List<Violation> violations = Lists.newArrayList();
        violations.add(new Violation("Rauchen im Trikot", categories.get(1), currencies.get(0), 5));
        violations.add(new Violation("Bier im Trikot", categories.get(1), currencies.get(0), 5));
        violations.add(new Violation("Kleidung vergessen", categories.get(0), currencies.get(1), 1));
        violations.add(new Violation("Gelbe Karte, Unsportlichkeit", categories.get(1), currencies.get(2), 1));
        violations.add(new Violation("Rote Karte, Unsportlichkeit", categories.get(1), currencies.get(0), 50));
        violations.add(new Violation("Zu Spät", categories.get(0), currencies.get(0), 2));
        violationService.createViolations(violations);
    }

}

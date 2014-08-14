/**
 *
 */
package de.fco.domain;

/**
 * @author Ralf Hellriegel
 */
public enum Currency {

    EURO("€", "Euro", "Euro"), //
    BEER("B", "Bier", "Bier"), //
    BEER_CRATE("BK", "Kiste Bier", "Kisten Bier");

    private final String symbol;
    private final String singular;
    private final String plural;

    /**
     * @param symbol
     * @param singular
     * @param plural
     */
    private Currency(final String symbol, final String singular, final String plural) {
        this.symbol = symbol;
        this.singular = singular;
        this.plural = plural;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return the singular
     */
    public String getSingular() {
        return singular;
    }

    /**
     * @return the plural
     */
    public String getPlural() {
        return plural;
    }

}

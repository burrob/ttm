/**
 *
 */
package de.fco.domain;

/**
 * @author Ralf Hellriegel
 */
public class CurrencyDto {

    private final String name;
    private final String singular;

    /**
     * @param name
     * @param singular
     */
    public CurrencyDto(final String name, final String singular) {
        this.name = name;
        this.singular = singular;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the singular
     */
    public String getSingular() {
        return singular;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("CurrencyDto [name=%s, singular=%s]", name, singular);
    }

}

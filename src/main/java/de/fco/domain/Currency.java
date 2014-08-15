/**
 *
 */
package de.fco.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Ralf Hellriegel
 */
@Entity
public class Currency {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 1, max = 3)
    private String code;

    @NotNull
    private String name;

    @NotNull
    private String plural;

    public Currency() {
        // NOP
    }

    /**
     * @param code
     * @param name
     * @param plural
     */
    public Currency(final String code, final String name, final String plural) {
        this.code = code;
        this.name = name;
        this.plural = plural;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the plural
     */
    public String getPlural() {
        return plural;
    }

    /**
     * @param plural the plural to set
     */
    public void setPlural(final String plural) {
        this.plural = plural;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Currency [id=%s, code=%s, name=%s, plural=%s]", id, code, name, plural);
    }

}

/**
 *
 */
package de.fco.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Ralf Hellriegel
 */
@Entity
public class ViolationCategory {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    public ViolationCategory() {
        // NOP
    }

    /**
     * @param name
     */
    public ViolationCategory(final String name) {
        this.name = name;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("ViolationCategory [id=%s, name=%s]", id, name);
    }

}

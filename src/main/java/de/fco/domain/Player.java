/**
 *
 */
package de.fco.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Ralf Hellriegel
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class Player {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    private String email;

    public Player() {
        // NOP
    }

    /**
     * @param firstname
     * @param lastname
     * @param email
     */
    public Player(final String firstname, final String lastname, final String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
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
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Player [id=%s, firstname=%s, lastname=%s, email=%s]", id, firstname, lastname, email);
    }

}

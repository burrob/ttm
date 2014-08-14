/**
 *
 */
package de.fco.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Ralf Hellriegel
 */
@Entity
public class Violation {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    @NotNull
    private ViolationCategory category;

    @NotNull
    private String name;

    @NotNull
    private double amount;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Currency currency;

    public Violation() {
        // NOP
    }

    /**
     * @param name
     * @param category
     * @param currency
     */
    public Violation(final String name, final ViolationCategory category, final Currency currency, final double amount) {
        this.name = name;
        this.category = category;
        this.currency = currency;
        this.amount = amount;
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
     * @return the category
     */
    public ViolationCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(final ViolationCategory category) {
        this.category = category;
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
     * @return the currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(final Currency currency) {
        this.currency = currency;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(final double amount) {
        this.amount = amount;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Violation [id=%s, category=%s, name=%s, amount=%s, currency=%s]", id, category, name,
                amount, currency);
    }

}

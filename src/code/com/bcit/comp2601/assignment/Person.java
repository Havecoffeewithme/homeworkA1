/**
 * The following is a Person Class , with instances and performs various methods.
 * It implements the Comparable interface
 *
 * @author : Percy Ratheko
 *
 * Version 2.0.
 */

package com.bcit.comp2601.assignment;

public abstract class Person implements Comparable<Person>
{
    private final Date born;

    private Date died;

    private final Name name;


    /**
     * Constructor
     *
     * @param born : when the person was born
     * @param name : the name of the person
     */
    public Person(final Date born,
                  final Name name)
    {
        validatePerson(born,name);
        this.born = born;
        this.name = name;
    }

    /**
     * Getter method for born
     *
     * @return : returns the born.
     */
    public Date getBorn()
    {
        return born;
    }

    /**
     * Getter method for name.
     *
     * @return : returns the name.
     */
    public Name getName()
    {
        return name;
    }

    /**
     * Getter method for Died.
     *
     * @return : returns the died.
     */
    public Date getDied()
    {
        return died;
    }

    /**
     *  this method sets the died instance variable to the dateOfDeath provided.
     *
     * @param dateOfDeath : date of death
     */
    public void die(final Date dateOfDeath)
    {
        this.died = dateOfDeath;
    }


    /**
     * this method returns true if the Person is alive; otherwise returns false.
     *
     * @return : True / false
     */
    public boolean isAlive()
    {
        if(died == null )
        {
            return true;
        }
        return false;

    }

    /**
     * Validates Person.
     *
     * @param born : date of birth
     * @param name : name of the person
     */
    public static void validatePerson(final Date born, final Name name)
    {
        if( name == null || born == null)
        {
            throw new IllegalPersonException("Invalid person ");
        }

    }

    /**
     *this method satisfies the requirements from implementing the Comparable
     * interface. Younger people are "larger". Note: this method must use its born variable's compareTo(Date d) meth
     *
     * @param p the object to be compared.
     * @return : returns
     */
    @Override
    public int compareTo(Person p)
    {
        return p.born.compareTo(this.born);
    }


    /**
     * This class overrides the public String toString() method, which returns a String in one of these two exact formats:
     * a) Alive people example: "Tiger Woods (specialty: mathematics) was born 1975-12-30 and is still alive"
     * b) Dead people example: "Albert Einstein (specialty: mathematics) was born 1879-03-14 and died 1955-04-1
     *
     * @return : returns formatted string
     */

    @Override
    public String toString() {
        if (isAlive()) {
            return name.getPrettyName() + " was born " + born.getYyyyMmDd() + " and is still alive";
        } else {
            return name.getPrettyName() + " was born " + born.getYyyyMmDd() + " and died " + died.getYyyyMmDd();
        }
    }


}

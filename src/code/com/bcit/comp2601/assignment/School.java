/**
 * The following class represents the School class
 *
 * @author : Percy Ratheko
 *
 * Version 2.0
 */

package com.bcit.comp2601.assignment;


import java.util.ArrayList;
import java.util.List;

public class School {

    public static final int CURRENT_YEAR;

    static
    {
        CURRENT_YEAR = 2022;
    }

    private final List<Person> persons;

    {
        persons = new ArrayList<>();
    }

    /**
     * this method throws an IllegalPersonException if the argument is null. Otherwise, the
     * Person is added to the end of your List
     * @param person : person to be added to the list.
     */
    public void register(final Person person)
    {
        if (person == null)
        {
            throw new IllegalPersonException("Person cannot be null");
        }
        persons.add(person);
    }


    /**
     * this method uses a method reference to print out all the people (i.e. triggering a call to
     * their respective toString() methods).
     */
    public void printRoster()
    {
        persons.forEach(System.out::println);
    }



    /**
     * This method declares a local variable w of type Writeable, which takes three
     * parameters: fullName, yearBorn, and maxYear; for example: "Tiger Woods", 1975, 2022, or "Albert Einstein", 1879,
     * 1955. It uses a lambda expression to loop through the integers from yearBorn to maxYear and prints the person's
     * name and age for each year of life
     */
    public void printAgesAndYears() {
        Writeable w = (fullName, yearBorn, maxYear) -> {
            for (int year = yearBorn; year <= maxYear; year++)
            {
                System.out.println(fullName + ": " + year + " (age " + (year - yearBorn) + ")");
            }
        };

        persons.forEach(person -> {
            String fullName = person.getName().getPrettyName();
            int yearBorn = person.getBorn().getYear();
            int maxYear = person.isAlive() ? CURRENT_YEAR : person.getDied().getYear();
            w.printData(fullName, yearBorn, maxYear);
        });
    }
}
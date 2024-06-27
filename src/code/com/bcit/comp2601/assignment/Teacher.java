/**
 *This class extends the Person class. It also has an additional instance variable and its accessor method: String
 * specialty and public String getSpecialty().
 * public Teacher (Date born, Name name, String specialty): this constructor throws IllegalPersonException exceptions
 * if born or name is null. Also, it throws an IllegalPersonException exception if specialty is blank.
 *
 * @author : Percy Ratheko
 *
 * Version 2.0
 */

package com.bcit.comp2601.assignment;

public class Teacher extends Person
{
    private final String specialty;


    /**
     * Constructor.
     *
     * @param born       : date of birth of the teacher.
     * @param name       : The name of the teacher.
     * @param specialty  : The speciality of the teacher.
     */
    public Teacher(final Date born,
                   final Name name,
                   final String specialty)
    {
        super(born, name);
        validatePerson(born, name);
        validateSpecialty(specialty);
        this.specialty = specialty;
    }


    /**
     * Getter method for specialty.
     *
     * @return : returns the specialty.
     */
    public String getSpeciality()
    {
        return specialty;
    }

    /**
     * Validates the specialty.
     *
     * @param speciality : the specialty of the teacher.
     */
    public void validateSpecialty(final String speciality)
    {
        if(speciality.isBlank())
        {
            throw new IllegalPersonException("Invalid specialty: " + speciality);

        }
    }

    /**
     *This class overrides the public String toString() method, which returns a String in one of these two exact formats:
     * a) Alive people example: "Tiger Woods (student number: A12345678) was born 1975-12-30 and is still alive"
     * b) Dead people example: "Albert Einstein (student number: A87654321) was born 1879-03-14 and died 1955-
     * 04-18"
     *
     * @return : returns the formatted string
     */
    @Override
    public String toString()
    {
        if (isAlive())
        {
            return getName().getPrettyName() + "(specialty: "+getSpeciality()+")" + " was born " + getBorn().getYyyyMmDd() + " and is still alive";
        } else {
            return getName().getPrettyName()+ "(specialty : "+getSpeciality()+")" + " was born " + getBorn().getYyyyMmDd() + " and died " + getDied().getYyyyMmDd();
        }
    }


}

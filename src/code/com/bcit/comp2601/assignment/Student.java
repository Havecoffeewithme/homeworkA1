/**
 * The following class represents the Student class with its attributes.
 * It extends the Person class
 *
 * @author : Percy Ratheko
 *
 * Version 2.0
 */

package com.bcit.comp2601.assignment;

import java.util.regex.Pattern;

public class Student extends Person
{

    private final String StudentNumber;

    private static final Pattern STUDENT_PATTERN = Pattern.compile("[a-zA-Z0-9]{9}");

    /**
     * Constructor
     *
     * @param born          : when the student was born.
     * @param name          : The name of the student
     * @param studentNumber : The student number
     */
    public Student(final Date born,
                   final Name name,
                   final String studentNumber)
    {

        super(born, name);
        validatePerson(born, name);
        validateStudentNumber(studentNumber);
        StudentNumber = studentNumber;
    }

    /**
     * Getter method for student number.
     *
     * @return : returns the student number.
     */
    public String getStudentNumber()
    {
        return StudentNumber;
    }


    /**
     * the method validates the student number.
     *
     * @param studentNumber : the student number.
     */
    public static void validateStudentNumber(final String studentNumber)
    {
        if( studentNumber == null || studentNumber.isBlank() || !STUDENT_PATTERN.matcher(studentNumber).matches() )
        {
            throw new IllegalPersonException("Invalid student number " + studentNumber);
        }

    }


    /**
     * overrides the public String toString() method, which returns a String in one of these two exact formats:
     * a) Alive people example: "Tiger Woods (student number: A12345678) was born 1975-12-30 and is still alive"
     * b) Dead people example: "Albert Einstein (student number: A87654321) was born 1879-03-14 an
     *
     * @return : returns a formatted string.
     */

    @Override
    public String toString() {
        if (isAlive()) {
            return getName().getPrettyName() + "(student number: "+getStudentNumber()+")" + " was born " + getBorn().getYyyyMmDd() + " and is still alive";
        } else {
            return getName().getPrettyName()+ "(student number: "+getStudentNumber()+")" + " was born " + getBorn().getYyyyMmDd() + " and died " + getDied().getYyyyMmDd();
        }
    }







}

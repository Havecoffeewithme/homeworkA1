/**
 * The Class represents the name class with final instances and accessor methods.
 * It performs various methods.
 *
 * @uthor : Percy Ratheko.
 *
 * version 2.0.
 */


package com.bcit.comp2601.assignment;

public class Name
{
    private final String first;

    private final String last;

    private static final int FIRST_LETTER_INDEX;

    private static final int SECOND_LETTER_INDEX;

    static
    {
        FIRST_LETTER_INDEX = 0;
        SECOND_LETTER_INDEX = 1;
    }


    /**
     * Constructor
     * @param first : the first name
     * @param last  : the last name
     */
    public Name(final String first,
                final String last)
    {
        validateName(first,last);
        this.first = first;
        this.last = last;
    }

    // returns first name
    public String getFirst()
    {
        return first;
    }

    // returns last name
    public String getLast()
    {
        return last;

    }


    /**
     * getPrettyName method
     *
     * @return : returns formatted full name.
     */
    public String getPrettyName()
    {
        return first.toUpperCase().charAt(FIRST_LETTER_INDEX) +
                first.toLowerCase().substring(SECOND_LETTER_INDEX) + " " +
                last.toUpperCase().charAt(FIRST_LETTER_INDEX) +
                last.toLowerCase().substring(SECOND_LETTER_INDEX);
    }

    /**
     * getInitials method
     *
     * @return : return the initials of the provided full name.
     */
    public String getInitials()
    {
        return first.toUpperCase().charAt(FIRST_LETTER_INDEX) + "." + last.toUpperCase().charAt(FIRST_LETTER_INDEX);
    }


    /**
     * Validates the first and last name data.
     *
     * @param first : first name.
     * @param last  : last name.
     */
    public static void validateName(final String first, final String last)
    {
        if(first == null || first.isBlank() || last == null || last.isBlank())
        {
            throw new IllegalArgumentException();
        }
    }




}

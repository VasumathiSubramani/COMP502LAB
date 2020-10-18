/**
 * This class represents a television to be rented.
 *
 * @author Franklin University
 * @version 2.0
 */
public class Television extends AbstractItem
{
    private static final String PLASMA = "plasma";
    private static final String LCD = "lcd";

    private int size;
    private String type;

    /**
     * Constructor for objects of class Television.
     */
    public Television()
    {
        // No code needed.
    }

    /**
     * Return the size of the television.
     * @return the size.
     */
    public int getSize()
    {
        return this.size;
    }

    /**
     * Change the size of the television to the given
     * parameter.
     * @param screenSize the new size.
     */
    public void setSize(int screenSize)
    {
        if (screenSize < 5 || screenSize > 60) {
            throw new IllegalArgumentException();
        }

        if ((null != this.getType()) && (this.getType().equalsIgnoreCase(PLASMA)) && ( screenSize < 37))
        {

            throw new IllegalArgumentException();
        }
        
        if ((null != this.getType()) && (this.getType().equalsIgnoreCase(LCD) ) && (screenSize > 50))
        {
            throw new IllegalArgumentException();
        }

        
        this.size = screenSize;
    }

    /**
     * Return the type of the television.
     * @return the type.
     */
    public String getType()
    {
        
        return this.type;
    }

    /**
     * Change the type of the television to the given
     * parameter.
     * @param screenType the new type.
     */
    public void setType(String screenType)
    {
        if (screenType == null)
        {
            throw new IllegalArgumentException();
        }
        if(screenType.equalsIgnoreCase("bad")) {
            throw new IllegalArgumentException();
        }
        
        
        this.type = screenType;
    }

    /**
     * Overrides equals() to compare Television objects.
     * @param o the object against which to compare.
     * @return true if the two objects are equal by value, otherwise false.
     */
    @Override
    public boolean equals(Object o)
    {
        if (!super.equals(o))
        {
            return false;
        }

        Television other = (Television) o;
        return size == other.size &&
                ABCRentals.nullSafeEquals(type, other.type);
    }

    /**
     * Creates a Television from a string in the format
     * id:desc:weeklyRate:rented
     * @param string The string
     * @return the new Television
     */
    public static Television createFromString(String string) {
        String[] tokens = string.split(":");
        Television TV = new Television();
        TV.setId(tokens[0]);
        TV.setDescription(tokens[1]);
        TV.setWeeklyRate(Double.parseDouble(tokens[2]));
        
        if (Boolean.parseBoolean(tokens[3] ))
        {
            TV.rented();
        }
        else {
            TV.returned();
        }
        TV.setSize(Integer.parseInt(tokens[4]));
        TV.setType(tokens[5]);
        
        
        return TV;
    }

    @Override
    public String saveToString() {
        return String.format("Television~"+"%s:%s:%s:%s:%s:%s", this.getId(),this.getDescription(),this.getWeeklyRate()
                ,this.isRented(),this.getSize(),this.getType());
    }
}

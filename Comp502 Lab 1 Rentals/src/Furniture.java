
/**
 * This class represents a furniture item for rent.
 *
 * @author Franklin University
 * @version 2.0
 */
public class Furniture extends AbstractItem
{
    private double monthlyRate;

    /**
     * Constructor for objects of class Furniture.
     */
    public Furniture()
    {
        // No code needed
    }

   /**
     * Return the monthly rental rate for the furniture
     * item.
     * @return the rate.
     */
    public double getMonthlyRate()
    {
        return this.monthlyRate;
    }

    /**
     * Change the monthly rental rate of the furniture item
     * to the given parameter.
     * @param mnthlyRate the new weekly rate.
     */
    public void setMonthlyRate(double mnthlyRate)
    {
        if (mnthlyRate <= 0)
        {
            throw new IllegalArgumentException();
        }
        this.monthlyRate = mnthlyRate;
    }

    /**
     * Calculate the fees for renting the furniture for a given
     * number of weeks. If the number of weeks is 4 or more, the
     * monthly rate is charged for each 4 week period. For example, if
     * the furniture item is rented for 6 weeks, the rental fee will
     * be the monthly fee plus 2 X the weekly fee. Both the weekly
     * rate and the monthly rate must be set and the number of rental
     * weeks must be valid in order for the fee to be calculated.
     * @param weeks the number of rental weeks
     * @return 
     */
    @Override
    public double calculateFee(int weeks)
    {
        if (weeks > 0 & this.monthlyRate != 0) {
            
            return (weeks / 4) * this.monthlyRate + (weeks % 4) * super.getWeeklyRate();
        }
        return 0;
     
       
    }

    /**
     * Overrides equals() to compare Furniture objects.
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

        Furniture other = (Furniture) o;
        return ABCRentals.nullSafeEquals(monthlyRate, other.monthlyRate);
    }

    /**
     * Creates a Furniture from a string in the format
     * id:desc:weeklyRate:rented:monthlyRate
     * @param string The string
     * @return the new DVDPlayer
     */
    public static Furniture createFromString(String string) {
        
        String tokens[] = string.split(":");
        Furniture fur = new Furniture();
        fur.setId(tokens[0]);
        fur.setDescription(tokens[1]);
        fur.setWeeklyRate(Double.parseDouble(tokens[2]));
        fur.setMonthlyRate(Double.parseDouble(tokens[4]));
        if (Boolean.parseBoolean(tokens[3]))
        {
            fur.rented();
        }
        else
        {
            fur.returned();
        }
        
        return fur;
    }

    @Override
    public String saveToString() {
        
        return String.format("Furniture~"+"%s:%s:%s:%s:%s",this.getId(),this.getDescription(),this.getWeeklyRate(),this.isRented(),this.getMonthlyRate());
    }
}

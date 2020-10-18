/**
 * This class represents an abstract item to be rented.
 *
 * @author Franklin University
 * @version 2.0
 */
public abstract class AbstractItem implements Item
{
    // Instance variables
    private String description;
    private double weeklyRate;
    private String id;
    private boolean rentalStatus;
    
//    public AbstractItem(String description,double weeklyRate,String id,boolean rentalStatus)
//    {
//        this.description = description;
//        this.weeklyRate = weeklyRate;
//        this.id = id;
//        this.rentalStatus = rentalStatus;
//    }

   /**
     * Return the description of the item.
     * @return the description.
     */
    @Override
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Change the description of the item to the
     * given parameter.
     * @param desc the new description.
     */
    @Override
    public void setDescription(String desc)
    {
        if (desc == null || desc == "") {
            throw new IllegalArgumentException();
        }
        this.description = desc;
    }

   /**
     * Return the weekly rental rate for the item.
     * @return the rate.
     */
    @Override
    public double getWeeklyRate()
    {
        return this.weeklyRate;
    }

    /**
     * Change the weekly rental rate of the item
     * to the given parameter.
     * @param wklyRate the new weekly rate.
     */
    @Override
    public void setWeeklyRate(double wklyRate)
    {
        if (wklyRate <= 0 ) {
            throw new IllegalArgumentException();
        }
        this.weeklyRate = wklyRate;
    }

    /**
     * Return the ID of the item.
     * @return the ID.
     */
    @Override
    public String getId()
    {
        return this.id;
    }

    /**
     * Change the ID of the item to the given
     * parameter.
     * @param idNum the new ID.
     */
    @Override
    public void setId(String idNum)
    {
        
        
        if (idNum == null || idNum =="") 
        {
            throw new IllegalArgumentException();
        }
        
        if (idNum.matches("[0-9]+"))
        {           
            double num = Double.parseDouble(idNum);
            if(num > 0) 
            {
                this.id = idNum;
            } 
            else {
                throw new IllegalArgumentException();
            }
                        
        }
        else {
            throw new IllegalArgumentException();
        }
        
    }

    /**
     * Calculate the fees for renting the item for a given
     * number of weeks.
     * @param weeks the number of rental weeks
     * @return the fee
     */
    @Override
    public double calculateFee(int weeks)
    {
        if (weeks > 0) {
            
            return weeks * this.weeklyRate;  
        }
        return 0;
    }

    /**
     * Indicate the item has been rented.
     */
    @Override
    public void rented()
    {
        this.rentalStatus = true;
    }

    /**
     * Indicate the item has been returned and is no
     * longer rented.
     */
    @Override
    public void returned()
    {
        this.rentalStatus = false;
    }

    /**
     * Return the rental status of the item.
     * @return true if the item is rented, otherwise false.
     */
    @Override
    public boolean isRented()
    {
        return this.rentalStatus;
    }

    /**
     * Overrides equals() to compare AbstractItem objects.
     * @param o the object against which to compare.
     * @return true if the two objects are equal by value, otherwise false.
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }

        AbstractItem other = (AbstractItem) o;
        return rentalStatus == other.rentalStatus &&
                ABCRentals.nullSafeEquals(weeklyRate, other.weeklyRate) &&
                ABCRentals.nullSafeEquals(description, other.description) &&
                ABCRentals.nullSafeEquals(id, other.id);
    }
}

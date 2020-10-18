
/**
 * This class is a lookup that matches items whose rental status
 * matches the status passed into the constructor when creating
 * the instance of the lookup.
 *
 * @author Franklin University
 * @version 2.0
 */
public class RentalStatusLookup implements Lookup
{
    private boolean lookupStatus;

    /**
     * Constructor for objects of class RentalStatusLookup.
     * @param status the status for rental
     */
    public RentalStatusLookup(boolean status)
    {
        this.lookupStatus = status;
    }

    /**
     * Indicates whether the item's rental status matches
     * the rental status passed into the contructor.
     * @param item the item being checked for a match.
     * @return true if the rental status of the item matches, otherwise
     * false.
     */
    @Override
    public boolean matches(Item item)
    {
        return ABCRentals.nullSafeEquals(this.lookupStatus, item);
    }
}

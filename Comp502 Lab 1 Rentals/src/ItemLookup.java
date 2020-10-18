
/**
 * This class is a lookup that matches items that exactly match
 * a specified item, to be passed into the constructor when creating
 * the instance of the lookup.
 *
 * @author Franklin University
 * @version 2.0
 */
public class ItemLookup implements Lookup
{
    private Item theItem;

    /**
     * Constructor for objects of class IdLookup.
     * @param item the item to lookup.
     */
    public ItemLookup(Item item)
    {
        this.theItem = item;
    }

    /**
     * Indicates whether the item exactly matches the item
     * passed into the contructor.
     * @param item the item being checked for a match.
     * @return true if the item matches, otherwise
     * false.
     */
    @Override
    public boolean matches(Item item)
    {
        
        return ABCRentals.nullSafeEquals(this.theItem, item);
    }
}

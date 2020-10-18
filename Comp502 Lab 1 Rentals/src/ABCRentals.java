import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the inventory system for ABC Rentals.
 *
 * @author Franklin University
 * @version 2.0
 */
public class ABCRentals implements Inventory
{
    private Item[] items;
    private int numItems = 0;
    private int nextId = 1;

    /**
     * Zero arg constructor.
     */
    public ABCRentals()
    {
        items = new Item[MAX_ITEMS];
    }

    /**
     * Add an item to the inventory.  The parameter item
     * should not be something already in the inventory.  As a
     * result of adding an item, the item will be assigned an ID starting
     * with 1 and increasing by 1 for each item added.  IDs
     * are not reused.  All items are kept
     * in a database internal to the inventory so that they may be searched
     * for using a query.
     * @param item the item to add.
     * @return true when the item is added, false if the item cannot
     * be added for any reason.
     */
    @Override
    public boolean add(Item item)
    {
        if ((item != null) && (numItems < items.length))
        {
            items[numItems++] = item;
            item.setId("" + nextId++);
            return true;
        }
        return false;
    }

    /**
     * Remove an item.  The id should be the id of
     * an item in the inventory.  The item with the
     * specified id is located in inventory and removed.
     * @param id the id of the item to remove.
     * @return true if the item was found and removed, false otherwise.
     */
    @Override
    public boolean remove(String id)
    {
        for (int i = 0 ; i < numItems ; i++ )
        {
            Item object = items[i];

            if (object.getId().equals(id))
            {
                items[i] = null;
                for (int j = i ; j < (numItems - 1) ; j++ )
                {
                    items[j] = items[j + 1]; //Copy the next one into this slot
                }
                items[numItems - 1] = null; //Mark the last one null

                numItems--; //Decrement numItems to reflect new empty slot

                return true;
            }
        }
        return false;
    }

    /**
     * Return the number of items presently in inventory.
     * @return the number of items.
     */
    @Override
    public int getItemCount()
    {
        return numItems;
    }

     /**
     * Create and return a list of items that match the given query
     * criteria.  The query will identify which items match.
     * @param query a query indicating which items to find.
     * @return a list of matching items.
     */
    @Override
    public List<Item> findItems(Lookup query)
    {
        ArrayList<Item> matches = new ArrayList<Item>();        
                
        for(Item item: items) {
            
            if(query.matches(item)) {
                matches.add(item);

            }
        }

        return matches;
    }

    /**
     * Rent an item in inventory. The rental fee for the item is
     * calculated, and the item is marked as rented.
     * @param id the id of the item to be rented.
     * @param weeks the number of weeks the item is to be rented.
     * @return the rental fee if the item was available for rent,
     * zero otherwise.
     */
    public double rent(String id, int weeks)
    {
        for (int i = 0 ; i < numItems ; i++ )
        {
            Item object = items[i];
            if (object.getId().equals(id))
            {
                if (object.isRented())
                {
                    //Already rented
                    return 0;
                }

                object.rented();
                return object.calculateFee(weeks);
            }
        }
        return 0;
    }

    /**
     * Return a rented item to inventory. The item is marked as not
     * rented. Note that if the item isn't already rented, it cannot
     * be restocked.
     * @param id the id of the restocked item.
     * @return true if the item was sucessfully returned to inventory,
     * false otherwise.
     */
    public boolean restock(String id)
    {
        for (int i = 0 ; i < numItems ; i++ )
        {
            Item object = items[i];
            if (object.getId().equals(id))
            {
                if (object.isRented())
                {
                    object.returned();
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if the objects are both null,
     * or comparing them with equals() returns true.
     * @param o1 object 1
     * @param o2 object 2
     * @return the result
     */
    public static boolean nullSafeEquals(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }

        if (o2 == null) {
            return false;
        }

        return o1.equals(o2);
    }
}

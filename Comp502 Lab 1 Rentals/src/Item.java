
/**
 * This interface shows what data an item must contain to work within
 * this system.  Implementing this interface allows the item to be easily
 * dropped into the system.
 *
 * @author Franklin University
 * @version 2.0
 */

public interface Item
{
   /**
     * Return the description of the item.
     * @return the description.
     */
    String getDescription();

    /**
     * Change the description of the item to the given parameter.
     * @param desc the new description.
     */
    void setDescription(String desc);

   /**
     * Return the weekly rental rate for the item.
     * @return the rate.
     */
    double getWeeklyRate();

    /**
     * Change the weekly rental rate of the item to the given parameter.
     * @param wklyRate the new weekly rate.
     */
    void setWeeklyRate(double wklyRate);

    /**
     * Return the ID of the item.
     * @return the ID.
     */
    String getId();

    /**
     * Change the ID of the item to the given parameter.
     * @param idNum the new ID.
     */
    void setId(String idNum);

    /**
     * Calculate the fees for renting the item for a given
     * number of weeks.
     * @param weeks the number of rental weeks
     * @return the fee
     */
    double calculateFee(int weeks);

    /**
     * Indicate the item has been rented.
     */
    void rented();

    /**
     * Indicate the item has been returned and is no
     * longer rented.
     */
    void returned();

    /**
     * Return the rental status of the item.
     * @return true if the item is rented, otherwise false.
     */
    boolean isRented();

    /**
     * Converts an item to a string that can be saved to a file.
     * @return the string
     */
    String saveToString();

}

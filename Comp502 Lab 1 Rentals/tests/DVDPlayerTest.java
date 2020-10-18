
/**
 * The test class DVDPlayerTest.
 *
 * @author  Franklin University
 * @version 2.0
 */
public class DVDPlayerTest extends AbstractItemTest
{

    /**
     * Default constructor for test class DVDPlayerTest.
     */
    public DVDPlayerTest()
    {
        // Default constructor
    }

    /**
     * Creates a concrete item to test. DO NOT MODIFY THIS METHOD.
     *
     * @return the item
     */
    protected AbstractItem createItem()
    {
        return new DVDPlayer();
    }

    /**
     * This is here because of a WebCAT bug.
     */
    public void testLameness() {
        super.testAll();
    }
    //  No additional test cases needed
}

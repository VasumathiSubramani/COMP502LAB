
/**
 * The test class AbstractItemTest.
 *
 * @author  Franklin University
 * @version 2.0
 */
public abstract class AbstractItemTest extends junit.framework.TestCase
{
    /**
     * Item used for testing subclasses.
     */
    protected AbstractItem item;
    private static final String DESC = "Item description";
    private static final String DIFF_DESC = "Different description";
    private static final String ID = "123";
    private static final String DIFF_ID = "234";
    private static final String BAD_ID = "-123";
    private static final String ZERO_ID = "000";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int NEGATIVE = -1;
    private static final double WKLY_RATE = 23.99;
    private static final double DIFF_WKLY = 12.34;
    private static final double NEG_RATE = -10.00;
    private static final double ZERO_RATE = 0.00;
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    /**
     * Default constructor for test class AbstractItemTest.
     */
    public AbstractItemTest()
    {
        // No code needed here
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Override
    protected void setUp()
    {
        item = createItem();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @Override
    protected void tearDown()
    {
        // No code needed here
    }

    /**
     * This is here because of a WebCAT bug.
     */
    public void testAll() {
        testCreateItemMethod();
        testItemSetAndGetMethods();
        testItemSetterExceptions();

        int x = 5;
        int y = 3;
        int z = x + y;
        assertEquals(8, z);
    }

    /**
     * Test creating an Item.
     */
    public void testCreateItemMethod()
    {
        assertNotNull("Hint: creatItem() returned null instead of an " +
                      "Item object. ", createItem());
    }

    /**
     * Test Item mutator and accessor methods.
     */
    public void testItemSetAndGetMethods()
    {
        item.setDescription(DESC);
        assertEquals("Hint: getDescription() return value does not match " +
                     "set value. ",
                     DESC, item.getDescription());
        item.setWeeklyRate(WKLY_RATE);
        assertEquals("Hint: getWeeklyRate() return value does not match " +
                     "set value. ",
                     WKLY_RATE, item.getWeeklyRate());
        item.setId(ID);
        assertEquals("Hint: getId() return value does not match " +
                     "set value. ",
                     ID, item.getId());
    }

    /**
     * Test calculating the rental fees.
     */
    public void testCalculateFeeMethod()
    {
        // Test when the weekly rate is null
        assertEquals("Hint: calculateFee() should return zero " +
                   "if weekly rate is not set. ",
                   0.0, item.calculateFee(TWO), 0.01);

        item.setWeeklyRate(WKLY_RATE);
        // Test when the number of weeks is 1
        assertEquals("Hint: calculateFee() should return a rate " +
                     "equal to the weekly rate when 1 is " +
                     "passed into the method. ",
                     WKLY_RATE, item.calculateFee(ONE));

        // Test when the number of weeks is more than 1
        assertEquals("Hint: calculateFee() should return a fee " +
                     "equal to n times the weekly rate where n " +
                     "is the number of weeks passed into the " +
                     "method. ",
                     WKLY_RATE * TWO, item.calculateFee(TWO));

        // Test when the number of weeks is 0
        assertEquals("Hint: calculateFee() should return zero " +
                   "if number of weeks is 0. ",
                   0.0, item.calculateFee(ZERO), 0.01);

        // Test when the number of weeks is negative
        assertEquals("Hint: calculateFee() should return zero " +
                   "if number of weeks is negative. ",
                   0.0, item.calculateFee(NEGATIVE));
    }

    /**
     * Test renting and returning an item.
     */
    public void testRentalStatusMethods()
    {
        // Test the default value.
        assertEquals("Hint: isRented() should return false " +
                     "if the item has not been rented. ",
                     FALSE, item.isRented());

        // Test setting the rental status to rented.
        item.rented();
        assertEquals("Hint: isRented() should return true " +
                     "if the item has been rented. ",
                     TRUE, item.isRented());

        // Test setting the rental status to not rented.
        item.returned();
        assertEquals("Hint: isRented() should return false " +
                     "if the item has been returned. ",
                     FALSE, item.isRented());
    }

    /**
     * Test throwing exceptions from set methods.
     */
    public void testItemSetterExceptions()
    {
        boolean caught;

        // Test setDescription invalid arguments
        caught = false;
        try {
            item.setDescription(null);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setDescription() should throw an " +
                   "IllegalArgumentException when null " +
                   "is passed in. ", caught);
        caught = false;
        try {
            item.setDescription("");
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setDescription() should throw an " +
                   "IllegalArgumentException when an empty String " +
                   "is passed in. ", caught);

        // Test setWeeklyRate invalid arguments
        caught = false;
        try {
            item.setWeeklyRate(NEG_RATE);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setWeeklyRate() should throw an " +
                   "IllegalArgumentException when a negative Dollar " +
                   "amount is passed in. ", caught);
        caught = false;
        try {
            item.setWeeklyRate(ZERO_RATE);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setWeeklyRate() should throw an " +
                   "IllegalArgumentException when a zero Dollar " +
                   "amount is passed in. ", caught);

        // Test setId invalid arguments
        caught = false;
        try {
            item.setId(null);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setId() should throw an " +
                   "IllegalArgumentException when null " +
                   "is passed in. ", caught);
        caught = false;
        try {
            item.setId("");
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setId() should throw an " +
                   "IllegalArgumentException when an empty String " +
                   "is passed in. ", caught);
        caught = false;
        try {
            item.setId(BAD_ID);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setId() should throw an " +
                   "IllegalArgumentException when an id String " +
                   "containing something other than the characters " +
                   "'0' thru '9' is passed in. ", caught);
        caught = false;
        try {
            item.setId(ZERO_ID);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setId() should throw an " +
                   "IllegalArgumentException when an id String " +
                   "containing all zeros is passed in. ", caught);
    }

    /**
     * Test the equals method.
     */
    public void testEquals()
    {
        // Test with default values
        AbstractItem item2 = createItem();
        assertEquals("Hint: Two newly created items should be equal. ",
                   item, item2);

        // Test with equal values in instance fields
        setFieldsEqual(item, item2);
        assertEquals("Hint: Two items with values in the instance fields " +
                   "should be equal. ",
                   item2, item);

        // Test with different descriptions
        setFieldsEqual(item, item2);
        item.setDescription(DIFF_DESC);
        assertFalse("Hint: Two items with different descriptions " +
                    "should not be equal. ",
                    item.equals(item2));

        // Test with different IDs
        setFieldsEqual(item, item2);
        item.setId(DIFF_ID);
        assertFalse("Hint: Two items with different item ids " +
                    "should not be equal. ",
                    item.equals(item2));

        // Test with different weekly rates
        setFieldsEqual(item, item2);
        item.setWeeklyRate(DIFF_WKLY);
        assertFalse("Hint: Two items with different weekly rates " +
                    "should not be equal. ",
                    item.equals(item2));

        // Test with different rental status
        setFieldsEqual(item, item2);
        item.returned();
        assertFalse("Hint: Two items with different rental status  " +
                    "should not be equal. ",
                    item.equals(item2));
    }

    /**
     * Test equals with nulls.
     */
    public void testAbstractItemEqualsWithNull()
    {
        Item item2 = createItem();
        item2.setId(ID);
        item.setDescription(DESC);
        item2.setDescription(DESC);
        item.setWeeklyRate(WKLY_RATE);
        item2.setWeeklyRate(WKLY_RATE);
        item.rented();
        item2.rented();

        assertFalse("Hint: Two items should not be equal when one " +
                "id is null", item.equals(item2));

        item = createItem();
        item2 = createItem();
        item.setId(ID);
        item2.setId(ID);
        //item.setDescription(DESC);
        item2.setDescription(DESC);
        item.setWeeklyRate(WKLY_RATE);
        item2.setWeeklyRate(WKLY_RATE);
        item.rented();
        item2.rented();

        assertFalse("Hint: Two items should not be equal when one " +
                "description is null", item.equals(item2));

        item = createItem();
        item2 = createItem();
        item.setId(ID);
        item2.setId(ID);
        item.setDescription(DESC);
        item2.setDescription(DESC);
        //item.setWeeklyRate(WKLY_RATE);
        item2.setWeeklyRate(WKLY_RATE);
        item.rented();
        item2.rented();

        assertFalse("Hint: Two items should not be equal when one " +
                "weekly rate is null", item.equals(item2));
    }

    /**
     * Sets the instance fields of two items to equal values.
     * @param item1 Item one
     * @param item2 Item two
     */
    protected void setFieldsEqual(AbstractItem item1, AbstractItem item2)
    {
        item1.setId(ID);
        item2.setId(ID);
        item1.setDescription(DESC);
        item2.setDescription(DESC);
        item1.setWeeklyRate(WKLY_RATE);
        item2.setWeeklyRate(WKLY_RATE);
        item1.rented();
        item2.rented();
    }

    /**
     * Retrieves a concrete item object for testing.
     *
     * @return the item object for testing.
     */
    protected abstract AbstractItem createItem();
}

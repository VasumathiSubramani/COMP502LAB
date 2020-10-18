
/**
 * The test class FurnitureTest.
 *
 * @author  Franklin University
 * @version 2.0
 */
public class FurnitureTest extends AbstractItemTest
{
    private static final double MNTHLY_RATE = 100.00;
    private static final double DIFF_MNTHLY = 99.99;
    private static final double NEG_RATE = -12.34;
    private static final double ZERO_RATE = 0.00;
    private static final double WKLY_RATE = 23.99;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int THIRTEEN = 13;

    /**
     * Default constructor for test class FurnitureTest.
     */
    public FurnitureTest()
    {
        // Default constructor
    }


    /**
     * Creates a concrete item to test. DO NOT MODIFY THIS METHOD.
     *
     * @return the item
     */
    @Override
    protected AbstractItem createItem()
    {
        return new Furniture();
    }

    /**
     * Test mutator and accessor methods unique to Furniture.
     */
    public void testFurnitureSetAndGetMethods()
    {
        Furniture f = (Furniture) item;
        f.setMonthlyRate(MNTHLY_RATE);
        assertEquals("Hint: getMonthlyRate() return value does not match " +
                     "set value. ", MNTHLY_RATE, f.getMonthlyRate());
    }

    /**
     * Test throwing exceptions from set methods unique to Furniture.
     */
    public void testSetterExceptions()
    {
        boolean caught;
        Furniture f = (Furniture)item;

        // Test setMonthlyRate invalid arguments
        caught = false;
        try {
            f.setMonthlyRate(NEG_RATE);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setMonthlyRate() should throw an " +
                   "IllegalArgumentException when a negative Dollar " +
                   "amount is passed in. ", caught);
        caught = false;
        try {
            f.setMonthlyRate(ZERO_RATE);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setMonthlyRate() should throw an " +
                   "IllegalArgumentException when a zero Dollar " +
                   "amount is passed in. ", caught);
    }
    /**
     * Test calculating the rental fees.
     */
    @Override
    public void testCalculateFeeMethod()
    {
        Furniture f = (Furniture)item;
        f.setMonthlyRate(MNTHLY_RATE);
        super.testCalculateFeeMethod();
    }

    /**
     * Test calculating the rental fees for a month or more.
     */
    public void testCalculateMontlyFees()
    {
        Furniture f = (Furniture)item;
        // Test when the number of weeks equals a month
        f.setMonthlyRate(MNTHLY_RATE);
        f.setWeeklyRate(WKLY_RATE);
        assertEquals("Hint: calculateFee() should return a fee " +
                     "equal to the monthly rate when 4 " +
                     "is passed into the method. ",
                     MNTHLY_RATE, f.calculateFee(FOUR));

        // Test when the number of weeks is one week more than a month
        assertEquals("Hint: calculateFee() should return a fee " +
                     "equal to the monthly rate plus one weekly " +
                     "rate when 5 is passed into the method. ",
                     MNTHLY_RATE + f.getWeeklyRate(), f.calculateFee(FIVE));

        // Test when the number of weeks is two weeks more than a month
        assertEquals("Hint: calculateFee() should return a fee " +
                     "equal to the monthly rate plus two times " +
                     "the weekly rate when 6 is passed into the method. ",
                     MNTHLY_RATE + f.getWeeklyRate() * TWO,
                     f.calculateFee(SIX));

        // Test with multiple months and weeks
        assertEquals("Hint: calculateFee() should return a fee " +
                     "equal to three times the monthly rate plus " +
                     "the weekly rate when 13 is passed into the method. ",
                     MNTHLY_RATE * THREE + f.getWeeklyRate(),
                     f.calculateFee(THIRTEEN));
    }

    /**
     * Test null rental fees if monthly rate not set.
     */
    public void testCalculateNullMonthlyFees()
    {
        // Test when the monthly rate is null
        Furniture f = (Furniture)item;
        f.setWeeklyRate(WKLY_RATE);
        assertEquals("Hint: calculateFee() should return zero " +
                   "if monthly rate is not set. ",
                   0.0, f.calculateFee(THIRTEEN), 0.01);
    }

    /**
     * Test unequal furniture items.
     */
    public void testUnequalFurnitureItems()
    {
        Furniture item1 = (Furniture)createItem();
        Furniture item2 = (Furniture)createItem();

        // Test with different monthly rates
        setFieldsEqual(item1, item2);
        item1.setMonthlyRate(DIFF_MNTHLY);
        assertFalse("Hint: Two furniture items with different " +
                    "monthly rates " +
                    "should not be equal. ",
                    item1.equals(item2));

        item1 = (Furniture)createItem();
        item2 = (Furniture)createItem();

        // Test with different monthly rates - one null
        item1 = (Furniture)createItem();
        super.setFieldsEqual(item1, item2);
        item2.setMonthlyRate(MNTHLY_RATE);
        assertFalse("Hint: Two furniture items with different " +
                    "monthly rates " +
                    "should not be equal. (one is null)",
                    item1.equals(item2));
    }

    /**
     * Sets the instance fields of two furniture items to equal values.
     * @param item1 Item one
     * @param item2 Item two
     */
    @Override
    protected void setFieldsEqual(AbstractItem item1, AbstractItem item2)
    {
        super.setFieldsEqual(item1, item2);
        Furniture f1 = (Furniture)item1;
        Furniture f2 = (Furniture)item2;
        f1.setMonthlyRate(MNTHLY_RATE);
        f2.setMonthlyRate(MNTHLY_RATE);
    }
}

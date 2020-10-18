
/**
 * The test class TelelvisionTest.
 *
 * @author  Franklin University
 * @version 2.0
 */
public class TelevisionTest extends AbstractItemTest
{
    private static final int LOWER_SIZE = 5;
    private static final int MID_SIZE = 37;
    private static final int UPPER_SIZE = 60;
    private static final int UPPER_LCD = 50;
    private static final int TOO_SMALL = 4;
    private static final int TOO_BIG = 61;
    private static final String LCD1 = "LCD";
    private static final String LCD2 = "lcd";
    private static final String LCD3 = "Lcd";
    private static final String PLASMA1 = "PLASMA";
    private static final String PLASMA2 = "plasma";
    private static final String PLASMA3 = "Plasma";
    private static final String BAD_TYPE = "Bad";

    /**
     * Default constructor for test class TelevisionTest.
     */
    public TelevisionTest()
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
        return new Television();
    }

    /**
     * Test mutator and accessor methods unique to Television. No
     * exceptions should be thrown.
     */
    public void testTelevionSetAndGetMethods()
    {
        boolean passed = false;
        Television tv = (Television)createItem();
        try {
            tv.setSize(LOWER_SIZE);
            assertEquals("Hint: getSize() return value does not match " +
                     "set value. ",
                     LOWER_SIZE, tv.getSize());
            tv.setSize(UPPER_SIZE);
            tv.setSize(MID_SIZE);
            passed = true;
        }
        catch (IllegalArgumentException ex) {
            //  Nothing here
        }
        assertTrue("Hint: setSize() should not throw exception when " +
                "type is not set and size is set to a value between 5 " +
                "and 60.", passed);

        passed = false;
        tv = (Television)createItem();
        try {
            tv.setType(PLASMA1);
            assertEquals("Hint: getType() return value does not match " +
                         "set value. ",
                         PLASMA1, tv.getType());
            tv.setType(PLASMA2);
            tv.setType(PLASMA3);
            tv.setType(LCD1);
            tv.setType(LCD2);
            tv.setType(LCD3);
            passed = true;
        }
        catch (IllegalArgumentException ex) {
            //  Nothing here
        }
        assertTrue("Hint: setType() should not throw exception when " +
                "size is not set and type is set to plasma or LCD " +
                "(any mix of upper and lower case). ", passed);
    }

    /**
     * Test types depending on size. No exceptions should be thrown.
     */
    public void testTypesBySize()
    {
        boolean passed = false;
        Television tv = (Television)createItem();
        try {
            tv.setSize(LOWER_SIZE);
            tv.setType(LCD1);

            tv = (Television)createItem();
            tv.setSize(UPPER_LCD);
            tv.setType(LCD2);

            tv = (Television)createItem();
            tv.setSize(MID_SIZE);
            tv.setType(LCD3);
            passed = true;
        }
        catch (IllegalArgumentException ex) {
            //  Nothing here
        }
        assertTrue("Hint: setType() should not throw exception when " +
                "size is set between 5 and 50 and type is set to " +
                "LCD (any mix of upper and lower case). ", passed);

        passed = false;
        try {
            tv = (Television)createItem();
            tv.setSize(MID_SIZE);
            tv.setType(PLASMA1);

            tv = (Television)createItem();
            tv.setSize(UPPER_SIZE);
            tv.setType(PLASMA2);

            tv = (Television)createItem();
            tv.setSize(UPPER_LCD);
            tv.setType(PLASMA3);
            passed = true;
        }
        catch (IllegalArgumentException ex) {
            //  Nothing here
        }
        assertTrue("Hint: setType() should not throw exception when " +
                "size is set between 37 and 60 and type is set to " +
                "plasma (any mix of upper and lower case). ", passed);
    }

    /**
     * Test sizes depending on type. No exceptions should be thrown.
     */
    public void testSizesByType()
    {
        boolean passed = false;
        Television tv = (Television)createItem();
        try {
            tv.setType(LCD1);
            tv.setSize(LOWER_SIZE);

            tv = (Television)createItem();
            tv.setType(LCD2);
            tv.setSize(UPPER_LCD);

            tv = (Television)createItem();
            tv.setType(LCD3);
            tv.setSize(MID_SIZE);
            passed = true;
        }
        catch (IllegalArgumentException ex) {
            //  Nothing here
        }
        assertTrue("Hint: setSize() should not throw exception when " +
                "type is set to LCD (any mix of upper and lower case) and " +
                "size is set between 5 and 50. ", passed);

        passed = false;
        try {
            tv = (Television)createItem();
            tv.setType(PLASMA1);
            tv.setSize(MID_SIZE);

            tv = (Television)createItem();
            tv.setType(PLASMA2);
            tv.setSize(UPPER_SIZE);

            tv = (Television)createItem();
            tv.setType(PLASMA3);
            tv.setSize(UPPER_LCD);
            passed = true;
        }
        catch (IllegalArgumentException ex) {
            //  Nothing here
        }
        assertTrue("Hint: setSize() should not throw exception when " +
                "type is set to LCD (any mix of upper and lower case) and " +
                "size is set between 37 and 60. ", passed);
    }

    /**
     * Test throwing exceptions from the setSize method.
     */
    public void testSetSizeExceptions()
    {
        boolean caught;
        Television tv = (Television)createItem();

        caught = false;
        try {
            tv.setSize(TOO_SMALL);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setType() should throw an " +
                   "IllegalArgumentException when a size < 5 " +
                   "is passed in. ", caught);

        tv = (Television)createItem();
        caught = false;
        try {
            tv.setSize(TOO_BIG);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setSize() should throw an " +
                   "IllegalArgumentException when a size > 60 " +
                   "is passed in. ", caught);

        tv = (Television)createItem();
        caught = false;
        try {
            tv.setType(LCD1);
            tv.setSize(UPPER_SIZE);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setSize() should throw an " +
                   "IllegalArgumentException when type is LCD " +
                   "and a size > 50 is passed in. ", caught);

        tv = (Television)createItem();
        caught = false;
        try {
            tv.setType(PLASMA1);
            tv.setSize(LOWER_SIZE);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setSize() should throw an " +
                   "IllegalArgumentException when type is plasma " +
                   "and a size < 37 is passed in. ", caught);
    }

    /**
     * Test throwing exceptions from the setType method.
     */
    public void testSetTypeExceptions()
    {
        boolean caught;
        Television tv = (Television)createItem();

        caught = false;
        try {
            tv.setType(null);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setType() should throw an " +
                   "IllegalArgumentException when a null type " +
                   "is passed in. ", caught);

        caught = false;
        try {
            tv.setType(BAD_TYPE);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setType() should throw an " +
                   "IllegalArgumentException when an invalid type " +
                   "is passed in. ", caught);

        tv = (Television)createItem();
        caught = false;
        try {
            tv.setSize(LOWER_SIZE);
            tv.setType(PLASMA1);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setType() should throw an " +
                   "IllegalArgumentException when size is < 37 " +
                   "and " + PLASMA1 + " is passed in. ", caught);

        tv = (Television)createItem();
        caught = false;
        try {
            tv.setSize(UPPER_SIZE);
            tv.setType(LCD1);
        }
        catch (IllegalArgumentException ex) {
            caught = true;
        }
        assertTrue("Hint: setType() should throw an " +
                   "IllegalArgumentException when size is > 50 " +
                   "and " + LCD1 + " is passed in. ", caught);
    }

    /**
     * Test unequal Television items.
     */
    public void testUnequalTelevisionItems()
    {
        Television item1 = (Television)createItem();
        Television item2 = (Television)createItem();

        // Test with different sizes
        setFieldsEqual(item1, item2);
        item1.setSize(UPPER_LCD);
        assertFalse("Hint: Two televisions with different sizes " +
                    "should not be equal. ",
                    item1.equals(item2));

        // Test with different types
        setFieldsEqual(item1, item2);
        item1.setType(PLASMA1);
        assertFalse("Hint: Two televisions with different types " +
                    "should not be equal. ",
                    item1.equals(item2));

        // Test with different types - one null
        item1 = (Television)createItem();
        super.setFieldsEqual(item1, item2);
        item1.setSize(MID_SIZE);
        item2.setSize(MID_SIZE);
        item2.setType(LCD1);
        assertFalse("Hint: Two televisions with different types " +
                    "should not be equal. (one is null)",
                    item1.equals(item2));
    }

    /**
     * Sets the instance fields of two televisions to equal values.
     * @param item1 Item one
     * @param item2 Item two
     */
    protected void setFieldsEqual(AbstractItem item1, AbstractItem item2)
    {
        super.setFieldsEqual(item1, item2);
        Television t1 = (Television)item1;
        Television t2 = (Television)item2;
        t1.setSize(MID_SIZE);
        t2.setSize(MID_SIZE);
        t1.setType(LCD1);
        t2.setType(LCD1);
    }
}

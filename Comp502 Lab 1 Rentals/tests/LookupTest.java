

/**
 * The test class LookupTest.
 *
 * @author  Franklin University
 * @version 2.0
 */
public class LookupTest extends junit.framework.TestCase
{
    private static final String IDNUM = "123";
    private static final String IDNUM2 = "234";
    private static final String NUM = "456";
    private static final String PLASMA = "plasma";
    private static final String LCD = "LCD";
    private static final int SIZE_40 = 40;
    private static final int SIZE_45 = 45;

   /**
     * Test matching nulls.
     */
    public void testIdNullMatch()
    {
        Item f = new Furniture();
        Lookup query = new IdLookup(null);
        assertTrue("Hint: matches() should have returned true " +
                   "when Item id is null and id passed into " +
                   "IdLookup constructor is null. ",
                   query.matches(f));
    }

    /**
     * Test a matching Item.
     */
    public void testIdMatch()
    {
        Item f = new Furniture();
        f.setId(IDNUM);
        Lookup query = new IdLookup(IDNUM);
        assertTrue("Hint: matches() should have returned true " +
                   "when Item id matches id passed into " +
                   "IdLookup constructor. ",
                   query.matches(f));
    }

    /**
     * Test when lookup id not set.
     */
    public void testIdNoMatchToNull()
    {
        Item dvd = new DVDPlayer();
        dvd.setId(IDNUM);
        Lookup query = new IdLookup(null);
        assertFalse("Hint: matches() should have returned false " +
                   "when id passed into IdLookup constructor is " +
                   "null and Item id is set. ",
                    query.matches(dvd));
    }

    /**
     * Test when item id not set.
     */
    public void testIdNoMatchToItemNull()
    {
        Item dvd = new DVDPlayer();
        Lookup query = new IdLookup(IDNUM);
        assertFalse("Hint: matches() should have returned false " +
                   "when Item id is null and id passed into IdLookup " +
                   "constructor is not null. ",
                    query.matches(dvd));
    }

    /**
     * Test non-matching Item with non-null id.
     */
    public void testIdNoMatchId()
    {
        Item tv = new Television();
        tv.setId(IDNUM);
        Lookup query = new IdLookup(NUM);
        assertFalse("Hint: matches() should have returned false " +
                   "when id passed into IdLookup constructor " +
                   "does not match Item id. ",
                    query.matches(tv));
    }

    /**
      * Test a matching nulls.
      */
     public void testItemNullMatch()
     {
         Lookup query = new ItemLookup(null);
         assertTrue("Hint: matches() should have returned true " +
                    "when Item is null and item passed into " +
                    "ItemLookup constructor is null. ",
                    query.matches(null));
     }

     /**
      * Test a matching Item.
      */
     public void testItemMatch()
     {
         Item f = new Furniture();
         Item f2 = new Furniture();
         f.setId(IDNUM);
         f2.setId(IDNUM);
         Lookup query = new ItemLookup(f);
         assertTrue("Hint: matches() should have returned true " +
                    "when item matches the item passed into " +
                    "IdLookup constructor. ",
                    query.matches(f2));
     }

     /**
      * Test when lookup item not set.
      */
     public void testItemNoMatchToNull()
     {
         Item dvd = new DVDPlayer();
         dvd.setId(IDNUM);
         Lookup query = new ItemLookup(null);
         assertFalse("Hint: matches() should have returned false " +
                    "when item passed into ItemLookup constructor is " +
                    "null and item is not null. ",
                     query.matches(dvd));
     }

     /**
      * Test when item id not set.
      */
     public void testItemNoMatchToItemNull()
     {
         Item dvd = new DVDPlayer();
         Lookup query = new ItemLookup(dvd);
         assertFalse("Hint: matches() should have returned false " +
                    "when Item is null and item passed into ItemLookup " +
                    "constructor is not null. ",
                     query.matches(null));
     }

     /**
      * Test non-matching Item types.
      */
     public void testItemNoMatchId()
     {
         Item tv = new Television();
         Item tv2 = new Television();
         tv.setId(IDNUM);
         tv2.setId(IDNUM2);
         Lookup query = new ItemLookup(tv);
         assertFalse("Hint: matches() should have returned false " +
                    "when item passed into ItemLookup constructor " +
                    "does not match Item. ",
                     query.matches(tv2));
     }

     /**
      * Test a matching Item.
      */
     public void testTVMatch()
     {
         Television tv = new Television();
         tv.setType(PLASMA);
         tv.setSize(SIZE_40);
         Lookup query = new TVLookup(SIZE_40, PLASMA);
         assertTrue("Hint: matches() should have returned true " +
                    "when size and type of the item matches " +
                    "the size and type passed into " +
                    "TVLookup constructor. ",
                    query.matches(tv));
     }


     /**
      * Test a matching Item with null type.
      */
     public void testTVMatchNull()
     {
         Television tv = new Television();
         tv.setSize(SIZE_40);
         Lookup query = new TVLookup(SIZE_40, null);
         assertTrue("Hint: matches() should have returned true " +
                    "when sizes match and types are both null",
                    query.matches(tv));
     }

     /**
      * Test when lookup type not set.
      */
     public void testTVNoMatchToNull()
     {
         Television tv = new Television();
         tv.setType(PLASMA);
         tv.setSize(SIZE_40);
         Lookup query = new TVLookup(SIZE_40, null);
         assertFalse("Hint: matches() should have returned false " +
                    "when type passed into TVLookup constructor is " +
                    "null and type is set. ",
                     query.matches(tv));
     }

     /**
      * Test when type not set.
      */
     public void testTVNoMatchToItemNull()
     {
         Television tv = new Television();
         tv.setSize(SIZE_40);
         Lookup query = new TVLookup(SIZE_40, PLASMA);
         assertFalse("Hint: matches() should have returned false " +
                    "when type is null and id passed into TVLookup " +
                    "constructor is not null. ",
                     query.matches(tv));
     }

     /**
      * Test when types or sizes don't match.
      */
     public void testTVNoMatch()
     {
         Television tv = new Television();
         tv.setSize(SIZE_40);
         tv.setType(PLASMA);
         Lookup query = new TVLookup(SIZE_40, LCD);
         assertFalse("Hint: matches() should have returned false " +
                    "when types don't match. ",
                     query.matches(tv));
         query = new TVLookup(SIZE_45, PLASMA);
         assertFalse("Hint: matches() should have returned false " +
                    "when sizes don't match. ",
                     query.matches(tv));
     }
 }

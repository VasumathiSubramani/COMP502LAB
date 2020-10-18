import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Tests for ItemIO
 * @author timkington
 * @version 1
 *
 */
public class ItemIOTest {

    /**
     * Test creating a DVDPlayer from a string
     */
    @Test
    public void testDVDPlayerFromString() {
        //  For coverage
        new ItemIO();

        String data = "123:LG Player:3.25:true";
        DVDPlayer d = DVDPlayer.createFromString(data);
        assertEquals("Hint: after createFromString with " + data + ", " +
                " id incorrect", "123", d.getId());
        assertEquals("Hint: after createFromString with " + data + ", " +
                " description incorrect", "LG Player", d.getDescription());
        assertEquals("Hint: after createFromString with " + data + ", " +
                " weekly rate incorrect", 3.25, d.getWeeklyRate(), 0.01);
        assertTrue("Hint: after createFromString with " + data + ", " +
                " rented incorrect", d.isRented());

        String data2 = "123:LG Player:3.25:false";
        d = DVDPlayer.createFromString(data2);
        assertFalse("Hint: after createFromString with " + data + ", " +
                " rented incorrect", d.isRented());
    }

    /**
     * Test saving a DVDPlayer
     */
    @Test
    public void testDVDPlayerSaveToString() {
        DVDPlayer d = new DVDPlayer();
        d.setId("123");
        d.setDescription("LG Player");
        d.setWeeklyRate(3.25);
        assertEquals("Hint: DVDPlayer saveToString incorrect",
                "DVDPlayer~123:LG Player:3.25:false",
                d.saveToString());

        d.rented();
        assertEquals("Hint: DVDPlayer saveToString incorrect",
                "DVDPlayer~123:LG Player:3.25:true",
                d.saveToString());
    }

    /**
     * Test creating a Furniture from a string
     */
    @Test
    public void testFurnitureFromString() {
        //  For coverage
        new ItemIO();

        String data = "123:Desk:18.75:true:15.25";
        Furniture f = Furniture.createFromString(data);
        assertEquals("Hint: after createFromString with " + data + ", " +
                " id incorrect", "123", f.getId());
        assertEquals("Hint: after createFromString with " + data + ", " +
                " description incorrect", "Desk", f.getDescription());
        assertEquals("Hint: after createFromString with " + data + ", " +
                " weekly rate incorrect", 18.75, f.getWeeklyRate(), 0.01);
        assertTrue("Hint: after createFromString with " + data + ", " +
                " rented incorrect", f.isRented());
        assertEquals("Hint: after createFromString with " + data + ", " +
                " monthly rate incorrect", 15.25, f.getMonthlyRate(), 0.01);

        String data2 = "123:Desk:18.75:false:15.25";
        f = Furniture.createFromString(data2);
        assertFalse("Hint: after createFromString with " + data + ", " +
                " rented incorrect", f.isRented());
    }

    /**
     * Test saving a Furniture
     */
    @Test
    public void testFurnitureSaveToString() {
        Furniture f = new Furniture();
        f.setId("123");
        f.setDescription("Desk");
        f.setWeeklyRate(18.25);
        f.setMonthlyRate(15.75);
        assertEquals("Hint: Furniture saveToString incorrect",
                "Furniture~123:Desk:18.25:false:15.75",
                f.saveToString());

        f.rented();
        assertEquals("Hint: Furniture saveToString incorrect",
                "Furniture~123:Desk:18.25:true:15.75",
                f.saveToString());
    }


    /**
     * Test creating a Television from a string
     */
    @Test
    public void testTelevisionFromString() {
        //  For coverage
        new ItemIO();

        String data = "345:Samsung TV:8.75:true:51:PLASMA";
        Television t = Television.createFromString(data);
        assertEquals("Hint: after createFromString with " + data + ", " +
                " id incorrect", "345", t.getId());
        assertEquals("Hint: after createFromString with " + data + ", " +
                " description incorrect", "Samsung TV", t.getDescription());
        assertEquals("Hint: after createFromString with " + data + ", " +
                " weekly rate incorrect", 8.75, t.getWeeklyRate(), 0.01);
        assertTrue("Hint: after createFromString with " + data + ", " +
                " rented incorrect", t.isRented());
        assertEquals("Hint: after createFromString with " + data + ", " +
                " size incorrect", 51, t.getSize());
        assertEquals("Hint: after createFromString with " + data + ", " +
                " type incorrect", "PLASMA", t.getType());

        String data2 = "345:Samsung TV:8.75:false:51:PLASMA";
        t = Television.createFromString(data2);
        assertFalse("Hint: after createFromString with " + data + ", " +
                " rented incorrect", t.isRented());
    }

    /**
     * Test saving a Television
     */
    @Test
    public void testTelevisionSaveToString() {
        Television t = new Television();
        t.setId("345");
        t.setDescription("Samsung");
        t.setWeeklyRate(3.25);
        t.setSize(55);
        t.setType("PLASMA");
        assertEquals("Hint: Television saveToString incorrect",
                "Television~345:Samsung:3.25:false:55:PLASMA",
                t.saveToString());

        t.rented();
        assertEquals("Hint: Television saveToString incorrect",
                "Television~345:Samsung:3.25:true:55:PLASMA",
                t.saveToString());
    }

    /**
     * Test loading items from file
     * @throws IOException
     */
    @Test
    public void testLoadItems() throws IOException {
        List<Item> items = ItemIO.loadItems("items.txt");
        assertEquals(
                "Hint: loadItems() returned wrong # of items", 3, items.size());

        DVDPlayer d = (DVDPlayer)items.get(0);
        Furniture f = (Furniture)items.get(1);
        Television t = (Television)items.get(2);

        assertEquals("Hint: after loading DVDPlayer from file" +
                " id incorrect", "123", d.getId());
        assertEquals("Hint: after loading DVDPlayer from file" +
                " description incorrect", "LG Player", d.getDescription());
        assertEquals("Hint: after loading DVDPlayer from file" +
                " weekly rate incorrect", 3.25, d.getWeeklyRate(), 0.01);
        assertTrue("Hint: after loading DVDPlayer from file" +
                " rented incorrect", d.isRented());

        assertEquals("Hint: after loading Furniture from file" +
                " id incorrect", "345", f.getId());
        assertEquals("Hint: after loading Furniture from file" +
                " description incorrect", "Desk", f.getDescription());
        assertEquals("Hint: after loading Furniture from file" +
                " weekly rate incorrect", 18.25, f.getWeeklyRate(), 0.01);
        assertFalse("Hint: after loading Furniture from file" +
                " rented incorrect", f.isRented());
        assertEquals("Hint: after loading Furniture from file" +
                " monthly rate incorrect", 15.75, f.getMonthlyRate(), 0.01);

        assertEquals("Hint: after loading Television from file" +
                " id incorrect", "234", t.getId());
        assertEquals("Hint: after loading Television from file" +
                " description incorrect", "Samsung", t.getDescription());
        assertEquals("Hint: after loading Television from file" +
                " weekly rate incorrect", 5.25, t.getWeeklyRate(), 0.01);
        assertTrue("Hint: after loading Television from file" +
                " rented incorrect", t.isRented());
        assertEquals("Hint: after loading Television from file" +
                " size incorrect", 55, t.getSize());
        assertEquals("Hint: after loading Television from file" +
                " type incorrect", "PLASMA", t.getType());
    }

    /**
     * Test saving items
     * @throws IOException
     */
    @Test
    public void testSaveItems() throws IOException {
        List<Item> items = new ArrayList<Item>();

        DVDPlayer d = new DVDPlayer();
        d.setId("123");
        d.setDescription("LG Player");
        d.setWeeklyRate(3.25);
        items.add(d);

        Television t = new Television();
        t.setId("234");
        t.setDescription("Samsung");
        t.setWeeklyRate(3.25);
        t.setSize(55);
        t.setType("PLASMA");
        items.add(t);

        Furniture f = new Furniture();
        f.setId("345");
        f.setDescription("Desk");
        f.setWeeklyRate(18.25);
        f.setMonthlyRate(15.75);
        items.add(f);

        ItemIO.saveItems("saved.txt", items);
        List<String> lines = Files.readAllLines(Paths.get("saved.txt"));
        assertEquals(
                "Hint: saveItems() wrote incorrect # of lines",
                3, lines.size());

        assertEquals("Hint: saveItems() wrote incorrect data for DVDPlayer",
                "DVDPlayer~123:LG Player:3.25:false",
                lines.get(0));
        assertEquals(
                "Hint: saveItems() wrote incorrect data for Television",
                "Television~234:Samsung:3.25:false:55:PLASMA",
                lines.get(1));
        assertEquals(
                "Hint: saveItems() wrote incorrect data for Furniture",
                "Furniture~345:Desk:18.25:false:15.75",
                lines.get(2));
    }
}

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The ItemIO class is used to read and write items to a text file
 * @author timkington
 * @version 1
 *
 */
public class ItemIO {

    /**
     * Saves a list of items to the given file.
     * @param filename the filename
     * @param items the items
     * @throws IOException if there's an error writing the file
     */
    public static void saveItems(String filename, List<Item> items)
            throws IOException {
        try(PrintWriter out = new PrintWriter(new FileWriter(filename)))
        {
            for(Item item: items) {
                String line = item.saveToString();
                out.println(line);
            }
        }
            catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        
    }

    /**
     * Loads a list of items from the given file.  Each line is in the format
     * <item type>~<item data>.  The createFromString() methods in the item
     * classes will be used to parse the item data.
     * @param filename the filename
     * @return the list of items
     * @throws IOException if the file can't be opened
     */
    public static List<Item> loadItems(String filename) throws IOException {
        List<Item> items = new ArrayList<>();
        try(Scanner in = new Scanner(new FileReader(filename)))
        {
            while(in.hasNextLine())
            {
                String line = in.nextLine();
                String[] tokens = line.split("~");
                String itemType = tokens[0];
                String itemData = tokens[1];
                if (itemType.equalsIgnoreCase("DVDPlayer")) {
                    
                   items.add(DVDPlayer.createFromString(itemData));
                }
                
                else if (itemType.equalsIgnoreCase("Television")) {
                    
                    items.add(Television.createFromString(itemData));
                }
                else if (itemType.equalsIgnoreCase("Furniture")) {
                    
                    items.add(Furniture.createFromString(itemData));
                }
                
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        return items;
    }

}


/**
 * This class represents a DVD player to be rented.
 *
 * @author Franklin University
 * @version 2.0
 */
public class DVDPlayer extends AbstractItem
{

    /**
     * Constructor for objects of class DVDPlayer.
     */
    public DVDPlayer()
    {
        
        // No code needed
    }

    /**
     * Creates a DVDPlayer from a string in the format
     * id:desc:weeklyRate:rented
     * @param string The string
     * @return the new DVDPlayer
     */
    public static DVDPlayer createFromString(String string) {
        
        String[] tokens = string.split(":");
        DVDPlayer player = new DVDPlayer();
        player.setId(tokens[0]);
        player.setDescription(tokens[1]);
        player.setWeeklyRate(Double.parseDouble(tokens[2]));
        
        if (Boolean.parseBoolean(tokens[3]))
        {
            player.rented();

        }
        else
        {
            player.returned();
        }
        
        return player;
    }

    @Override
    public String saveToString() {
        
        return String.format("DVDPlayer~"+"%s:%s:%s:%s", this.getId(),this.getDescription(),this.getWeeklyRate(),this.isRented());
    }
}

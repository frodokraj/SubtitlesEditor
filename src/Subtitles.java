import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class Subtitles
{
    //Variables
    String filePath;
    String fileName;
    String headline;
    private ArrayList<Verse> verses = new ArrayList<Verse>();

    void addVerse(int number, @NotNull String startTime, @NotNull String stopTime, @NotNull ArrayList<String> content)
    {
        verses.add(new Verse(number,startTime,stopTime,content));
    }

    public ArrayList<Verse> getVerses()
    {
        return verses;
    }
}

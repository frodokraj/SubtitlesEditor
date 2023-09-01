import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SubtitlesImporter
{
    //Constructor
    public SubtitlesImporter(String subtitlesPath)
    {
        this.subtitlesPath = subtitlesPath;
    }

    //Variables
    private String subtitlesPath = "";
    private ArrayList<Line> subtitles = new ArrayList<>();

    //Methods
    public ArrayList<Line> importSubtitles() throws FileNotFoundException
    {
        Scanner lineScanner = new Scanner(new File(subtitlesPath));

        while (lineScanner.hasNextLine())
        {
            String section = lineScanner.nextLine();
            //Skip indentation
            if (section == null)
                continue;

            //Prepare line number
            int lineNumber = Integer.parseInt(section);

            //Prepare start and stop times
            section = lineScanner.nextLine();
            String[] times = section.split(" ");
            times[0] = times[0].replace(",", ".");
            times[2] = times[2].replace(",", ".");
            String startTime = times[0];
            String stopTime = times[2];

            //Prepare text
            String text = lineScanner.nextLine();
            ArrayList<String> textList = new ArrayList<>();
            while (!Objects.equals(text, ""))
            {
                textList.add(text);
                if(!lineScanner.hasNextLine())
                    break;
                text = lineScanner.nextLine();
            }
            Line newLine = new Line(lineNumber, startTime, stopTime, textList);
            subtitles.add(newLine);
        }

        return subtitles;
    }
}

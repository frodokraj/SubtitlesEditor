import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//TODO finish WebVTTConverter
public class WebVTTConverter implements Converter
{
    public WebVTTConverter(File file)
    {
        this.file = file;
    }

    File file;

    @Override
    public Subtitles createSubtitles() throws FileNotFoundException
    {
        Subtitles subtitles = new Subtitles();
        Scanner lineScanner = new Scanner(file);

        //Get headline
        subtitles.headline = lineScanner.nextLine();

        //Create verses
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
            ArrayList<String> content = new ArrayList<>();
            while (!Objects.equals(text, ""))
            {
                content.add(text);
                if(!lineScanner.hasNextLine())
                    break;
                text = lineScanner.nextLine();
            }
            subtitles.addVerse(lineNumber, startTime, stopTime, content);
        }

        return subtitles;
    }

    @Override
    public void extractSubtitles(Subtitles subtitles)
    {

    }
}

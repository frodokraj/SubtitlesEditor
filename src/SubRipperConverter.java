import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SubRipperConverter implements Converter
{
    public SubRipperConverter(File file)
    {
        this.file = file;
    }

    //Variables
    File file;

    @Override
    public Subtitles createSubtitles() throws FileNotFoundException
    {
        Subtitles subtitles = new Subtitles();
        Scanner lineScanner = new Scanner(file);

        //Save file name
        subtitles.fileName = file.getName();

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
    public void extractSubtitles(Subtitles subtitles) throws IOException
    {
        SubRipperPrinter subRipperPrinter = new SubRipperPrinter(subtitles);
        subRipperPrinter.printSubtitles();
    }
}

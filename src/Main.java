import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //Load file
        String subtitlesPath = userInput();
        SubtitlesImporter subtitlesImporter = new SubtitlesImporter(subtitlesPath);
        ArrayList<Line> subtitles = subtitlesImporter.importSubtitles();

        //Change time
        long change = Long.parseLong(userInput());
        subtitles.forEach((n) -> n.startTime = n.startTime.plusNanos( change * 1000000L) );
        subtitles.forEach((n) -> n.stopTime = n.stopTime.plusNanos( change * 1000000L) );

        //Create new file
        PrintWriter printWriter = new PrintWriter(new FileWriter(subtitlesPath));
        subtitles.forEach((n) ->
        {
                printWriter.println(n.number);
                printWriter.println(n.startTime + " --> " + n.stopTime);
                n.text.forEach(printWriter::println);
                printWriter.println("");
        });
        printWriter.println("");
    }

    static String userInput()
    {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //Import file
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the path to the file with subtitles:");
        String subtitlesPath = userInput.nextLine();
        SubtitlesImporter subtitlesImporter = new SubtitlesImporter(subtitlesPath);
        ArrayList<Line> subtitles = subtitlesImporter.importSubtitles();

        //Change time
        System.out.println("By how many milliseconds you want to move them?");
        long change = Long.parseLong(userInput.nextLine());
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
}
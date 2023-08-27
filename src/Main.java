import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //Load file
        String subtitlesPath = userInput();
        Scanner lineScanner = new Scanner(new File(subtitlesPath));
        ArrayList<Line> lines = new ArrayList<>();

        //Scan file
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
            lines.add(newLine);
        }

        //Change time
        long change = Long.parseLong(userInput());
        lines.forEach((n) -> n.startTime = n.startTime.plusNanos( change * 1000000L) );
        lines.forEach((n) -> n.stopTime = n.stopTime.plusNanos( change * 1000000L) );

        //Create new file
        PrintWriter printWriter = new PrintWriter(new FileWriter(subtitlesPath));
        lines.forEach((n) ->
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
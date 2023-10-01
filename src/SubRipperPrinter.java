import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SubRipperPrinter
{
    public SubRipperPrinter(Subtitles subtitles)
    {
        this.subtitles = subtitles;
    }

    //Variables
    Subtitles subtitles;
    void printSubtitles() throws IOException
    {
        PrintWriter printWriter = new PrintWriter(new FileWriter(new File(subtitles.filePath, subtitles.fileName)));

        subtitles.getVerses().forEach((n) ->
        {
            printWriter.println(n.number);
            printWriter.println(n.startTime + " --> " + n.stopTime);
            n.content.forEach(printWriter::println);
            printWriter.println("");
            printWriter.flush();
        });

        printWriter.println("");
    }

}

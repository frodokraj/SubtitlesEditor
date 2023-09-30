import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //Get subtitles path
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the path to the file with subtitles:");
        String subtitlesPath = userInput.nextLine();

        //Create converter and use it
        ConverterFactory CF = new ConverterFactory();
        Converter converter = CF.createConverter(new File(subtitlesPath));
        Subtitles subtitles = converter.createSubtitles();



    }
}
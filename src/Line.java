import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;

public class Line
{
    Line(int number, String startTime, String stopTime, ArrayList<String> text)
    {
        this.number = number;
        this.startTime = LocalTime.parse(startTime);
        this.stopTime = LocalTime.parse(stopTime);
        this.text = text;
    }
    int number;
    LocalTime startTime;
    LocalTime stopTime;
    ArrayList<String> text;
}

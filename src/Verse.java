import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.ArrayList;

public class Verse
{
    Verse(int number, @NotNull String startTime,@NotNull String stopTime,@NotNull ArrayList<String> content)
    {
        this.number = number;
        this.startTime = LocalTime.parse(startTime);
        this.stopTime = LocalTime.parse(stopTime);
        this.content = content;
    }
    int number;
    LocalTime startTime;
    LocalTime stopTime;
    ArrayList<String> content;
}

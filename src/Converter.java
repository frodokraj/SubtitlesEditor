import java.io.FileNotFoundException;
import java.io.IOException;

public interface Converter
{
    Subtitles createSubtitles() throws FileNotFoundException;
    void extractSubtitles(Subtitles subtitles) throws IOException;
}

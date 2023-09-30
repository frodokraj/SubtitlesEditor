import java.io.FileNotFoundException;

public interface Converter
{
    Subtitles createSubtitles() throws FileNotFoundException;
    void extractSubtitles(Subtitles subtitles);
}

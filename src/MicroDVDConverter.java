import java.io.File;
//TODO find out how to use with frames
public class MicroDVDConverter implements Converter
{
    public MicroDVDConverter(File file)
    {
        this.file = file;
    }

    //Variables
    File file;
    Short frames = 24;

    @Override
    public Subtitles createSubtitles()
    {
        return null;
    }

    @Override
    public void extractSubtitles(Subtitles subtitles)
    {

    }
}


import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class ConverterFactory
{
    public Converter createConverter(@NotNull File file) throws FileNotFoundException
    {
        String[] fileName = file.getName().split("\\.");
        String extension = fileName[fileName.length - 1];

        if (Objects.equals(extension, "srt"))
        {
            return new SubRipperConverter(file);
        }
        else if(Objects.equals(extension, "vtt"))
        {
            return new WebVTTConverter(file);
        }
        else if (Objects.equals(extension, "sub"))
        {
            return new MicroDVDConverter(file);
        }
        else
        {
            System.out.println("File extension is not supported");
            return null;
        }
    }
}

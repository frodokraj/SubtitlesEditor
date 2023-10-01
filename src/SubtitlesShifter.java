public class SubtitlesShifter
{
    public SubtitlesShifter(Subtitles subtitles)
    {
        this.subtitles = subtitles;
    }

    //Variables
    Subtitles subtitles;

    void shiftByMilliseconds(long howMany)
    {
        subtitles.getVerses().forEach((n) -> n.startTime = n.startTime.plusNanos( howMany * 1000000L) );
        subtitles.getVerses().forEach((n) -> n.stopTime = n.stopTime.plusNanos( howMany * 1000000L) );
    }

    void shiftBySeconds(long howMany)
    {
        subtitles.getVerses().forEach((n) -> n.startTime = n.startTime.plusSeconds(howMany));
        subtitles.getVerses().forEach((n) -> n.stopTime = n.stopTime.plusNanos(howMany));
    }

    void shiftByMinutes(long howMany)
    {
        subtitles.getVerses().forEach((n) -> n.startTime = n.startTime.plusMinutes(howMany));
        subtitles.getVerses().forEach((n) -> n.stopTime = n.stopTime.plusMinutes(howMany));
    }
}

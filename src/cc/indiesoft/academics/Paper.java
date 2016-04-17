package cc.indiesoft.academics;

public class Paper
{
    public Paper()
    {
        setName("paperName");
        setJournalName("journalName");
        setJournalID(0);
        setPublishedTime("publishedTime");
        setType(1);
    }

    public Paper(String paperName, String journalName, int journalID, String publishedTime,
                 int type)
    {
        setName(paperName);
        setJournalName(journalName);
        setJournalID(journalID);
        setPublishedTime(publishedTime);
        setType(type);
    }

    public Paper(String paperName, String journalName, int step)
    {
        setName(paperName);
        setJournalName(journalName);
        setStep(step);
    }

    private String name;

    public void setName(String _paperName)
    {
        name = _paperName;
    }

    public String getName()
    {
        return name;
    }

    private String journalName;
    public void setJournalName(String _journalName)
    {
        journalName = _journalName;
    }
    public String getJournalName()
    {
        return journalName;
    }

    private int journalID;
    public void setJournalID(int _journalID)
    {
        journalID = _journalID;
    }

    private String publishedTime;
    public void setPublishedTime(String _publishedTime)
    {
        publishedTime = _publishedTime;
    }
    public String getPublishedTime()
    {
        return publishedTime;
    }

    private int type;
    public void setType(int _type)
    {
        type = _type;
    }
    public boolean isSCI()
    {
        return type == 1;
    }

    public boolean isEI()
    {
        return type == 2;
    }

    public boolean isChineseCore()
    {
        return type == 3;
    }

    private int step;
    public void setStep(int _step)
    {
        step = _step;
    }
    public int getStep()
    {
        return step;
    }
}

package blockchain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import assets.ColorText;

public class Data 
{
    private Date timeStamp;
    private String content;
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");

    public Data()
    {

    }

    public Data(Data data)
    {
        this.timeStamp = data.timeStamp;
        this.content = data.content;
    }

    public Data(Date timeStamp, String content)
    {
        this.timeStamp = timeStamp;
        this.content = content;
    }

    public Data(String time, String content) throws ParseException
    {
        this.timeStamp = this.DATE_FORMAT.parse(time);
        this.content = content;
    }

    public Data(String content)
    {
        this.content = content;
        this.timeStamp = new Date();
    }

    void setTimeStamp(Date timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    void setContent(String content)
    {
        this.content = content;
    }

    Date getTimeStamp()
    {
        return this.timeStamp;
    }

    String getContent()
    {
        return this.content;
    }

    @Override
    public String toString()
    {
        return ColorText.TEXT_BLUE + "Data: " + ColorText.TEXT_RESET + ColorText.TEXT_YELLOW + this.getContent() + ColorText.TEXT_RESET + "\n" +
               ColorText.TEXT_BLUE + "Transaction time: " + ColorText.TEXT_RESET + this.getTimeStamp();
    }
}
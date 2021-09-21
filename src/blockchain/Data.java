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

    Data()
    {

    }

    Data(Data data)
    {
        this.timeStamp = data.timeStamp;
        this.content = data.content;
    }

    Data(Date timeStamp, String content)
    {
        this.timeStamp = timeStamp;
        this.content = content;
    }

    Data(String time, String content) throws ParseException
    {
        this.timeStamp = this.DATE_FORMAT.parse(time);
        this.content = content;
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
        return ColorText.TEXT_YELLOW + "Data: " + ColorText.TEXT_RESET + this.getContent() + "\n" +
               ColorText.TEXT_YELLOW + "Transaction time: " + ColorText.TEXT_RESET + this.getTimeStamp();
    }
}

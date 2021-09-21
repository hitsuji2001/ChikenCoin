package blockchain;

import assets.ColorText;

public class Block extends Data
{
    private static int index = 0;
    private int height;
    private Data data;
    private String hashCode;
    private String previousHashCode;

    Block()
    {
        index++;
    }

    Block(Data data)
    {
        this.height = index;
        this.data = data;
        this.hashCode = this.calculateHash();
    }

    Block(Data data, String hashCode, String previousHashCode)
    {
        this.height = index;
        this.data = data;
        this.hashCode = hashCode;
        this.previousHashCode = previousHashCode;
    }

    //Calculate the SHA-256 of the Block
    private String calculateHash()
    {
        return "";
    }

    String getHash()
    {
        return this.hashCode;
    }

    String getPreviousHash()
    {
        return this.previousHashCode;
    }

    int getHeight()
    {
        return this.height;
    }

    void setHash(String hashCode)
    {
        this.hashCode = hashCode;
    }

    void setPreviousHash(String prev)
    {
        this.previousHashCode = prev;
    }

    @Override
    public String toString()
    {
        return ColorText.TEXT_YELLOW + "Block index: " + ColorText.TEXT_RESET + this.height + "\n"
                + this.data.toString() + "\n"
                + ColorText.TEXT_YELLOW + "Block's SHA-256 code: " + ColorText.TEXT_RESET + this.hashCode + "\n"
                + ColorText.TEXT_YELLOW + "Block's SHA-256 previous code: " + ColorText.TEXT_RESET + this.previousHashCode;
    }
}
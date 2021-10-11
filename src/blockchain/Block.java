package blockchain;

import assets.ColorText;
import encode.SHA_256;

public class Block
{
    private static int index = 0;
    private int height;
    private Data data;
    private String hashCode;
    private String previousHashCode;

    public Block()
    {
        index++;
    }

    public Block(Data data)
    {
        this.height = index;
        this.data = data;
        this.hashCode = this.calculateHash();
        index++;
    }

    public Block(Data data, String hashCode, String previousHashCode)
    {
        this.height = index;
        this.data = data;
        this.hashCode = hashCode;
        this.previousHashCode = previousHashCode;
        index++;
    }

    //Calculate the SHA-256 of the Block
    private String calculateHash()
    {
        return SHA_256.getSHA256HashCode(this.data.toString());
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

    Data getData()
    {
        return this.data;
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
        return ColorText.TEXT_BLUE + "Block index: " + ColorText.TEXT_RESET + this.height + "\n"
                + ColorText.TEXT_YELLOW + this.data.toString() + ColorText.TEXT_RESET + "\n"
                + ColorText.TEXT_BLUE + "Block's SHA-256 code: " + ColorText.TEXT_RESET + this.hashCode + "\n"
                + ColorText.TEXT_BLUE + "Block's SHA-256 previous code: " + ColorText.TEXT_RESET + this.previousHashCode;
    }
}
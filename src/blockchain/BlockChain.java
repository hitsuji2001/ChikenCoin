package blockchain;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;

import encode.SHA_256;

public class BlockChain extends Block
{
    ArrayList <Block> blockChain = new ArrayList<>();

    public BlockChain()
    {
        this.generateGenesisBlock();
    }

    private void generateGenesisBlock()
    {
        try
        {
            Data data = new Data("21/09/2021", "Chicken Coin was created");
            Block genesisBlock = new Block(data);
            genesisBlock.setHash(SHA_256.getSHA256HashCode(data.toString()));
            genesisBlock.setPreviousHash("0");

            this.blockChain.add(genesisBlock);
        }
        catch(ParseException exception)
        {
            exception.printStackTrace();
        }
        catch(NoSuchAlgorithmException exception)
        {
            exception.printStackTrace();
        }
    }

    public void addBlock()
    {

    }

    void alterBlock()
    {

    }

    public void getLatestBlock()
    {

    }

    public void getBlockAt(int index)
    {

    }

    public ArrayList <Block> getChain()
    {
        return this.blockChain;
    }

    public boolean isValidChain()
    {
        return true;
    }

    public void printChain()
    {
        for(Block b : this.blockChain)
        {
            System.out.println(b);
        }
    }
}

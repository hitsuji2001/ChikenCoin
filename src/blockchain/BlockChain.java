package blockchain;

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
            System.err.println("Not a valid date, how could you manage such thing?");
        }
    }

    public void addBlock(Block block)
    {
        this.blockChain.add(block);
    }

    void alterBlock()
    {

    }

    public Block getLatestBlock()
    {
       return this.blockChain.get(this.blockChain.size());
    }

    public Block getBlockAt(int index)
    {
        if(index > this.blockChain.size()) throw new IndexOutOfBoundsException();
        else
        {
            return this.blockChain.get(index);
        }
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

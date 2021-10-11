package blockchain;

import java.text.ParseException;
import java.util.ArrayList;

import assets.ColorText;
import encode.SHA_256;

public class BlockChain
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
            System.err.println(ColorText.TEXT_RED + "Not a valid date, how could you manage such thing?" + ColorText.TEXT_RESET);
        }
    }

    public void addBlock(Block block)
    {
        block.setPreviousHash(this.blockChain.get(this.blockChain.size() - 1).getHash());
        this.blockChain.add(block);
    }

    void alterBlock()
    {
        //TODO:
    }

    public Block getLatestBlock()
    {
       return this.blockChain.get(this.blockChain.size());
    }

    public Block getBlockAt(int index)
    {
        if(index > this.blockChain.size() || index < 0) throw new IndexOutOfBoundsException();
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
            System.out.println("----------------------------------------------------");
        }
    }
}

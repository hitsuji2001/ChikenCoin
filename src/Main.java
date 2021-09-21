import blockchain.Block;
import blockchain.BlockChain;

public class Main 
{
    public static void main(String[] args) 
    {
        BlockChain blockChain = new BlockChain();

        for(Block b : blockChain.getChain())
        {
            System.out.println(b);
        }
    }
}
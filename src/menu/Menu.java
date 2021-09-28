package menu;

import blockchain.Block;
import blockchain.BlockChain;
import blockchain.Data;

import java.text.ParseException;
import java.util.Scanner;

import assets.ColorText;

public class Menu 
{
    private static BlockChain blockChain = new BlockChain();
    private static Mode mode = Mode.AdministratorMode;

    public Menu()
    {

    }

    Menu(Mode mode)
    {
        Menu.mode = mode;
    }

    public static void printMenu()
    {
        System.out.println(ColorText.TEXT_YELLOW + "---------------------MENU---------------------" + ColorText.TEXT_RESET);
        System.out.println("1. Add Block");
        System.out.println("2. Add Multiple Block");
        System.out.println("3. Alter Block");
        System.out.println("4. Print Lastest Block");
        System.out.println("5. Print Block at:");
        System.out.println("6. Print All Block in the Blockchain");
        System.out.println("7. Change Privilege");
        System.out.println("8. Clear Screen");
        System.err.println("9. Quit");
        System.out.println(ColorText.TEXT_YELLOW + "--- Current Privilage Mode: " + Menu.mode + " ---" + ColorText.TEXT_RESET);
        System.out.print("Your choice: ");
    }

    public static int getInput(Scanner scanner)
    {
        return Integer.parseInt(scanner.nextLine());
    }

    public static void handle(Mode privilegeMode, Scanner scanner)
    {
        Menu.printMenu();

        int choice = Integer.parseInt(scanner.nextLine());

        Menu.handleMenu(privilegeMode, scanner, choice);
    }

    private static void handleMenu(Mode privilegeMode, Scanner scanner, int choice)
    {
        switch (choice) 
        {
            case 1:
                Menu.handleAddBlock(scanner);

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 2:
                Menu.handleAddMultipleBlock(scanner);

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 3:
                //TODO: Add alter block function

                System.err.println(ColorText.TEXT_RED + "Not implement yet." + ColorText.TEXT_RESET);
                
                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 4:
                System.out.println(Menu.blockChain.getBlockAt(Menu.blockChain.getChain().size() - 1).toString());

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 5:
                //TODO: Add function to print block at random index
                System.err.println(ColorText.TEXT_RED + "Not implement yet." + ColorText.TEXT_RESET);
                
                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 6:
                Menu.blockChain.printChain();

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 7:
                if(Menu.mode == Mode.AdministratorMode) Menu.mode = Mode.ClientMode;
                else Menu.mode = Mode.AdministratorMode;    

                System.out.println(ColorText.TEXT_GREEN + "Privilege mode changed succesfully. " + ColorText.TEXT_RESET + "Current Privilege mode is: " + ColorText.TEXT_YELLOW + Menu.mode + ColorText.TEXT_RESET);

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 8:
                Menu.clearScreen();
                Menu.handle(privilegeMode, scanner);
                break;
            case 9:
                break;
            default:
                System.err.println("There's only 9 options, what the hell are you doing?");
                break;
        }
    }

    private static void handleAddBlock(Scanner scanner)
    {
        System.out.println("Please enter the data to encrypt, " + ColorText.TEXT_YELLOW + "MUST be written in 1 line:" + ColorText.TEXT_RESET);
        System.out.print(ColorText.TEXT_GREEN + "Transaction information: " + ColorText.TEXT_RESET);
        
        Data data = new Data(scanner.nextLine().trim());
        Block block = new Block(data);

        blockChain.addBlock(block);
        System.out.println(ColorText.TEXT_GREEN + "Succesfully adding a block into Block Chain!" + ColorText.TEXT_RESET);
    }

    private static void handleAddMultipleBlock(Scanner scanner)
    {
        int size;
        
        System.out.print("Please enter the number of block you want to add: ");
        size = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < size; i++)
        {
            Menu.handleAddBlock(scanner);
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}

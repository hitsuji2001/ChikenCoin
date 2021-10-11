package menu;

import blockchain.Block;
import blockchain.BlockChain;
import blockchain.Data;

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

    private static void printAdminMenu()
    {
        System.out.println(ColorText.TEXT_YELLOW + "---------------------MENU---------------------" + ColorText.TEXT_RESET);
        System.out.println("1. Add Block");
        System.out.println("2. Add Multiple Block");
        System.out.println("3. Print Lastest Block");
        System.out.println("4. Print Block at:");
        System.out.println("5. Print All Block in the Blockchain");
        System.out.println("6. Change Privilege");
        System.out.println("7. Clear Screen");
        System.err.println("8. Quit");
        System.out.println(ColorText.TEXT_YELLOW + "--- Current Privilage Mode: " + Menu.mode + " ---" + ColorText.TEXT_RESET);
        System.out.print("Your choice: ");
    }

    private static void printClientMenu()
    {
        System.out.println(ColorText.TEXT_YELLOW + "---------------------MENU---------------------" + ColorText.TEXT_RESET);
        System.out.println("1. Print Lastest Block");
        System.out.println("2. Print Block at:");
        System.out.println("3. Print All Block in the Blockchain");
        System.out.println("4. Change Privilege");
        System.out.println("5. Clear Screen");
        System.err.println("6. Quit");
        System.out.println(ColorText.TEXT_YELLOW + "--- Current Privilage Mode: " + Menu.mode + " ---" + ColorText.TEXT_RESET);
        System.out.print("Your choice: ");
    }

    public static void printMenu(Mode mode)
    {
        if(mode == Mode.AdministratorMode) Menu.printAdminMenu();
        else if(mode == Mode.ClientMode) Menu.printClientMenu();
    }

    public static int getInput(Scanner scanner)
    {
        return Integer.parseInt(scanner.nextLine());
    }

    public static void handle(Mode privilegeMode, Scanner scanner)
    {
        Menu.printMenu(mode);

        int choice = Integer.parseInt(scanner.nextLine());

        Menu.handleMenu(scanner, choice);
    }

    private static void handleAdminMenu(Mode privilegeMode, Scanner scanner, int choice)
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
                System.out.println(Menu.blockChain.getBlockAt(Menu.blockChain.getChain().size() - 1).toString());

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 4:
                try
                {
                    System.out.print(ColorText.TEXT_GREEN + "Wanna print the block at index: " + ColorText.TEXT_RESET);
                    Menu.handlePrintBlockAt(Integer.parseInt(scanner.nextLine()));
                }
                catch(IndexOutOfBoundsException exception)
                {
                    System.err.println(ColorText.TEXT_RED + "Invalid index" + ColorText.TEXT_RESET);
                }
                
                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 5:
                Menu.blockChain.printChain();

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 6:
                if(Menu.mode == Mode.AdministratorMode) Menu.mode = Mode.ClientMode;
                else Menu.mode = Mode.AdministratorMode;    

                System.out.println(ColorText.TEXT_GREEN + "Privilege mode changed succesfully. " + ColorText.TEXT_RESET + "Current Privilege mode is: " + ColorText.TEXT_YELLOW + Menu.mode + ColorText.TEXT_RESET);

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 7:
                Menu.clearScreen();
                Menu.handle(privilegeMode, scanner);
                break;
            case 8:
                break;
            default:
                System.err.println("There's only 8 options, what the hell are you doing?");
                break;
        }
    }

    private static void handleClientMenu(Mode privilegeMode, Scanner scanner, int choice)
    {
        switch (choice) 
        {
            case 1:
                System.out.println(Menu.blockChain.getBlockAt(Menu.blockChain.getChain().size() - 1).toString());

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 2:
                try
                {
                    System.out.print(ColorText.TEXT_GREEN + "Wanna print the block at index: " + ColorText.TEXT_RESET);
                    Menu.handlePrintBlockAt(Integer.parseInt(scanner.nextLine()));
                }
                catch(IndexOutOfBoundsException exception)
                {
                    System.err.println(ColorText.TEXT_RED + "Invalid index" + ColorText.TEXT_RESET);
                }
                
                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 3:
                Menu.blockChain.printChain();

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 4:
                if(Menu.mode == Mode.AdministratorMode) Menu.mode = Mode.ClientMode;
                else Menu.mode = Mode.AdministratorMode;    

                System.out.println(ColorText.TEXT_GREEN + "Privilege mode changed succesfully. " + ColorText.TEXT_RESET + "Current Privilege mode is: " + ColorText.TEXT_YELLOW + Menu.mode + ColorText.TEXT_RESET);

                System.out.println("Press Enter key to continue...");
                scanner.nextLine();

                Menu.handle(privilegeMode, scanner);
                break;
            case 5:
                Menu.clearScreen();
                Menu.handle(privilegeMode, scanner);
                break;
            case 6:
                break;
            default:
                System.err.println("There's only 6 options, what the hell are you doing?");
                break;
        }
    }

    private static void handleMenu(Scanner scanner, int choice)
    {
        if(Menu.mode == Mode.AdministratorMode) Menu.handleAdminMenu(Mode.AdministratorMode, scanner, choice);
        else if(Menu.mode == Mode.ClientMode) Menu.handleClientMenu(Mode.ClientMode, scanner, choice);
    }

    private static void handlePrintBlockAt(int index) throws IndexOutOfBoundsException
    {
        System.out.println(Menu.blockChain.getBlockAt(index));
    }

    private static void handleAddBlock(Scanner scanner)
    {
        System.out.println("Please enter the data to encrypt, " + ColorText.TEXT_YELLOW + "MUST be written in 1 line:" + ColorText.TEXT_RESET);
        System.out.print(ColorText.TEXT_GREEN + "Transaction information: " + ColorText.TEXT_RESET);
        
        Data data = new Data(scanner.nextLine().trim());
        Block block = new Block(data);

        Menu.blockChain.addBlock(block);
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

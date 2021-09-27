package menu;

import java.util.Scanner;

public class App 
{
    private Mode mode;
    private Scanner scanner = new Scanner(System.in);

    public App()
    {
        this.mode = Mode.AdministratorMode;
    }

    public void run()
    {
        if(this.mode == Mode.AdministratorMode) this.runAsAdministrator();
        else this.runAsClient();
    }

    private void runAsAdministrator()
    {
        Menu.handle(Mode.AdministratorMode, scanner);
    }

    private void runAsClient()
    {
        Menu.handle(Mode.ClientMode, scanner);
    }
}

import java.util.ArrayList;
import java.util.Scanner;
public class ListMaker {

    static ArrayList<String> list = new ArrayList<>();

    static Scanner console = new Scanner(System.in);

    static final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
    static String cmd = "";
    static boolean done = false;

    public static void main(String[] args) {

        do {

            cmd = displayInformation();

            switch(cmd)
            {
                case "A":
                    add();
                    break;
                case "D":
                    delete();
                    break;
                case "P":
                    print();
                    break;
                case "Q":
                    quit();
                    break;
            }

        } while (!done);

        System.exit(0);

    }

    private static String displayInformation()
    {

        System.out.print("\n");
        for (int i = 0; i < 40; i++)
        {
            System.out.print("+");
        }
        System.out.print("\n");
        if (list.size() != 0)
        {
            for (String item: list)
            {
                System.out.printf("%3s", item);
                System.out.print("\n");
            }
        }
        else {
            System.out.print("+++");
            for (int i = 0; i < 10; i++) {
                System.out.print(" ");
            }
            System.out.print("List is empty");
            for (int i = 0; i < 10; i++) {
                System.out.print(" ");
            }
            System.out.print("+++");
            System.out.print("\n");
        }
        for (int i = 0; i < 40; i++)
        {
            System.out.print("+");
        }
        System.out.print("\n");


        String input = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
        input = input.toUpperCase();

        return input;

    }

    private static void add()
    {
        String item = SafeInput.getNonZeroLenString(console, "Enter your item");
        list.add(item);
    }

    private static void delete()
    {
        displayNumberedList();

        if (list.size() >= 1)
        {
            int choice = SafeInput.getRangedInt(console, "What item number do you want to delete?", 1, list.size());
            choice -= 1;
            list.remove(choice);
        }
        else {
            System.out.println("Error: The list is currently empty, there are no items to delete!\n");
        }

    }

    private static void print()
    {
        for (int i = 0; i < 40; i++)
        {
            System.out.print("+");
        }
        System.out.println("");
        if (list.size() != 0)
        {
            for (String item: list)
            {
                System.out.printf("%3s", item);
                System.out.print("\n");
            }
        }
        else {
            System.out.print("+++");
            for (int i = 0; i < 10; i++) {
                System.out.print(" ");
            }
            System.out.print("List is empty");
            for (int i = 0; i < 10; i++) {
                System.out.print(" ");
            }
            System.out.print("+++");
            System.out.print("\n");
        }
        for (int i = 0; i < 40; i++)
        {
            System.out.print("+");
        }
        System.out.println("\n");
    }

    private static void quit()
    {
        boolean confirm = SafeInput.getYNConfirm(console, "Are you sure you want to quit");
        if (confirm == true) {
            done = true;
        }
    }

    private static void displayNumberedList()
    {
        for (int i = 0; i < 40; i++)
        {
            System.out.print("+");
        }
        System.out.print("\n");
        if (list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i+1, list.get(i));
                System.out.print("\n");
            }
        }
        else {
            System.out.print("+++");
            for (int i = 0; i < 10; i++) {
                System.out.print(" ");
            }
            System.out.print("List is empty");
            for (int i = 0; i < 10; i++) {
                System.out.print(" ");
            }
            System.out.print("+++");
            System.out.print("\n");
        }
        for (int i = 0; i < 40; i++)
        {
            System.out.print("+");
        }
        System.out.print("\n");

    }

}
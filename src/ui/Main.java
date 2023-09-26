import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private Scanner cin = new Scanner(System.in);
    public Main(){
        cin = new Scanner(System.in);

    }

    public static void main(String[] args){
        int option = 0 ;
        Main view = new Main();

        do{
            try{
                view.menu();
                option = view.cin.nextInt();

            }
            catch (InputMismatchException e){
                System.out.println("Please enter a number");
            }



        }while( option != 0);

    }
    //Menu
    public void menu(){

        System.out.println("1. Add activity");
        System.out.println("2. Remove activity");
        System.out.println("3. Modify activity");
        System.out.println("4. Show activities");
        System.out.println("5. Undo");
        System.out.println("0. Exit");


    }

    //Execute option
    public void executeOption(int option){
       switch (option){
           case 0 ->{
               System.out.println("Bye");

           }
           case 1 ->{
               System.out.println("Add activity");

           }
           case 2 ->{
               System.out.println("Remove activity");

           }
           case 3 ->{
               System.out.println("Modify activity");

           }
           case 4 ->{
                System.out.println("Show activities");

           }
           case 5 ->{
                System.out.println("Undo");

           }
           default -> {
               System.out.println("Invalid option");
           }

       }


    }




    //
}
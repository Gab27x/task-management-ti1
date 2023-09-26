package ui;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Controller;

public class Main {
    private Scanner cin;
    private Controller controller;
    public Main(){
        cin = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[] args){
        int option = -1 ;
        Main view = new Main();

        do{
            try{
                view.menu();

                option = view.cin.nextInt();

                view.executeOption(option);

            }
            catch (InputMismatchException e){
                view.cin.nextLine();
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

    // Case 1
    public void addActivity(){

    }
    // Case 2
    public void deleteActivity(){

    }

    // Case 3
    public void modifyActivity(){

    }
    // Case 4
    public void showActivities(){

    }
    // Case 5
    public void undo(){

    }



}
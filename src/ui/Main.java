package ui;
import java.util.Calendar;
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
        String id ,description ,location ;
        Calendar dueDate;

        System.out.println("Enter the id");
        id = cin.nextLine();
        System.out.println("Enter the description");
        description = cin.nextLine();
        System.out.println("Enter the location");
        location = cin.nextLine();
        System.out.println("Enter the due date");
        dueDate = Calendar.getInstance();

        /*controller.addActivity(id, description, dueDate, location);
*/
    }
    // Case 2
    public void deleteActivity(){
        System.out.println("Enter the id of the activity to delete");
        String id = cin.nextLine();
/*        controller.deleteActivity(id);*/

    }

    // Case 3
    public void modifyActivity(){
        System.out.println("Enter the id of the activity to modify");
        String id = cin.nextLine();
        System.out.println("Enter the option to modify");
        int option = cin.nextInt();

        switch (option){
            case 1 ->{
                System.out.println("Enter the new loaction");
                String location = cin.nextLine();
                /*controller.modifyActivityLocation(id, location);*/

            }
            case 2 ->{
                System.out.println("Enter the new description");
                String description = cin.nextLine();
                /*controller.modifyActivityDescription(id, description);*/

            }
            case 3 ->{
                System.out.println("Enter the new due date");
                Calendar newDate = Calendar.getInstance();
                /*controller.modifyActivityDate(id, newDate);*/

            }

        }

    }
    // Case 4
    public void showActivities(){
        System.out.println(controller.showActivities());

    }
    // Case 5
    public void undo(){
        controller.undo();

    }



}
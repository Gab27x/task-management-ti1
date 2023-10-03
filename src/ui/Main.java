package ui;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Controller;
import java.text.SimpleDateFormat;

public class Main {
    private Scanner cin;
    private Controller controller;
    private SimpleDateFormat simpleDateFormat;
    public Main(){
        cin = new Scanner(System.in);
        controller = new Controller();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public static void main(String[] args){
        int option = -1 ;
        Main view = new Main();

        do{
            try{
                view.menu();

                System.out.print("\tSELECT OPTION: ");
                option = view.cin.nextInt();

                view.executeOption(option);

            }
            catch (InputMismatchException e){
                view.cin.nextLine();
                System.out.println("""
                \t╔══════════════════════════════╗
                \t║    PLEASE ENTER AN INTEGER   ║
                \t╚══════════════════════════════╝
                """);
            }

        }while( option != 0);

    }
    //Menu
    public void menu(){
        System.out.println("""
                \t╔══════════════════════════════╗
                \t║    WELCOME TO TASK MANAGER   ║
                \t╚══════════════════════════════╝
                """);

/*        showHashTable();*/

        System.out.println("""
                \t╔══════════════════════════════╗
                \t║            MENU              ║
                \t║      1. ADD ACTIVITY         ║
                \t║      2. MODIFY ACTIVITY      ║
                \t║      3. DELETE ACTIVITY      ║
                \t║      4. FILTER BY PRIORITY   ║
                \t║      5. FILTER BY DUE DATE   ║
                \t║      6. UNDO                 ║
                \t║      0. EXIT                 ║
                \t╚══════════════════════════════╝
                      
                """
        );



    }

    //Execute option
    public void executeOption(int option){
       switch (option){
           case 0 ->{
               System.out.println("""
                \t╔══════════════════════════════╗
                \t║              BYE             ║
                \t╚══════════════════════════════╝
                """);

           }
           case 1 ->{
               System.out.println("""
                \t╔══════════════════════════════╗
                \t║          ADD ACTIVITY        ║
                \t╚══════════════════════════════╝
                """);

                addActivity();
/*                showHashTable();*/

           }
           case 2 ->{
               System.out.println("""
                \t╔══════════════════════════════╗
                \t║         MODIFY ACTIVITY      ║
                \t╚══════════════════════════════╝
                """);

               modifyActivity();
           }
           case 3 ->{
               System.out.println("""
                \t╔══════════════════════════════╗
                \t║        DELETE ACTIVITY       ║
                \t╚══════════════════════════════╝
                """);

               deleteActivity();
           }
           case 4 ->{
               System.out.println("""
                \t╔══════════════════════════════╗
                \t║          FILTER       1      ║
                \t╚══════════════════════════════╝
                """);


           }
           case 5 ->{
               System.out.println("""
                \t╔══════════════════════════════╗
                \t║          FILTER      2       ║
                \t╚══════════════════════════════╝
                """);

           }
           case 6 ->{
               System.out.println("""
                \t╔══════════════════════════════╗
                \t║             UNDO             ║
                \t╚══════════════════════════════╝
                """);
                undo();
           }
           default -> {
               System.out.println("""
                \t╔══════════════════════════════╗
                \t║         INVALID OPTION       ║
                \t╚══════════════════════════════╝
                """);

           }

       }


    }

    // Case 1
    public void addActivity(){
        int id;
        String title,description ,location ;
        Calendar dueDate;

        cin.nextLine();
        
        System.out.print("\tENTER THE TITLE: ");
        title = cin.nextLine();
        
        System.out.print("\tENTER THE DESCRIPTION: ");
        description = cin.nextLine();
        
        System.out.print("\tENTER THE LOCATION: ");
        location = cin.nextLine();


        System.out.print("\tENTER THE ID: ");
        id = cin.nextInt();
        cin.nextLine();

        
        System.out.println("\n\t\tENTER THE DUE DATE \n");


        // FIXME ADD DATE
        dueDate = createdate();
        System.out.println(convDateFormat(dueDate));

    /* Calendar.getInstance();*/

        controller.addActivity(id,title ,description, dueDate, location);
    }
    // Case 2
    public void deleteActivity(){
        System.out.print("\tENTER THE ID: ");

        Integer id = cin.nextInt();
        controller.deleteActivity(id);

    }

    // Case 3
    public void modifyActivity(){
        System.out.print("\tENTER THE ID: ");
        Integer id = cin.nextInt();

        System.out.println("""
                \t╔══════════════════════════════╗
                \t║            MENU              ║
                \t║      1. LOCATION             ║
                \t║      2. DESCRIPTION          ║
                \t║      3. DUE DATE             ║
                \t║      4. ¿TITLE?              ║
                \t╚══════════════════════════════╝
                      
                """
        );

        System.out.print("\tSELECT OPTION: ");
        int option = cin.nextInt();

        switch (option){
            case 1 ->{
                cin.nextLine();
                System.out.print("\tENTER THE NEW LOCATION: ");
                String location = cin.nextLine();
                controller.modifyActivityLocation(id, location);

            }
            case 2 ->{
                cin.nextLine();
                System.out.print("\tENTER THE NEW DESCRIPTION: ");
                String description = cin.nextLine();
                controller.modifyActivityDescription(id, description);

            }
            case 3 ->{
                System.out.print("\tENTER THE NEW DUE DATE: ");
                // FIXME ADD DATE
                Calendar newDate = createdate();
                System.out.println(convDateFormat(newDate));
                controller.modifyActivityDate(id, newDate);

            }

        }

    }

    // Case 4


    // Case 5


    // Case 6
    public void undo(){
        controller.undo();

    }


    public void showHashTable(){
        System.out.println(controller.showHashTable());

    }

    // Calendar methods

    public Calendar createdate(){
        Calendar newDate =  Calendar.getInstance();

        System.out.print("\tENTER YEAR: ");
        int year = 0;

        do{
            year = cin.nextInt();
            if(year<2023){
                System.out.println("Enter a valid input");
            }

        }while(year<2023);

        System.out.print("\tENTER MONTH (1-12): ");
        int month = 0;
        do{
            month = (cin.nextInt()) - 1;
            if(month<0 || month>11){
                System.out.println("Enter a valid input ");
            }


        }while(!(month>=0 && month<=11));


        System.out.print("\tENTER DAY: ");
        int day =0;
        do{
            day = cin.nextInt();
            if(day<1 || day>31){
                System.out.println("Enter a valid input");
            }

        }while(!(day>=1 && day<=31));


        newDate.set(year, month, day);

        return newDate;

    }



    public String convDateFormat(Calendar date){

        return simpleDateFormat.format(date.getTime());

    }






}
/*    public Calendar createdate(){
        Calendar newDate =  Calendar.getInstance();

        System.out.println("Enter year:");
        int year =0;
        do{
            year = cin.nextInt();
            if(year<=0){
                System.out.println("Enter a valid input");
            }

        }while(year<=0);

        System.out.println("Enter month (1-12):");
        int month = 0;
        do{
            month = (cin.nextInt()) - 1;
            if(month<0 || month>11){
                System.out.println("Enter a valid input");
            }


        }while(!(month>=0 && month<=11));


        System.out.println("Enter day of the month:");
        int day =0;
        do{
            day = cin.nextInt();
            if(day<1 || day>31){
                System.out.println("Enter a valid input");
            }

        }while(!(day>=1 && day<=31));


        newDate.set(year, month, day);

        return newDate;

    }*/

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

        System.out.println("""
                ╔══════════════╗
                ║   MY TASKS   ║
                ╚══════════════╝
                """);
        showHashTable();
        System.out.println("\t" + controller.getActivities().isEmpty());
        System.out.println("\t" + controller.getActivities().getExistingNodes());
        showArray();

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

/*        cin.nextLine();*/

        System.out.println("\n\t\tENTER THE DUE DATE \n");

        dueDate = createdate();

        controller.addActivity(id,title ,description, dueDate, location);
    }

    // Case 2
    public void deleteActivity(){
        System.out.print("\tENTER THE ID: ");

        Integer id = cin.nextInt();
        if(controller.deleteActivity(id)){
            System.out.println();

        }
        else{
            System.out.println();

        }

    }

    // Case 3
    public void modifyActivity(){
        System.out.print("\tENTER THE ID: ");
        Integer id = cin.nextInt();

        System.out.println("""
                \t╔══════════════════════════════╗
                \t║            MENU              ║
                \t║       1. TITLE               ║
                \t║       2. LOCATION            ║
                \t║       3. DESCRIPTION         ║
                \t║       4. DUE DATE            ║
                \t╚══════════════════════════════╝
                      
                """
        );

        System.out.print("\tSELECT OPTION: ");
        int option = cin.nextInt();

        switch (option){
            case 1 ->{
                cin.nextLine();
                System.out.print("\tENTER THE NEW TITLE: ");
                String newTitle = cin.nextLine();
                controller.modifyActivityTitle(id,newTitle);
            }
            case 2 ->{
                cin.nextLine();
                System.out.print("\tENTER THE NEW LOCATION: ");
                String location = cin.nextLine();
                controller.modifyActivityLocation(id, location);

            }
            case 3 ->{
                cin.nextLine();
                System.out.print("\tENTER THE NEW DESCRIPTION: ");
                String description = cin.nextLine();
                controller.modifyActivityDescription(id, description);

            }
            case 4 ->{
                System.out.print("\tENTER THE NEW DUE DATE: ");
                Calendar newDate = createdate();
                controller.modifyActivityDate(id, newDate);

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

    // Case 4


    // Case 5


    // Case 6
    public void undo(){
        controller.undo();

    }


    public void showHashTable(){
        System.out.println(controller.showHashTable());

    }

    public void showArray(){
        System.out.println(controller.showArray());
    }



    // Calendar methods

    public Calendar createdate(){
        Calendar newDate =  Calendar.getInstance();

        int minYear = newDate.get(Calendar.YEAR);
        int minMonth = newDate.get(Calendar.MONTH);
        int minDay = newDate.get(Calendar.DATE);

        int year = 0;
        int month = 0;
        int day = 0;

        do{
            System.out.print("\tENTER YEAR: ");
            year = cin.nextInt();
            if(year < minYear){
                System.out.println("Enter a valid input");
            }

        }while(year < minYear);

        if (!(year == minYear)) {
            System.out.print("\tENTER MONTH (1-12): ");
            do{
                month = (cin.nextInt()) - 1;
                if(month < 0 || month > 11){
                    System.out.println("Enter a valid input ");
                }


            }while(!(month >= 0 && month <= 11));




            do{
                System.out.print("\tENTER DAY: ");
                day = cin.nextInt();
                if(day < 1 || day > 31){
                    System.out.println("Enter a valid input");
                }

            }while(!(day >= 1 && day <= 31));


        } else {
            do{
                System.out.print("\tENTER MONTH (1-12): ");
                month = (cin.nextInt()) - 1;
                if(month < minMonth || month > 11){
                    System.out.println("Enter a valid input ");
                }


            }while(!(month >= minMonth && month <= 11));



            if(minMonth == month){

                do{
                    System.out.print("\tENTER DAY: ");
                    day = cin.nextInt();
                    if(day < minDay || day > 31){
                        System.out.println("Enter a valid input");
                    }

                }while(!(day >= minDay && day <= 31));


            }else{
                do{
                    System.out.print("\tENTER DAY: ");
                    day = cin.nextInt();
                    if(day < 1 || day > 31){
                        System.out.println("Enter a valid input");
                    }

                }while(!(day >= 1 && day <= 31));



            }


        }

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

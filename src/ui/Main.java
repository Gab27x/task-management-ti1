package ui;

import model.Controller;
import java.io.IOException;
import java.time.*;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
    private final Scanner cin;
    private final Controller controller;


    public Main() {
        cin = new Scanner(System.in);
        controller = new Controller();

    }

    public static void main(String[] args) {
        int option = -1;
        Main view = new Main();

        view.controller.loadFromJson();

        do {
            try {
                view.menu();

                System.out.print("\tSELECT OPTION: ");
                option = view.cin.nextInt();

                view.executeOption(option);

            } catch (InputMismatchException e) {
                view.cin.nextLine();
                System.out.println("""
                        \t╔══════════════════════════════╗
                        \t║    PLEASE ENTER AN INTEGER   ║
                        \t╚══════════════════════════════╝
                        """);
            }

        } while (option != 0);


        view.save();

    }

    //Menu
    public void menu() {
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
    public void executeOption(int option) {
        switch (option) {
            case 0 -> {
                System.out.println("""
                        \t╔══════════════════════════════╗
                        \t║              BYE             ║
                        \t╚══════════════════════════════╝
                        """);

            }
            case 1 -> {
                System.out.println("""
                        \t╔══════════════════════════════╗
                        \t║          ADD ACTIVITY        ║
                        \t╚══════════════════════════════╝
                        """);

                addActivity();


            }
            case 2 -> {
                System.out.println("""
                        \t╔══════════════════════════════╗
                        \t║         MODIFY ACTIVITY      ║
                        \t╚══════════════════════════════╝
                        """);

                modifyActivity();
            }
            case 3 -> {
                System.out.println("""
                        \t╔══════════════════════════════╗
                        \t║        DELETE ACTIVITY       ║
                        \t╚══════════════════════════════╝
                        """);

                deleteActivity();
            }
            case 4 -> {
                System.out.println("""
                        \t╔══════════════════════════════╗
                        \t║       FILTER BY PRIORITY     ║
                        \t╚══════════════════════════════╝
                        """);
                showByPriority();
                System.out.print("\n\tENTER TO CONTINUE: ");
                cin.nextLine();
                String next = cin.nextLine();


            }
            case 5 -> {
                System.out.println("""
                        \t╔══════════════════════════════╗
                        \t║      FILTER BY DUE DATE      ║
                        \t╚══════════════════════════════╝
                        """);

                    showByDate();
                System.out.print("\n\tENTER TO CONTINUE: ");
                cin.nextLine();
                String next = cin.nextLine();

            }
            case 6 -> {
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
    public void addActivity() {
        int id;
        int priority = 0;
        String title, description, location;
        LocalDate dueDate;

        cin.nextLine();

        System.out.print("\tENTER THE TITLE: ");
        title = cin.nextLine();

        System.out.print("\tENTER THE DESCRIPTION: ");
        description = cin.nextLine();

        System.out.print("\tENTER THE LOCATION: ");
        location = cin.nextLine();

        System.out.print("\tENTER THE ID: ");
        id = cin.nextInt();

        do{

            System.out.print("""
                    
                    \tSELECT PRIORITY
                    \t1. PRIORITARY
                    \t2. NON PRIORITARY
                    """);

            System.out.print("\tENTER THE PRIORITY: ");
            priority = cin.nextInt();

        } while (priority < 1 || priority > 3);

        /*        cin.nextLine();*/

        System.out.print("\n\t\tENTER THE DUE DATE \n");

        dueDate = createdate2();

        controller.addActivity(id, title, description, dueDate, location, priority == 1);


    }

    // Case 2
    public void deleteActivity() {
        System.out.print("\tENTER THE ID: ");

        Integer id = cin.nextInt();
        if (controller.deleteActivity(id)) {
            System.out.println();

        } else {
            System.out.println();

        }

    }

    // Case 3
    public void modifyActivity() {
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

        switch (option) {
            case 1 -> {
                cin.nextLine();
                System.out.print("\tENTER THE NEW TITLE: ");
                String newTitle = cin.nextLine();
                controller.modifyActivityTitle(id, newTitle);
            }
            case 2 -> {
                cin.nextLine();
                System.out.print("\tENTER THE NEW LOCATION: ");
                String location = cin.nextLine();
                controller.modifyActivityLocation(id, location);

            }
            case 3 -> {
                cin.nextLine();
                System.out.print("\tENTER THE NEW DESCRIPTION: ");
                String description = cin.nextLine();
                controller.modifyActivityDescription(id, description);

            }
            case 4 -> {
                System.out.print("\tENTER THE NEW DUE DATE: ");
                LocalDate newDate = createdate2();
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
    public  void showByPriority(){
        System.out.println(controller.showByPriority());
    }

    // Case 5
    public  void showByDate(){
        System.out.println(controller.showByDate());
    }


    // Case 6
    public void undo() {
        controller.undo();

    }


    public void showHashTable() {
        System.out.println(controller.showHashTable());

    }

    public void showArray() {
        System.out.println(controller.showArray());
    }

    public void showArray2() {
        System.out.println(controller.showArray2());
    }



    public LocalDate createdate2() {
        LocalDate today = LocalDate.now();


        int minYear = today.getYear();
        int minMonth = today.getMonthValue();
        int minDay = today.getDayOfMonth();

        int year = 0;
        int month = 0;
        int day = 0;

        do {
            System.out.print("\n\tENTER YEAR: ");
            year = cin.nextInt();


        } while (year < minYear);

        if (year == minYear) {
            do {
                System.out.print("\n\tENTER MONTH: ");
                month = cin.nextInt();


            } while (month < minMonth);

            if(month == minMonth){
                do {
                    System.out.print("\n\tENTER DAY: ");
                    day = cin.nextInt();


                } while (day < minDay);


            }

            else {
                do {
                    System.out.print("\n\tENTER DAY: ");
                    day = cin.nextInt();


                } while ( day < 1 || day > 31 );


            }


        }
        else {
            do {
                System.out.print("\n\tENTER MONTH: ");
                month = cin.nextInt();


            } while (month < 1 || month > 12);

            do {
                System.out.print("\n\tENTER DAY: ");
                day = cin.nextInt();


            } while ( day < 1 || day > 31 );




        }


        return LocalDate.of(year, month, day);

    }


    public void save() {
        try {
            controller.saveToJson();
        }catch(
                IOException e)

        {
            e.printStackTrace();

        }

    }


}
package model;

import java.util.Calendar;

public class Controller {
    private HashTable<Integer, Activity> activities;
    private Stack<Action> actionsStack;

    private Queue<Activity> activitiesQueue;




    public Controller(){
        activities = new HashTable<Integer, Activity>();
        actionsStack = new Stack<Action>();
        activitiesQueue = new Queue<Activity>();

    }



    // Case 1
    public void addActivity(String id, String description, Calendar dueDate, String location){

    }
    // Case 2
    public void deleteActivity(String id){

    }

    // Case 3
    public void modifyActivityLocation(String id, String newLocation){

    }
    public void modifyActivityDescription(String id, String newDescription){

    }
    public void modifyActivityDate(String id, Calendar newDueDate){

    }


    // Case 4
    public String showActivities(){
        return activitiesQueue.showQueue();

    }
    // Case 5
    public void undo(){


    }
}
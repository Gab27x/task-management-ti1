package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


public class Controller {
    private HashTable<Integer, Activity> activities;
    private Stack<Action> actionsStack;

    private Queue<Activity> activitiesQueue;
    private Heap<Activity> activitiesHeap;


    public Controller(){
        activities = new HashTable<Integer, Activity>();
        actionsStack = new Stack<Action>();
        activitiesQueue = new Queue<Activity>();

    }
    public void saveToJson() throws IOException {
        FileManager<?> fileManager = FileManager.getInstance();
        ArrayList<HashEntry> arr = new ArrayList<HashEntry>(Arrays.asList(activities.getElementsAsArray2()));
        fileManager.saveToJson(arr);

    }

    public void loadFromJson(){
        FileManager<?> fileManager = FileManager.getInstance();


    }


    // Case 1
    public void addActivity(Integer id,String title ,String description, LocalDate dueDate, String location,int type){
        //FIXME complete method in  main
        Activity newActivity=new Activity(id,title,description,dueDate,location);//created this activity
        if(type==1)
            newActivity.setPriority(true);
        else
            newActivity.setPriority(false);
        actionsStack.push(new Action(newActivity,1));//created an action and added it to the stack

        activities.add(id,newActivity);


    }

    // Case 2
    public boolean deleteActivity(Integer id){
        Activity deleted = activities.findValue(id);
        if(deleted != null){
            actionsStack.push(new Action(deleted,3));
            activities.delete(id,deleted);
            return true;
        }
        else{
            return false;
        }

    }

    // Case 3

    // Modify 1
    public void modifyActivityTitle(Integer id, String newTitle){
        //FIXME CREAR ACTION Y HACER EL PUSH AL STACK

        Activity modified = activities.findValue(id);
        if(modified!=null){

            modified.setTitle(newTitle);
        }

    }


    // Modify 2
    public void modifyActivityLocation(Integer id, String newLocation){
        //FIXME CREAR ACTION Y HACER EL PUSH AL STACK

        Activity modified = activities.findValue(id);
        if(modified!=null){

            modified.setLocation(newLocation);
        }

    }


    // Modify 3
    public void modifyActivityDescription(Integer id, String newDescription){
        //FIXME CREAR ACTION Y HACER EL PUSH AL STACK

        Activity modified = activities.findValue(id);
        if(modified!=null){

            modified.setDescription(newDescription);
        }

    }


    // Modify 4
    public void modifyActivityDate(Integer id, LocalDate newDueDate){
        //FIXME CREAR ACTION Y HACER EL PUSH AL STACK

        Activity modified = activities.findValue(id);
        if(modified!=null){

            modified.setDueDate(newDueDate);
        }


    }

    public Activity[] listActivities() {
        HashEntry<Integer, Activity>[] activitiesArray = activities.getElementsAsArray2();
        Activity[] found = new Activity[activitiesArray.length];
        int i = 0;
        for (HashEntry<Integer, Activity> actividad : activitiesArray) {
            Activity content = actividad.getValue();
            if (content.getPriority()) {
                found[i] = content;
                i++;
            }

        }
        return found;
    }

    public String showPriority() {
        Activity[] found = listActivities();
        String msg = "";
        for (Activity activity : found) {
            if (activity != null) {
                msg += "\n" + activity.toString();
            }
        }
        return msg;
    }

    public String showByDate(){
        activitiesHeap = new Heap<Activity>(listActivities());
        activitiesHeap.designMaxHeap();
        return activitiesHeap.displayHeap();
    }

    // Case 4
    public String showActivities(){
        return activitiesQueue.showQueue();

    }
    // Case 5
    public void undo(){//FIXME cambiar este metodo a String o boolean para saber si la ultima actividad fue nula o no
        //FIXME necesito trabajar con los encargados de los metodos delete, modify y add para construir este metodo bien
        Action lastAction=actionsStack.pop();
        if(lastAction!=null){
            Activity activity=lastAction.getActivity();
            switch(lastAction.getType()){
                case ADD:
                    deleteActivity(activity.getId());
                    break;
                case MODIFY:
                    modifyActivityLocation(activity.getId(),activity.getLocation());
                    modifyActivityDescription(activity.getId(),activity.getDescription());
                    modifyActivityDate(activity.getId(),activity.getDueDate());
                    break;
                case DELETE:
                    addActivity(activity.getId(),activity.getTitle(),activity.getDescription(),activity.getDueDate(),activity.getLocation());
                    break;
            }
        }

    }
    public String showArray(){
        return activities.showArray2();
    }
    public String showArray2(){
        return activities.showArray2();
    }

    public String showHashTable(){
        return activities.showTable();
    }


    public HashTable<Integer, Activity> getActivities() {
        return activities;
    }

    public void setActivities(HashTable<Integer, Activity> activities) {
        this.activities = activities;
    }

    public Stack<Action> getActionsStack() {
        return actionsStack;
    }

    public void setActionsStack(Stack<Action> actionsStack) {
        this.actionsStack = actionsStack;
    }

    public Queue<Activity> getActivitiesQueue() {
        return activitiesQueue;
    }

    public void setActivitiesQueue(Queue<Activity> activitiesQueue) {
        this.activitiesQueue = activitiesQueue;
    }
}
package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private HashTable<Integer, Activity> activities;
    private Stack<Action> actionsStack;

    private Queue<Activity> activitiesQueue;

    private MaxHeap<Activity> priorityActivities;


    public Controller(){
        activities = new HashTable<Integer, Activity>();
        actionsStack = new Stack<Action>();
        activitiesQueue = new Queue<Activity>();
        priorityActivities = new MaxHeap<Activity>();

    }
    public void saveToJson() throws IOException {
        FileManager<?> fileManager = FileManager.getInstance();


        ArrayList<Activity> arr = priorityActivities.getHeap();

        ArrayList<Activity> arr2 = activitiesQueue.getQueueContent();

        ArrayList<Activity> saveAct = new ArrayList<>();
        saveAct.addAll(arr);
        saveAct.addAll(arr2);

        fileManager.saveToJson(saveAct);
    }

    public void loadFromJson(){

        FileManager<?> fileManager = FileManager.getInstance();
        try {
            ArrayList<Activity> loadAct = fileManager.loadFromJson(Activity.class);
            if(loadAct != null){
                for (Activity activity: loadAct) {
                    addActivity(activity.getId(),activity);
                }

            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


    // Case 1
    public void addActivity(Integer id,String title ,String description, LocalDate dueDate, String location, boolean priority){

        Activity newActivity = new Activity(id,title,description,dueDate,location,priority);//created this activity

        actionsStack.push(new Action(newActivity,1));//created an action and added it to the stack

        activities.add(id,newActivity);

        if(priority)
            priorityActivities.insert(newActivity);
        else
            activitiesQueue.add(newActivity);

    }

    public void addActivity(Integer key,Activity activity){
        //FIXME complete method in  main

        actionsStack.push(new Action(activity,1));//created an action and added it to the stack

        activities.add(key,activity);

        if(activity.getPriority()){
            priorityActivities.insert(activity);
        }else{
            activitiesQueue.add(activity);
        }


    }

    // Case 3
    public boolean deleteActivity(Integer id){
        Activity deleted = activities.findValue(id);
        if(deleted != null){
            boolean priority= deleted.getPriority();
            if(priority && !priorityActivities.isEmpty()) {
                if(priorityActivities.peekMax().getId().equals(id)){
                    priorityActivities.extractMax();
                    actionsStack.push(new Action(deleted,3));
                    activities.delete(id,deleted);
                    return true;
                }else{
                    return false;
                }
            }else if(!priority && !activitiesQueue.isEmpty()){
                if(activitiesQueue.peek().getId().equals(id)){
                    activitiesQueue.poll();
                    actionsStack.push(new Action(deleted,3));
                    activities.delete(id,deleted);
                    return true;
                }else{
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return false;

    }
    // Case 2

    public boolean ableToModify(Integer id){
        Activity modified = activities.findValue(id);
        if(modified!=null) {
            boolean priority = modified.getPriority();
            if (priority && !priorityActivities.isEmpty()) {
                if (priorityActivities.peekMax().getId().equals(id)) {
                    return true;
                } else {
                    return false;
                }
            }else if(!priority && !activitiesQueue.isEmpty()){
                if(activitiesQueue.peek().getId().equals(id)){
                    return true;
                }else{
                    return false;
                }

            }

            } else {
                return false;
            }

            return false;
        }



    // Modify 1
    public void modifyActivityTitle(Integer id, String newTitle){
        //FIXME CAMBIAR METODO A BOOLEAN PARA DECIRLE AL USER SI SE PUDO MODIFICAR O NO

        Activity modified = activities.findValue(id);


        boolean able = ableToModify(id);

        if(modified != null && able){
            Activity toSave = new Activity(modified.getId(),modified.getTitle(),modified.getDescription()
                    ,modified.getDueDate(),modified.getLocation(),modified.getPriority());

            if(modified.getPriority()){

                priorityActivities.peekMax().setTitle(newTitle);
                actionsStack.push(new Action(toSave,2));

            }else{

                activitiesQueue.peek().setTitle(newTitle);
            }
        }

    }


    // Modify 2
    public void modifyActivityLocation(Integer id, String newLocation){
        //FIXME CAMBIAR METODO A BOOLEAN PARA DECIRLE AL USER SI SE PUDO MODIFICAR O NO

        Activity modified = activities.findValue(id);
        boolean able=ableToModify(id);
        if(modified!=null && able){
            Activity toSave = new Activity(modified.getId(),modified.getTitle(),modified.getDescription()
                    ,modified.getDueDate(),modified.getLocation(),modified.getPriority());

            if(modified.getPriority()) {
                priorityActivities.peekMax().setLocation(newLocation);
                actionsStack.push(new Action(toSave,2));

            }else{
                activitiesQueue.peek().setLocation(newLocation);
            }
        }

    }


    // Modify 3
    public void modifyActivityDescription(Integer id, String newDescription){
        //FIXME CAMBIAR METODO A BOOLEAN PARA DECIRLE AL USER SI SE PUDO MODIFICAR O NO

        Activity modified = activities.findValue(id);
        boolean able = ableToModify(id);
        if(modified!=null && able){

            Activity toSave = new Activity(modified.getId(),modified.getTitle(),modified.getDescription()
                    ,modified.getDueDate(),modified.getLocation(),modified.getPriority());


            if(modified.getPriority()) {
                priorityActivities.peekMax().setDescription(newDescription);
                actionsStack.push(new Action(toSave,2));
            }else{
                activitiesQueue.peek().setDescription(newDescription);
            }
        }


    }


    // Modify 4
    public void modifyActivityDate(Integer id, LocalDate newDueDate){
        //FIXME CAMBIAR METODO A BOOLEAN PARA DECIRLE AL USER SI SE PUDO MODIFICAR O NO

        Activity modified = activities.findValue(id);
        boolean able=ableToModify(id);
        if(modified!=null && able){
            Activity toSave = new Activity(modified.getId(),modified.getTitle(),modified.getDescription()
                    ,modified.getDueDate(),modified.getLocation(),modified.getPriority());

            if(modified.getPriority()) {
                priorityActivities.peekMax().setDueDate(newDueDate);
                actionsStack.push(new Action(toSave,2));
            }else{
                activitiesQueue.peek().setDueDate(newDueDate);
            }
        }


    }


    public ArrayList<Activity> listActivities() {
        HashEntry<Integer, Activity>[] activitiesArray = activities.getElementsAsArray2();

        ArrayList<Activity> found = new ArrayList<>();

        for (HashEntry<Integer, Activity> actividad : activitiesArray) {
            Activity content = actividad.getValue();
            if (content.getPriority()) {
                found.add(content);

            }

        }
        return found;
    }

    /**
     * Returns a string with all the task sorted by date
     * @return msg with all the activities sorted by date (only the priority ones, the non-priority ones are shown as they come)
     */


    public String showByDate(){
        StringBuilder msg= new StringBuilder();


        for(Activity actual: priorityActivities.getHeap()){
            msg.append("\n\t").append(actual.toString());
        }

        return msg.toString();
    }
    /**
     * Returns a string with all the task sorted by priority
     * @return msg with all the activities sorted by priority (the prioriy ones first, then the non priority ones)
     */
    public String showByPriority(){
        StringBuilder msg= new StringBuilder();

        ArrayList<Activity> prioritarias = listActivities();

        for(Activity actual: prioritarias){
            msg.append("\n\t").append(actual.toString());
        }
        msg.append("\n\t").append(activitiesQueue.showQueue());
        return msg.toString();
    }

    // Case 5
    public void undo(){//FIXME cambiar este metodo a String o boolean para saber si la ultima actividad fue nula o no
        Action lastAction = actionsStack.pop();
        if(lastAction != null){
            Activity activity = lastAction.getActivity();
            switch(lastAction.getType()){
                case ADD:
                    deleteActivity(activity.getId());
                    break;
                case MODIFY:
                    modifyActivityTitle(activity.getId(),activity.getTitle());
                    modifyActivityLocation(activity.getId(),activity.getLocation());
                    modifyActivityDescription(activity.getId(),activity.getDescription());
                    modifyActivityDate(activity.getId(),activity.getDueDate());
                    break;
                case DELETE:
                    addActivity(activity.getId(), activity.getTitle(), activity.getDescription(),
                            activity.getDueDate(), activity.getLocation(), activity.getPriority());
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
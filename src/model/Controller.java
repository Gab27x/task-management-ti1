package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


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
        ArrayList<HashEntry> arr = new ArrayList<HashEntry>(Arrays.asList(activities.getElementsAsArray2()));
        fileManager.saveToJson(arr);

    }

    public void loadFromJson(){
        FileManager<?> fileManager = FileManager.getInstance();


    }


    // Case 1
    public void addActivity(Integer id,String title ,String description, LocalDate dueDate, String location, boolean priority){
        //FIXME complete method in  main
        Activity newActivity=new Activity(id,title,description,dueDate,location,priority);//created this activity

        actionsStack.push(new Action(newActivity,1));//created an action and added it to the stack

        activities.add(id,newActivity);

        if(priority){
            priorityActivities.insert(newActivity);
        }else{
            activitiesQueue.add(newActivity);
        }


    }

    // Case 2
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


    // Case 3

    // Modify 1
    public void modifyActivityTitle(Integer id, String newTitle){
        //FIXME CAMBIAR METODO A BOOLEAN PARA DECIRLE AL USER SI SE PUDO MODIFICAR O NO

        Activity modified = activities.findValue(id);
        boolean able=ableToModify(id);
        if(modified!=null && able){
            modified.setTitle(newTitle);
            if(modified.getPriority()){
                priorityActivities.peekMax().setTitle(newTitle);
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
            modified.setLocation(newLocation);
            if(modified.getPriority()) {
                priorityActivities.peekMax().setLocation(newLocation);
            }else{
                activitiesQueue.peek().setLocation(newLocation);
            }
        }

    }


    // Modify 3
    public void modifyActivityDescription(Integer id, String newDescription){
        //FIXME CAMBIAR METODO A BOOLEAN PARA DECIRLE AL USER SI SE PUDO MODIFICAR O NO

        Activity modified = activities.findValue(id);
        boolean able=ableToModify(id);
        if(modified!=null && able){
            modified.setDescription(newDescription);
            if(modified.getPriority()) {
                priorityActivities.peekMax().setDescription(newDescription);
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
            modified.setDueDate(newDueDate);
            if(modified.getPriority()) {
                priorityActivities.peekMax().setDueDate(newDueDate);
            }else{
                activitiesQueue.peek().setDueDate(newDueDate);
            }
        }


    }

    public ArrayList<Activity> listActivities() {
        HashEntry<Integer, Activity>[] activitiesArray = activities.getElementsAsArray2();
        ArrayList<Activity> found = new ArrayList<>();
        int i = 0;
        for (HashEntry<Integer, Activity> actividad : activitiesArray) {
            Activity content = actividad.getValue();
            if (content.getPriority()) {
                found.add(content);
                i++;
            }

        }
        return found;
    }

    /**
     * Returns a string with all the task sorted by date
     * @return msg with all the activities sorted by date (only the priority ones, the non-priority ones are shown as they come)
     */
    public String showByDate(){
        MaxHeap<Activity> heap=new MaxHeap<>();
        Activity[] priority=heap.getSortedArray(Activity.class);
        String msg="";
        for(Activity actual: priority){
            msg+="\n"+actual.toString();
        }
        msg+="\n"+activitiesQueue.showQueue();
        return msg;
    }

    /**
     * Returns a string with all the task sorted by priority
     * @return msg with all the activities sorted by priority (the prioriy ones first, then the non priority ones)
     */
    public String showByPriority(){
        String msg="";
        ArrayList<Activity> prioritarias=listActivities();
        for(Activity actual: prioritarias){
            msg+="\n"+actual.toString();
        }
        msg+="\n"+activitiesQueue.showQueue();
        return msg;
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
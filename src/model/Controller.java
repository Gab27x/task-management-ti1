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

        //FIXME hay que meter esa actividad creada a la estructura correspondiente
        Activity created=new Activity(id,description,dueDate,location);//created this activity
        actionsStack.push(new Action(created,1));//created an action and added it to the stack
        Integer key= Integer.parseInt(id);
        activities.add(key,created);
    }
    // Case 2
    public void deleteActivity(String id){
        //FIXME antes de eliminar al actividad, necesitan crear una action con esa actividad
        //y meterla al stack
        int key= Integer.parseInt(id);
        activities.delete(key,activities.findValue(key));
    }

    // Case 3
    public void modifyActivityLocation(String id, String newLocation){
        //FIXME antes de modificar la actividad, necesitan crear una actividad con los mismos atributos
        //, crear con eso un action y meterla al stack
        int key= Integer.parseInt(id);
        activities.findValue(key).setLocation(newLocation);



    }
    public void modifyActivityDescription(String id, String newDescription){
        //FIXME antes de modificar la actividad, necesitan crear una actividad con los mismos atributos
        //, crear con eso un action y meterla al stack
        int key= Integer.parseInt(id);
        activities.findValue(key).setDescription(newDescription);
    }
    public void modifyActivityDate(String id, Calendar newDueDate){
        //FIXME antes de modificar la actividad, necesitan crear una actividad con los mismos atributos
        //, crear con eso un action y meterla al stack
        int key= Integer.parseInt(id);
        activities.findValue(key).setDueDate(newDueDate);
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
                    addActivity(activity.getId(),activity.getDescription(),activity.getDueDate(),activity.getLocation());
                    break;
            }
        }

    }
}
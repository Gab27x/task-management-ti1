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
    public void addActivity(Integer id,String title ,String description, Calendar dueDate, String location){

        //FIXME hay que meter esa actividad creada a la estructura correspondiente
        Activity created=new Activity(id,title,description,dueDate,location);//created this activity
        actionsStack.push(new Action(created,1));//created an action and added it to the stack
        //Integer key= Integer.parseInt(id);
        activities.add(id,created);
    }
    // Case 2
    public void deleteActivity(Integer id){
        //FIXME antes de eliminar al actividad, necesitan crear una action con esa actividad.
        //y meterla al stack
       // int key= Integer.parseInt(id);
        Activity deleted=activities.findValue(id);
        if(deleted!=null){
            actionsStack.push(new Action(deleted,3));
            activities.delete(id,activities.findValue(id));
        }

    }

    // Case 3
    public void modifyActivityLocation(Integer id, String newLocation){
        //FIXME antes de modificar la actividad, necesitan crear una actividad con los mismos atributos
        //, crear con eso un action y meterla al stack
        //int key= Integer.parseInt(id);
        Activity modified=activities.findValue(id);
        if(modified!=null){
            actionsStack.push(new Action(modified,2));
            activities.findValue(id).setLocation(newLocation);
        }



    }
    public void modifyActivityDescription(Integer id, String newDescription){
        //FIXME antes de modificar la actividad, necesitan crear una actividad con los mismos atributos
        //, crear con eso un action y meterla al stack
        //int key= Integer.parseInt(id);
        Activity modified=activities.findValue(id);
        if(modified!=null){
            Action last=new Action(modified,2);
            actionsStack.push(new Action(modified,2));
            activities.findValue(id).setDescription(newDescription);
        }

    }
    public void modifyActivityDate(Integer id, Calendar newDueDate){
        //FIXME antes de modificar la actividad, necesitan crear una actividad con los mismos atributos
        //, crear con eso un action y meterla al stack
        //int key= Integer.parseInt(id);
        Activity modified=activities.findValue(id);
        if(modified!=null){
            Action last=new Action(modified,2);
            actionsStack.push(new Action(modified,2));
            activities.findValue(id).setDueDate(newDueDate);
        }


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


    public String showHashTable(){
        return activities.toString();
    }
}
package mx.edu.j2se.Tapia.tasks;
import java.util.Arrays;
import java.util.LinkedList;

public class LinkedTaskList {

    //Create a new Linked list
    static LinkedList<Task> Tasks = new LinkedList<>(); // LinkedList<Type of data that is going to contain String,int,objects>



    //Add a Task to the list
    public static void add(Task task){
        Tasks.add(task);
    }


    //Return the lenght of the list
    public int getSize(){
        return Tasks.size();
    }

    //Return the Task requested
    public static Task getTask(int index){
        try{
            return Tasks.get(index - 1);
        }catch(IndexOutOfBoundsException i){
            System.out.println("Excede el tamaño de la lista");
            return null;
        }

    }

    //Remove the Task indicated and returns true if it was successful
    public boolean remove(Task task){
        return Tasks.remove(task);
    }


    //Look fo the Task that are executed in certain period of time
    public LinkedList<Task> incoming(int from, int to){
        LinkedList<Task> Tasks2 = new LinkedList<>();

        for (Task task : Tasks) {

            int start_int = task.getStartTime() + task.getInterval();
            int start = task.getStartTime();
            int end = task.getEndTime();

            if ((from <= start_int) && (start_int <= to) || ((from <= start) && (end <= to))) {

                Tasks2.add(task);
                System.out.println("Task incoming");
            }

        }
        return Tasks2;

    }




}

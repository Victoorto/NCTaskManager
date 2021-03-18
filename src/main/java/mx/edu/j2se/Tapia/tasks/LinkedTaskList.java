package mx.edu.j2se.Tapia.tasks;


import java.util.ArrayList;
import java.util.List;

//import java.util.LinkedList;
public class LinkedTaskList {


    //Create a new Linked list
    //static LinkedList<Task> Tasks = new LinkedList<>(); // LinkedList<Type of data that is going to contain String,int,objects>
    static Node head;

    //constructor for the next node to add to the linked list
    static class Node extends LinkedTaskList {
        Task data;
        Node next;

        Node(Task d){
            data = d;
            next = null;
        }
    }

    //Add a Task to the linked list
    public static void add(LinkedTaskList list, Task data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }

    }


    //Return the length of the Linked list
    public static int getSize(){
        Node temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        return size;
        }

    //Return the Task requested
    public static Task getTask(int index){
        Node temp = head;
        int size = 0;
        while(temp != null){
            if(size == index - 1){
                return temp.data;
            }
            size++;
            temp = temp.next;
        }
        System.out.println("Excede el tamaño de la lista");
        return null;
    }

    //Remove the Task indicated and returns true if it was successful
    public static boolean remove(Task task){
        Node temp = head;
        Node prev = null;
        while(temp != null && temp.data != task){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            return false;
        }
        prev.next = temp.next;
        return true;

    }


    //Look for the Task that are executed in certain period of time
    public static List incoming(int from, int to){

        Node temp = head;
        Node prev = null;
        List<Task> list2 = new ArrayList<>();
        //LinkedTaskList list2 = new LinkedTaskList();
        while(temp != null){

            int start_int = temp.data.getStartTime() + temp.data.getInterval();
            int start = temp.data.getStartTime();
            int end = temp.data.getEndTime();

            if ((from <= start_int) && (start_int <= to) || ((from <= start) && (end <= to))) {

                list2.add(temp.data);
                System.out.println("Task incoming");
            }


            prev = temp;
            temp = temp.next;
        }

        return list2;


       /* for (Task task : Tasks) {

            int start_int = task.getStartTime() + task.getInterval();
            int start = task.getStartTime();
            int end = task.getEndTime();

            if ((from <= start_int) && (start_int <= to) || ((from <= start) && (end <= to))) {

                Tasks2.add(task);
                System.out.println("Task incoming");
            }

        }
        return Tasks2;*/

    }




}

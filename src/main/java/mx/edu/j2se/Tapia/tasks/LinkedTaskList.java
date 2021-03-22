package mx.edu.j2se.Tapia.tasks;


//import java.util.LinkedList;
public class LinkedTaskList extends AbstractTaskList {

    Node head;

    class Node {
        Task data;
        Node next;

        Node(Task d){
            data = d;
            next = null;
        }
    }

    public void add(Task data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (head == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
            System.out.println("Task added");
        }

    }

    public int getSize(){
        Node temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        return size;
    }

    public Task getTask(int index){
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

    public boolean remove(Task task){
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

    public AbstractTaskList  incoming(int from, int to) {

        Node temp = head;
        Node prev = null;
        //List<Task> list2 = new ArrayList<>();
        LinkedTaskList list2 = new LinkedTaskList();
        while (temp != null) {

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
    }



}
package mx.edu.j2se.Tapia.tasks;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

//import java.util.LinkedList; remove the abstract
public  class LinkedTaskList extends AbstractTaskList {


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
        Node temp = head, prev = null;
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

    @Override
    public Iterator<Task> iterator(){
        return new Iterator<Task>() {

            Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public Task next() {
                if(hasNext()){
                    Task data = temp.data;
                    temp = temp.next;
                    return data;
                }
                return null;
            }
        };
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Task next() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedTaskList)) return false;
        LinkedTaskList that = (LinkedTaskList) o;
        return Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    public String toString(){

        Node temp = head;
        String info = "";
        int i = 0;

        while(temp != null){
            if(!(temp.data.isRepeated())){
                String Title = temp.data.getTitle();
                LocalDateTime time = temp.data.getTime();
                boolean active = temp.data.isActive();

                info += String.format("\n Title:%s , Time:%d, Active: %b ", Title, time, active);

            }else{
                String Title = temp.data.getTitle();
                LocalDateTime startTime = temp.data.getStartTime();
                LocalDateTime endTime = temp.data.getEndTime();
                boolean active = temp.data.isActive();

                info += String.format("\n Title:%s , Start Time:%d, End Time=%d Active: %b ", Title, startTime, endTime, active);

            }


          temp = temp.next;

        }
        return info;
    }

    public void copyTask(int i){

           Task task = this.getTask(i);
           this.add(task);

    }

    public AbstractTaskList copyList(){

        LinkedTaskList copy = new LinkedTaskList();
        Node ori = this.head;

        while(ori != null){
            copy.add(ori.data);
            ori = ori.next;
        }
        return copy;
    }

    @Override
    public Stream<Task> getStream() {

        Stream.Builder<Task> streamTask = Stream.builder();
        Node ori = this.head;

        while(ori != null){
            streamTask.accept(ori.data);
            ori = ori.next;
        }

        Stream<Task> streamTask2 = streamTask.build();


        return streamTask2;
    }



}
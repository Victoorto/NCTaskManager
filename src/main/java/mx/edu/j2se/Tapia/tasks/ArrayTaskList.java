package mx.edu.j2se.Tapia.tasks;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public  class ArrayTaskList extends AbstractTaskList {

    Task[] arrayTasks = new Task[0];
    Task[] arrayTasksNext = new Task[0];
    boolean elim;

    public void add(Task task){
        Task[] arrayTask1 = new Task[1];
        arrayTask1[0] = task;

        arrayTasks = Arrays.copyOf(arrayTasks, arrayTasks.length +1);
        arrayTasks[arrayTasks.length -1]  = arrayTask1[0];
        System.out.println("Task added");

    }

    public int getSize(){
        return arrayTasks.length;
    }

    public  Task getTask(int index){
        try{
            return arrayTasks[index - 1];
        }catch(IndexOutOfBoundsException i){
            System.out.println("Excede el tamaño de la lista");
            return null;
        }

    }

    public boolean remove(Task task){

        Task arrayTask1[]=new Task[1];
        arrayTask1[0]= task;
        int index = 0;

        for(int i=0;i<arrayTasks.length;i++){
            if(arrayTask1[0] == arrayTasks[i]){
                elim = true;
                index = i;
                break;
            }
        }

        Task arrayTask3 [] = new Task[arrayTasks.length -1];


        for (int j=0, f = 0; j<arrayTasks.length;j++){

            if(j == index){
                continue;
            }
            arrayTask3[f++] = arrayTasks[j];

        }

        arrayTasks = Arrays.copyOf(arrayTask3, arrayTask3.length);


        return elim;
    }

    @Override
    public Iterator<Task> iterator(){
        return new Iterator<Task>() {

            int i = 0;

            @Override
            public boolean hasNext() {
                return arrayTasks.length > i;
            }

            @Override
            public Task next() {
                Task task = arrayTasks[i++];
               return task;
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


    public String toString(){
        String info = "";

        for(Task task : arrayTasks){
            if(!(task.isRepeated())){
                String Title = task.getTitle();
                LocalDateTime time = task.getTime();
                boolean active = task.isActive();

                info += String.format("\n Title:%s , Time:%d, Active: %b ", Title, time, active);

            }else{
                String Title = task.getTitle();
                LocalDateTime startTime = task.getStartTime();
                LocalDateTime endTime = task.getEndTime();
                boolean active = task.isActive();

                info += String.format("\n Title:%s , Start Time:%d, End Time=%d Active: %b ", Title, startTime, endTime, active);

            }

        }


        return info;
    }

    public void copyTask(int i){
        Task task = this.getTask(i);
        this.add(task);

    }

    public AbstractTaskList copyList(){

        ArrayTaskList copy = new ArrayTaskList();

        for(Task task: arrayTasks){
            copy.add(task);
        }

        return copy;
    }

    @Override
    public Stream<Task> getStream() {

        Stream.Builder<Task> streamTask = Stream.builder();

        for(Task task: arrayTasks){
            streamTask.accept(task);
        }

        Stream<Task> streamTask2 = streamTask.build();


        return streamTask2;
    }

}
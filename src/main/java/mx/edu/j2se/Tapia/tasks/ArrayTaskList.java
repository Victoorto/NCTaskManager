package mx.edu.j2se.Tapia.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

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
    public AbstractTaskList incoming(int from, int to){

        ArrayTaskList coming = new ArrayTaskList();

        for(int i =0;i< arrayTasks.length;i++){

            int start_int = arrayTasks[i].getStartTime() + arrayTasks[i].getInterval();
            int start =arrayTasks[i].getStartTime();
            int end = arrayTasks[i].getEndTime();

            if((from<=start)&&(start<=to)||(from <= start_int)&&(start_int <=to)||((from <= start) && (end<= to))){

                coming.add(arrayTasks[i]);
                System.out.println("Task incoming");
            }

        }


        return coming;
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
                int time = task.getTime();
                boolean active = task.isActive();

                info += String.format("\n Title:%s , Time:%d, Active: %b ", Title, time, active);

            }else{
                String Title = task.getTitle();
                int startTime = task.getStartTime();
                int endTime = task.getEndTime();
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

    public Task[] copyList(){
        Task[] arrayTasks2 = new Task[0];
        arrayTasks2 = Arrays.copyOf(arrayTasks, arrayTasks.length);
        return arrayTasks2;
    }


}
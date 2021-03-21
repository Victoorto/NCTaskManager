package mx.edu.j2se.Tapia.tasks;

import java.util.Arrays;

public class ArrayTaskList extends AbstractTaskList {

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





}
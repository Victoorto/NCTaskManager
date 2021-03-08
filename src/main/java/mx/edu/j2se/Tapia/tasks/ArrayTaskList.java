package mx.edu.j2se.Tapia.tasks;

import java.util.Arrays;

public class ArrayTaskList {

    static Task[] arrayTask = new Task[0]; //Inicia en 0 por que no hay ninguna Task por el momento
    static boolean elim;
    static Task[] arrayTaskNext = new Task[0];

    //Agrega una task al Array haciendo una copia de este agregando un espacio y la nueva tarea
    public static void add(Task task){

        Task arrayTask1[]=new Task[1];
        arrayTask1[0]= task;

        arrayTask = Arrays.copyOf(arrayTask, arrayTask.length + 1);
        arrayTask[arrayTask.length - 1] = arrayTask1[0];
        System.out.println("Task add");
    }
    //Regresa el numero de tareas en el Array
    public static int getSize(){
        return arrayTask.length;
    }

    //Regresa la tarea en el lugar indicado
    public static Task getTask(int index){
        try{
            return arrayTask[index - 1];
        }catch(IndexOutOfBoundsException i){
            System.out.println("Excede el tamaño de la lista");
            return null;
        }

    }
    //Remove the Task indicated and returns true if it was successful
    public static boolean remove(Task task){

        Task arrayTask1[]=new Task[1];
        arrayTask1[0]= task;
        int index = 0;

        for(int i=0;i<arrayTask.length;i++){
            if(arrayTask1[0] == arrayTask[i]){
                elim = true;
                index = i;
                break;
            }
        }

        Task arrayTask3 [] = new Task[arrayTask.length -1];


        for (int j=0, f = 0; j<arrayTask.length;j++){

            if(j == index){
                continue;
            }
            arrayTask3[f++] = arrayTask[j];

        }

        arrayTask = Arrays.copyOf(arrayTask3, arrayTask3.length);


        return elim;
    }

    //Look fo the Task that are executed in certain period of time
    public static Task[] incoming(int from, int to){

        for(int i =0;i< arrayTask.length;i++){

            int start_int = arrayTask[i].getStartTime() + arrayTask[i].getInterval();
            int start =arrayTask[i].getStartTime();
            int end = arrayTask[i].getEndTime();

            if((from <= start_int)&&(start_int <=to)||((from <= start) && (end<= to))){

                Task arrayTask1[]=new Task[1];
                arrayTask1[0]= arrayTask[i];

                arrayTaskNext = Arrays.copyOf(arrayTaskNext, arrayTaskNext.length + 1);
                arrayTaskNext[arrayTaskNext.length - 1] = arrayTask1[0];
                System.out.println("Task incoming");
            }

        }


        return arrayTaskNext;
    }

}

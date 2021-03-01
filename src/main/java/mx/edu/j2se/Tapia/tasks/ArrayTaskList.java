package mx.edu.j2se.Tapia.tasks;

import java.util.Arrays;

public class ArrayTaskList {

    static Task arrayTask[] = new Task[0]; //Inicia en 0 por que no hay ninguna Task por el momento
    static boolean elim;

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
        return arrayTask[index - 1];
    }
   /*
    public static Object getTask(int index){
        Object tarea = index > arrayTask.length ? "No hay una tarea en ese lugar ": arrayTask[index];
        return tarea;
    }
    */

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

}

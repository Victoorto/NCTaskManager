package mx.edu.j2se.Tapia.tasks;


import java.util.Iterator;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterator<Task> {

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int getSize();

    public abstract Task getTask(int index);

    public abstract void copyTask(int i);

    public abstract AbstractTaskList copyList();

    public abstract Stream<Task> getStream();

    public Iterator<Task> iterator() {
        return new Iterator<Task>() {


            @Override
            public boolean hasNext() {
                return false;
            }
            @Override
            public Task next() {
                return null;
            }

        };
    }

    public Stream<Task> incoming(int from, int to){

        //Implement better logic

        /*
           inicio
           fin
           intervalo
           Intervalos-______________-______________-______________-______________-
               Inicio-------------------------------------------------------------Fin
                                     Desde-------------------------Hasta

           si inicio = Desde  entra *
           si fin = Hasta     entra  *
           Si desde < inicio + intervalo(n) < Hasta entra (Donde n va desde 0 hasta el numero de intervalo)
           desde
           hasta
           .forEach(element -> int n = (element.getStartTime - element.getEndTime)/element.getInterval())
           .filter(((from<=element.getStartTime())&&(element.getStartTime()<to)||((from < element.getEndTime()) && (element.getEndTime()<= to)))  )
         */
        return  getStream().filter(element -> ((from<=element.getStartTime())&&(element.getStartTime()<=to)||(from <= (element.getStartTime() + element.getInterval()))&&((element.getStartTime() + element.getInterval()) <=to)||((from <= element.getEndTime()) && (element.getEndTime()<= to))));

    }



}

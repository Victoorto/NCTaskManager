package mx.edu.j2se.Tapia.tasks;


import java.util.Iterator;

public abstract class AbstractTaskList implements Iterator<Task> {

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int getSize();

    public abstract Task getTask(int index);

    public abstract AbstractTaskList incoming(int from, int to);

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

}

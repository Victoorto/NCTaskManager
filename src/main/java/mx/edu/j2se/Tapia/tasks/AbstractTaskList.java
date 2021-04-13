package mx.edu.j2se.Tapia.tasks;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public Stream<Task> incoming(String from, String to){


        return getStream().filter(element -> {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime from1 = LocalDateTime.parse(from, formatter);
            LocalDateTime to1 = LocalDateTime.parse(to, formatter);
            LocalDateTime start = element.getStartTime();
            LocalDateTime end = element.getEndTime();


            if(element.interDays == 0 && element.interDays ==0 && element.interMinute == 0){
                if(start.isAfter(from1) && start.isBefore(to1)){
                    return true;
                }else{
                    return false;}
            }else{

            while(start.isBefore(end)){

                start = start.plusDays(element.interDays);
                start = start.plusHours(element.interHours);
                start = start.plusMinutes(element.interMinute);

                if(start.isAfter(from1) && start.isBefore(to1)){
                    return true;
                }


            }

            return false;
        }});

    }



}

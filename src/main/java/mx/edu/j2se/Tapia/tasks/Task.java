package mx.edu.j2se.Tapia.tasks;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    String title;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime time, start, end;

    int interDays, interHours, interMinute;
    boolean active, repeated;

    //NullPointerException is a run-time exception which is not recommended to catch it, but instead avoid it:

    public String getTitle(){

        return this.title;

    }


    public LocalDateTime getTime() {

        return repeated ? start : time;
    }

    public LocalDateTime getStartTime() {

        return repeated ? start : time;
    }

    public LocalDateTime getEndTime() {

        return repeated ? end : time;
    }

    public String getIntervals() {

        return repeated ? String.format("Days:%s , Hours:%d, Minutes: %b ", this.interDays, this.interHours, this.interMinute): null;
    }

    public boolean isActive() {
        return active;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setTime(String time) {
        if (repeated){
            this.interDays = 0;
            this.interMinute = 0;
            this.interHours = 0;
            this.start = LocalDateTime.now();
            this.end = LocalDateTime.now();
            this.time = LocalDateTime.parse(time, formatter);;
            setRepeated(false);
        }
        else{

            this.time = LocalDateTime.parse(time, formatter);;
        }

    }
    public void setTime(LocalDateTime startTime, LocalDateTime endTime,
                        int  interDays, int interHours, int interMinute) {
        if (!repeated){
            setIntervals(interDays, interHours, interMinute);
            this.start = startTime;
            this.end = endTime;
            this.time = LocalDateTime.now();
            setRepeated(true);
        }else{

            setIntervals(interDays, interHours, interMinute);
            this.start = startTime;
            this.end = endTime;
        }

    }

    public void setStart(LocalDateTime startTime) {
        this.start =  startTime;;
    }

    public void setEnd(LocalDateTime endTime) {
        this.end = endTime;
    }

    public void setIntervals(int  interDays, int interHours, int interMinute) {
        this.interDays  = interDays ;
        this.interHours = interHours;
        this.interMinute = interMinute;
    }

    public void setActive(boolean active) {
        this.active = active;

    }

    public void setRepeated(boolean repeated) {
        this.repeated = repeated;
    }

    public boolean isRepeated() {
        return repeated;
    }

    public LocalDateTime nextTimeAfter(String time){
        LocalDateTime current =  LocalDateTime.parse(time, formatter);

        if(!isActive() || !isRepeated() || current.isBefore(this.start)|| current.isAfter(this.end)){
            return null;
        }else{


                LocalDateTime start2 = this.start;



                while(current.isAfter(start2)){

                            start2 = start2.plusDays(this.interDays);
                            start2 = start2.plusHours(this.interHours);
                            start2 = start2.plusMinutes(this.interMinute);


                }

                return start2;



        }


    }


    //Constructor no repetitiva
    public Task(String title, String time){
        try{

            if(title == null){

                throw new IllegalArgumentException();

            }

            setRepeated(false);
            setTitle(title);
            setTime(time);
            setRepeated(false);


            }catch(IllegalArgumentException e){
            System.out.println("El titulo no puede estar vacio");

            }catch(DateTimeException e) {
            System.out.println("Los datos no son validos, ingrese datos validos");
        }

    }

    //Constructor Repetitiva
    public Task(String title, String startTime, String endTime ,int  interDays, int interHours, int interMinute ){

        try{

           LocalDateTime end =  LocalDateTime.parse(endTime, formatter);
           LocalDateTime start =  LocalDateTime.parse(startTime,formatter);

           if(!end.isAfter(start) || interDays < 0 || interMinute < 0 || interHours <0){

               throw new IllegalArgumentException();
            }
            setTitle(title);
            setStart(start);
            setEnd(end);
            setIntervals(interDays, interHours, interMinute);
            setRepeated(true);

        }catch(IllegalArgumentException e){
            System.out.println("El titulo no puede estar vacio");

        }catch(DateTimeException e) {
            System.out.println("Los datos no son validos, ingrese datos validos");
        }

    }
}
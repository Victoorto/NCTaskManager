package mx.edu.j2se.Tapia.tasks;

public class Task {

    String title;
    int time;
    int start;
    int end;
    int interval;
    boolean active;


    public String getTitle(){
        return this.title;
    }

    public int getTime() {
        if(interval > 0){
            return start;  //Si la tarea es repetitiva regresa en tiempo de inicio de la repeticion
        }
        else{
            return time; //si no es repetitiva regresa solo el tiempo
        }
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getInterval() {
        if (interval != 0){
            return interval;
        }
        else{
            return 0;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(int time) {
        if (interval != 0){
            this.interval = 0;
            this.start = 0;
            this.end = 0;
            this.time = time;
        }
        else{

            this.time = time;
        }

    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Task(String title, int time){
        this.title = title;
        this.time = time;
    }

    public Task(String title, int start, int end, int interval){

        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }
}
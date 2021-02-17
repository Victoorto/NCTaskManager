package mx.edu.j2se.Tapia.tasks;

public class Task {

    String title;
    int time, start, end, interval;
    boolean active, repeated;


    public String getTitle(){
        return this.title;
    }

    public int getTime() {
        if(interval != 0){
            return start;
        }
        else{
            return time;
        }
    }

    public int getStart() {
        if(interval == 0){
            return time;
        }
        else{
            return start;
        }
    }

    public int getEnd() {
        if(interval == 0){
            return time;
        }
        else{
            return end;
        }
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
            setRepeated(false);
        }
        else{

            this.time = time;
        }

    }
    public void setTime(int start, int end, int interval) {
        if (interval == 0){
            this.interval = interval;
            this.start = start;
            this.end = end;
            setRepeated(true);
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

    public void setRepeated(boolean repeated) {
        this.repeated = repeated;
    }

    public boolean isRepeated() {
        return repeated;
    }


    /* Constructores */
    public Task(String title, int time){

        this.title = title;
        this.time = time;
        setRepeated(false);

    }

    public Task(String title, int start, int end, int interval){

        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        setRepeated(true);

    }
}
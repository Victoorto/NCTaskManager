package mx.edu.j2se.Tapia.tasks;

public class Task {

    String title;
    int time, start, end, interval;
    boolean active, repeated;

    //NullPointerException is a run-time exception which is not recommended to catch it, but instead avoid it:
    public String getTitle(){

        return this.title;

    }

    //getTime y getStartTime son lo mismo, pero el documento requiere las dos
    public int getTime() {

        return repeated ? start : time;

    }

    public int getStartTime() {

        return repeated ? start : time;
    }

    public int getEndTime() {

        return repeated ? end : time;
    }

    public int getInterval() {

        int inter = repeated ? interval : 0;
        return inter;
    }

    public boolean isActive() {
        return active;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setTime(int time) {
        if (repeated){
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
        if (!repeated){
            this.interval = interval;
            this.start = start;
            this.end = end;
            this.time = 0;
            setRepeated(true);
        }else{

            this.interval = interval;
            this.start = start;
            this.end = end;
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

    public int nextTimeAfter(int current){
        int nextStart = current + interval;
        if(nextStart > end){
            return -1;
        }else{
            return nextStart;
        }
    }


    /* Constructores */
    public Task(String title, int time){

        try{
            if(time <= 0 ||  title == null){

                throw new IllegalArgumentException();
            }

            setRepeated(false);
            setTitle(title);
            setTime(time);

        }catch(IllegalArgumentException i){
            System.out.println("El valor tiene que ser positivo");
            setTitle(null);
            setTime(0);
        }

    }

    public Task(String title, int start, int end, int interval){

        try{
            if(start <= 0 || end  <= 0 || end < start || interval <=0 ||  title == null){

                throw new IllegalArgumentException();
            }
            setRepeated(true);
            setTitle(title);
            setStart(start);
            setEnd(end);
            setInterval(interval);

        }catch(IllegalArgumentException i){
            System.out.println("El valor de inicio, final o intervalo no puede ser menor o igual a 0");
            setRepeated(false);
            setTitle(null);
            setStart(0);
            setEnd(0);
            setInterval(0);
        }


    }
}
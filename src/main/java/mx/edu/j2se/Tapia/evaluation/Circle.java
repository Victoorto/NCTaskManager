package mx.edu.j2se.Tapia.evaluation;

public class Circle {

    private int radius;
    private int [] radius2 = {};
    private double area;
    private double pi = Math.PI;



    //Get
    public int getRadius() {
        return radius;
    }

    public int[] getRadius2() {
        return radius2;
    }


    public double getArea() {
        double rad = Math.pow(radius, 2);
        this.area = ((pi) * (rad));
        return area;
    }

    public int biggestCircle(){
        int index = 0;
        int big = 0;
        for(int i =0;i < radius2.length;i++){
            if(radius2[i]> big){
                index = i;
                big = radius2[i];
            }
        }
        double rad = Math.pow(radius2[index], 2);
        double area = ((pi) * (rad));
        System.out.println(area);
        return index;

    }

    //Set
    public void setRadius(int radius) {
        try{
            if(radius <= 0){
                throw new IllegalArgumentException();
            }
            this.radius = radius;
        }catch(IllegalArgumentException e){
            System.out.println("El valor tiene que ser positivo y diferente de 0");
            this.radius = 1;
        }

    }

    public void setRadius2(int[] radius2) {
        this.radius2 = radius2;
    }






//Constructor
    public Circle(){
        setRadius(1);

    }
    public Circle(int radius){
        try{
            if(radius <= 0){
                throw new IllegalArgumentException();
            }
            setRadius(radius);

        }catch(IllegalArgumentException e){
            System.out.println("El valor tiene que ser positivo y diferente de 0");
            setRadius(1);
        }

    }
    public Circle(int [] radius){

        try{
        for(int rad: radius){
                if(rad <= 0){
                    throw new IllegalArgumentException();
                }
                setRadius2(radius);

        }}catch(IllegalArgumentException e){
                System.out.println("El valor tiene que ser positivo y diferente de 0");
                radius2 = new int[radius.length];
                setRadius2(radius2);
            }

        }


}


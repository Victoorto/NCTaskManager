package mx.edu.j2se.Tapia.evaluation;

public class Evaluation1 {

    public static void main(String[] args) {

        //Invalid Circle
        Circle circulo1 = new Circle(1);
        System.out.println(circulo1.getArea());

       int [] circulos = {10 ,2 ,15, 20, 6, 5, 16};

       int mayorArea =  biggestCircle(circulos);
       System.out.println(mayorArea);


    }

    public static int biggestCircle(int [] circulos){
        int index = 0;
        int big = 0;
        for(int i =0;i < circulos.length;i++){
            if(circulos[i]> big){
                index = i;
                big = circulos[i];
            }
        }
        Circle circulo2 = new Circle(big);
        System.out.println(circulo2.getArea());
        return index;
    }



}

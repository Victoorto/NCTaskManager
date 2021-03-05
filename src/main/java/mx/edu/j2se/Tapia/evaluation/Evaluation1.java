package mx.edu.j2se.Tapia.evaluation;

public class Evaluation1 {

    public static void main(String[] args) {

        //Invalid Circle
        Circle circulo1 = new Circle(1);
        System.out.println(circulo1.getArea());

       int [] circulos = {10 ,2 ,15, 20, 50, 5, 16};

       Circle circulos2 = new Circle(circulos);
       //System.out.println(circulos2.getRadius2());
        System.out.println(circulos2.biggestCircle()); //imprime el area y el index del mayor circulo

    }



}

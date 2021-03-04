package mx.edu.j2se.Tapia.tasks;

public class Main {
	public static void main(String[] args) {
	    /*
		Persona estudianteNC = new Persona();
		estudianteNC.setEdad(18);
		estudianteNC.setNombre("Eduardo");
		String loDejaron = estudianteNC.loDejanEntrarAlBar();
		System.out.println(estudianteNC.nombre + " : "  + loDejaron);

		Persona estudianteNC2 = new Persona();
		estudianteNC2.setNombre("Arturo");
		estudianteNC2.setEdad(17);
		String loDejaron2 = estudianteNC2.loDejanEntrarAlBar();
		System.out.println(estudianteNC2.nombre + " : "  + loDejaron2);
        */

		Task task1 = new Task( "Salir con los amigos", 32 );
		/*System.out.println(task1.getTitle() + ' ' + task1.getTime() + ' ' + task1.isRepeated() + ' ' + task1.getInterval());
        System.out.println(task1);
		task1.setTime(70, 80, 20);
		System.out.println(task1.getTitle() + ' ' + task1.getTime() + ' ' + task1.isRepeated() + ' ' + task1.getInterval());
		ArrayTaskList.add(task1);*/




		Task task2 = new Task( "Comprar el super", 50, 200, 60 );
		/*System.out.println(task2.getTitle() + ' ' + task2.getTime() + ' ' + task2.isRepeated() + ' ' + task2.getInterval());
		task2.setTime(70);
		System.out.println(task2.getTitle() + ' ' + task2.getTime() + ' ' + task2.isRepeated() + ' ' + task2.getInterval());
          */
        ArrayTaskList.add(task1);
        ArrayTaskList.add(task2);

        //ArrayTaskList.add(task1);
        System.out.println(ArrayTaskList.arrayTask[0].getTitle());
        Task tarea1 = ArrayTaskList.getTask(1);
        Task tarea2 = ArrayTaskList.getTask(3);
       // Task[] tarea3 = ArrayTaskList.incoming(30,200);
        System.out.println(tarea1.getTitle());
       // System.out.println(tarea2.getTitle());
        //System.out.println(tarea3[0].getTitle());




        /*System.out.println(ArrayTaskList.remove(task1));
        System.out.println(ArrayTaskList.getSize());
        Task tarea4 = ArrayTaskList.getTask(1);
        Task tarea5 = ArrayTaskList.getTask(2);

        System.out.println(tarea1.getTitle());
        System.out.println(tarea2.getTitle());
      */



	}

}



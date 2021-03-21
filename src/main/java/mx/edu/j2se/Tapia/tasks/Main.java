package mx.edu.j2se.Tapia.tasks;

import java.lang.reflect.Array;
import java.util.List;

public class Main {


	public static void main(String[] args) {

        Task task1 = new Task( "Comprar el super", 50, 200, 60 );
		Task task2 = new Task( "Salir con amigos", 70 );
		Task task3 = new Task( "Ir al gym", 20, 300, 30 );
		Task task4 = new Task( "Comprar regalo de cumpleaños", 50 );


		/*ArrayTaskList list = new ArrayTaskList();

		list.add(task1);
		list.add(task2);
		list.add(task3);
		list.add(task4);
		AbstractTaskList come = list.incoming(20,100);
		System.out.println(come.getTask(1).getTitle());
*/

		LinkedTaskList list2 = new LinkedTaskList();

		list2.add(task1);
		list2.add(task2);
		list2.add(task3);
		list2.add(task4);

		System.out.println(list2.getTask(4).getTitle());

		list2.incoming(20,100);

		//list2.remove(task2);
		//Task tarea1 = list2.getTask(2);
		//System.out.println(tarea1.getTitle());



	}

}



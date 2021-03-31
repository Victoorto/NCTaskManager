package mx.edu.j2se.Tapia.tasks;

import java.lang.reflect.Array;
import java.util.Iterator;
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

		System.out.println(list.toString());
		/*Iterator<Task> it2 = list.iterator();

		System.out.println("LinkedList elements:");

		while(it2.hasNext()){
			System.out.println(it2.next().getTitle());
		}*/


		LinkedTaskList list2 = new LinkedTaskList();

		list2.add(task1);
		list2.add(task2);
		list2.add(task3);
		list2.add(task4);
		System.out.println(list2.getSize());

		list2.copyTask(3);


		//System.out.println(list2.toString());




		//list2.add(task4);


	}

}



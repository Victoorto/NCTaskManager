package mx.edu.j2se.Tapia.tasks;

import java.lang.reflect.Array;
import java.time.Month;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Main {


	public static void main(String[] args) {

        Task task1 = new Task( "Comprar el super","2021-11-20 18:00" );
		Task task2 = new Task( "Salir con amigos", "2021-10-20 18:00");
		Task task3 = new Task( "Ir al gym", "2021-09-13 18:00","2022-01-13 18:00", 10, 0, 0);
		Task task4 = new Task( "Comprar regalo de cumpleaños","2021-10-13 18:00","2021-12-13 18:00", 5, 0, 0);

		task4.setActive(true);
		System.out.println(task4.isRepeated());
		System.out.println(task4.nextTimeAfter("2021-11-10 18:00"));


		


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
		}

*/
		LinkedTaskList list2 = new LinkedTaskList();

		list2.add(task1);
		list2.add(task2);
		list2.add(task3);
		list2.add(task4);
		//System.out.println(list2.getSize());

		//list2.copyTask(3);
		//System.out.println(list2.toString());



        list2.incoming("2021-11-13 18:00", "2021-11-25 18:00").forEach(element-> System.out.println(element.getTitle()));

        //System.out.println(list2.incoming(50,100).count());

		//System.out.println(list2.toString());




		//list2.add(task4);




	}

}



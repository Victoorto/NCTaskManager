package mx.edu.j2se.Tapia.tasks;

import java.util.List;

public class Main {
	public static void main(String[] args) {

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
          LinkedTaskList list = new LinkedTaskList();

          LinkedTaskList.add(list, task1);
          LinkedTaskList.add(list, task2);
          LinkedTaskList.add(list, task1);
          LinkedTaskList.add(list, task2);

        //ArrayTaskList.add(task1);
        //System.out.println(LinkedTaskList.Tasks.get(1).getTitle());
        Task tarea1 = LinkedTaskList.getTask(4);

        System.out.println(LinkedTaskList.getSize());
        //System.out.println(LinkedTaskList.remove(tarea1));
        System.out.println(LinkedTaskList.getSize());

        List list3 = LinkedTaskList.incoming(30,200);
        Task tarea = (Task) list3.get(1);
        System.out.println(tarea.getTitle());
        /*System.out.println(ArrayTaskList.remove(task1));
        System.out.println(ArrayTaskList.getSize());
        Task tarea4 = ArrayTaskList.getTask(1);
        Task tarea5 = ArrayTaskList.getTask(2);

        System.out.println(tarea1.getTitle());
        System.out.println(tarea2.getTitle());
      */



	}

}



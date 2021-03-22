package mx.edu.j2se.Tapia.tasks;



public abstract class TaskListFactory extends AbstractTaskList{

    static AbstractTaskList createTaskList(ListTypes.types type){
        return type == ListTypes.types.ARRAY ? new ArrayTaskList() :new LinkedTaskList();
    }
}

package mx.edu.j2se.Tapia.tasks;

import org.junit.Assert;
import org.junit.Test;


public class TaskTest {

    @Test
    public void NonRepetitiveConstructorTest() throws Exception {
        Task tarea1 = new Task("Hola", 10);
        Assert.assertFalse(tarea1.isActive());

    }

}

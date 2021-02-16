package mx.edu.j2se.Tapia.tasks;

public class Main {
	public static void main(String[] args) {
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
	}

}



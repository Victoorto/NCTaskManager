package mx.edu.j2se.Tapia.tasks;

public class Persona{
	String nombre;
	int edad;
	String nacionalidad;
	Float altura;
	String sexo;

	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public Float getAltura() {
		return altura;
	}

	public String getSexo() {
		return sexo;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String loDejanEntrarAlBar(){
		if (this.edad >= 18 ){
			return "Bienvenido al Bar";
		}else{
			return "Sigue participando";
		}
	}
}
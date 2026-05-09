import java.util.List;
class Teacher{
	private String codigoProfesor;
	private String Nombre;
	private String Apellido;
	
	public Teacher(String codigoProfesor, String Nombre, String Apellido){
		this.codigoProfesor = codigoProfesor;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
	}
	
	public void setCodProfesor(String codigoProfesor){
		this.codigoProfesor = codigoProfesor;
	}
	
	public String getCodProfesor(){
		return this.codigoProfesor;
	}
	
	
	public void setNombre(String Nombre){
		this.Nombre = Nombre;
	}
	
	public String getNombre(){
		return this.Nombre;
	}
	
	public void setApellido(String Apellido){
		this.Apellido = Apellido;
	}
	
	public String getApellido(){
		return this.Apellido;
	}

	public String devolverDatos() {
		return codigoProfesor + " - " + Nombre + " " + Apellido;
	}
}
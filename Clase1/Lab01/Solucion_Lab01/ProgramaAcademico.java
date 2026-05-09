//Clase abstracta ya que no se usará programa Academico como tal
abstract class ProgramaAcademico implements IConsultable {
    //<--------Atributos-------->
    protected String nombre;
    protected String clave;
    protected char modalidad;
    protected double precio;

    //<--------Constructor-------->
    public ProgramaAcademico(String nombre, String clave, char modalidad, double precio) {
        this.nombre = nombre;
        this.clave = clave;
        this.modalidad = modalidad;
        this.precio = precio;
    }

    //<--------Metodo para consultar datos de un programa-------->
    public String consultarDatos() {
        return null;
    }
}

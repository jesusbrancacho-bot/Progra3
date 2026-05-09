import java.util.ArrayList;
public class Sede {

    //<--------Atributos-------->
    private int id;
    private String nombre;
    private String direccion;

    //como cada sede tiene multiples programas academicos
    private ArrayList<ProgramaAcademico> programasAcademicos;

    //<--------Constructor-------->
    public Sede(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.programasAcademicos = new ArrayList<>();
    }


    //<--------Metodo para agregar un programa a una sede-------->
    public void agregarProgramaAcademico(ProgramaAcademico programa) {
        programasAcademicos.add(programa);
    }

    //<--------Metodo para consultar los programas programa a una sede-------->
    /*
    * Consulta todos los programas asociados a una sede
    *
    */
    public String consultarProgramas() {
        //se crea un objeto StringBuilder
        StringBuilder sb = new StringBuilder();

        //Va agregando cada programa al StringBuilder
        for (ProgramaAcademico programa : programasAcademicos) {
            sb.append(programa.consultarDatos()).append("\n");
        }

        return "Sede: " + nombre + " - Dirección: " + direccion +"\n" + sb.toString();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<ProgramaAcademico> getProgramasAcademicos() {
        return programasAcademicos;
    }

    public void setProgramasAcademicos(ArrayList<ProgramaAcademico> programasAcademicos) {
        this.programasAcademicos = programasAcademicos;
    }
}

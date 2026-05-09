import java.util.ArrayList;
public class InstitucionEducativa {

    //<--------Atributos-------->
    private int id;
    private String ruc;
    private String nombre;
    //Lista de sedes, si es que una institución tiene varias sedes
    private ArrayList<Sede> sedes;

    //<--------Constructor-------->
    public InstitucionEducativa(int id, String ruc, String nombre) {
        this.id = id;
        this.ruc = ruc;
        this.nombre = nombre;
        this.sedes = new ArrayList<>();
    }

    //<--------Metodo para agregarSede al arreglo de listas -------->
    public void agregarSede(Sede sede) {
        sedes.add(sede);
    }

    /*se utiliza para obtener y consultar los programas académicos de una sede específica en una lista de
    sedes.*/
    public String consultarProgramasDeSede(int index) {
        return sedes.get(index).consultarProgramas();
    }
}

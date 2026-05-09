import java.time.LocalTime;
import java.util.Date;

class Curso extends ProgramaAcademico {

    //<--------Atributos-------->
    private int horasSemana;
    private int creditos;
    private Date fechaInicio;
    private Date fechaFin;
    private DiaSemana diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    //<--------Constructor-------->
    public Curso(String nombre, String clave, char modalidad, double precio, int horasSemana, int creditos, Date fechaInicio, Date fechaFin, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        super(nombre, clave, modalidad, precio);
        this.horasSemana = horasSemana;
        this.creditos = creditos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    //<--------Metodo que permite sobreescribir el otro dependiendo del hijo-------->
    @Override
    public String consultarDatos() {
        return "CURSO: " + clave + " – " + nombre + " – S/. " + precio + " – CRED: " + creditos;
    }
}

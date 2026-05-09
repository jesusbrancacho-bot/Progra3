import java.util.Date;
import java.time.LocalTime;

class Taller extends ProgramaAcademico {
    //<--------Atributos-------->
    private Date fechaRealizacion;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    //<--------Constructor-------->
    public Taller(String nombre, String clave, char modalidad, double precio,
                  Date fechaRealizacion, LocalTime horaInicio, LocalTime horaFin) {
        //Super permite heredar la construcción de la clase base
        super(nombre, clave, modalidad, precio);
        this.fechaRealizacion = fechaRealizacion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    //<--------Metodo que permite sobreescribir el otro dependiendo del hijo-------->
    @Override
    public String consultarDatos() {
        return "TALLER: " + clave + " – " + nombre + " – S/. " + precio + " – Fecha: " + fechaRealizacion;
    }
}
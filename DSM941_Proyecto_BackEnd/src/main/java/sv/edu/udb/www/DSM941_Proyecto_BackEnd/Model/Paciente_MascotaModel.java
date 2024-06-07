package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "paciente_mascota")
public class Paciente_MascotaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nombre;

    private String Edad;

    private String Raza;

    private Date Fecha_nacimiento;

    private Long Estatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Encargado_Mascota")
    private Encargado_MascotaModel encargadoMascota ;

    public Paciente_MascotaModel( ) {

    }

    public Paciente_MascotaModel(Long id) {
        this.id = id;
    }

    public Paciente_MascotaModel(Long id, String nombre, String edad, String raza, Date fecha_nacimiento, Long estatus, Encargado_MascotaModel encargadoMascota) {
        this.id = id;
        Nombre = nombre;
        Edad = edad;
        Raza = raza;
        Fecha_nacimiento = fecha_nacimiento;
        Estatus = estatus;
        this.encargadoMascota = encargadoMascota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public Date getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }

    public Long getEstatus() {
        return Estatus;
    }

    public void setEstatus(Long estatus) {
        Estatus = estatus;
    }

    public Encargado_MascotaModel getEncargadoMascota() {
        return encargadoMascota;
    }

    public void setEncargadoMascota(Encargado_MascotaModel encargadoMascota) {
        this.encargadoMascota = encargadoMascota;
    }
}

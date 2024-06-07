package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "encargado_mascota")
public class Encargado_MascotaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String 	Nombres;
    private String 	Apellidos;
    private String 	Dui;
    private String 	Edad;
    private String 	Ciudad;
    private String 	Direccion;
    private Long Estatus;


    public Encargado_MascotaModel() {

    }
    public Encargado_MascotaModel(Long id) {
        this.id = id;
    }

    public Encargado_MascotaModel(Long id, String nombres, String apellidos, String dui, String edad, String ciudad, String direccion, Long estatus) {
        this.id = id;
        Nombres = nombres;
        Apellidos = apellidos;
        Dui = dui;
        Edad = edad;
        Ciudad = ciudad;
        Direccion = direccion;
        Estatus = estatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDui() {
        return Dui;
    }

    public void setDui(String dui) {
        Dui = dui;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public Long getEstatus() {
        return Estatus;
    }

    public void setEstatus(Long estatus) {
        Estatus = estatus;
    }
}

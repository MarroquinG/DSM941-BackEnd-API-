package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model;

import jakarta.persistence.*;
@Entity
@Table(name = "usuarios")
public class UsuarioModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nombres;

    private String Apellidos;

    private String Correo;

    private String Pass;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Tipo_Usuario")
    private TipoUsuarioModel tipoUsuario;
    private Long Estatus;

    //Constructores
    public UsuarioModel( ) {

    }
    public UsuarioModel(Long id) {
        this.id = id;
    }

    public UsuarioModel(Long id, String nombres, String apellidos, String correo, String pass, TipoUsuarioModel tipoUsuario, Long estatus) {
        this.id = id;
        Nombres = nombres;
        Apellidos = apellidos;
        Correo = correo;
        Pass = pass;
        this.tipoUsuario = tipoUsuario;
        Estatus = estatus;
    }


    //Set and Get
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public TipoUsuarioModel getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioModel tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Long getEstatus() {
        return Estatus;
    }

    public void setEstatus(Long estatus) {
        Estatus = estatus;
    }
}

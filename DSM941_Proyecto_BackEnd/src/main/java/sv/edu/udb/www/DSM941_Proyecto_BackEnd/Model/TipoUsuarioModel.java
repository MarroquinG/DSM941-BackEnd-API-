package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String 	Nombre_Tipo_Usuario;


    public TipoUsuarioModel() {

    }
    public TipoUsuarioModel(Long id) {
        this.id = id;
    }

    public TipoUsuarioModel(Long id, String nombre_Tipo_Usuario) {
        this.id = id;
        Nombre_Tipo_Usuario = nombre_Tipo_Usuario;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_Tipo_Usuario() {
        return Nombre_Tipo_Usuario;
    }

    public void setNombre_Tipo_Usuario(String nombre_Tipo_Usuario) {
        Nombre_Tipo_Usuario = nombre_Tipo_Usuario;
    }


}

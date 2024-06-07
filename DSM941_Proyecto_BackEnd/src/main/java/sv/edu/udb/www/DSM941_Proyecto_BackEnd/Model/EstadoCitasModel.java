package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_cita")
public class EstadoCitasModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String 	Nombre_Estado_Cita;


//-----------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------CONSTRUCTORES----------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------

    public EstadoCitasModel() {

    }

    public EstadoCitasModel(Long id) {
        this.id = id;
    }

    public EstadoCitasModel(Long id, String nombre_Estado_Cita) {
        this.id = id;
        Nombre_Estado_Cita = nombre_Estado_Cita;

    }

//-----------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------SET AND GET -------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_Estado_Cita() {
        return Nombre_Estado_Cita;
    }

    public void setNombre_Estado_Cita(String nombre_Estado_Cita) {
        Nombre_Estado_Cita = nombre_Estado_Cita;
    }


}

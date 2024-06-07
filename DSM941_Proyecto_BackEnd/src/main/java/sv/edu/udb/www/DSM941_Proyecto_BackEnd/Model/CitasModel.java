package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "citas")
public class CitasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Fecha esta aqui**/
    @Column(name = "fecha")
    private Date fecha;

    private Time hora;

    private Long Estatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Usuario")
    private UsuarioModel usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Paciente_Mascota")
    private Paciente_MascotaModel paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Estado_Cita ")
    private EstadoCitasModel estadoCita;

//-----------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------CONSTRUCTORES----------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------

    public CitasModel( ) {

    }
    public CitasModel(Long id) {
        this.id = id;
    }

    public CitasModel(Long id, Date fecha, Time hora, Long estatus, UsuarioModel usuario, Paciente_MascotaModel paciente, EstadoCitasModel estadoCita) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        Estatus = estatus;
        this.usuario = usuario;
        this.paciente = paciente;
        this.estadoCita = estadoCita;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Long getEstatus() {
        return Estatus;
    }

    public void setEstatus(Long estatus) {
        Estatus = estatus;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Paciente_MascotaModel getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente_MascotaModel paciente) {
        this.paciente = paciente;
    }

    public EstadoCitasModel getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCitasModel estadoCita) {
        this.estadoCita = estadoCita;
    }
}

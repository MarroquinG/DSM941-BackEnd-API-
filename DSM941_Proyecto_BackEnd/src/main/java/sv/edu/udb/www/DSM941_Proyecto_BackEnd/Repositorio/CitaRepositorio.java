package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.CitasModel;

import java.util.ArrayList;

public interface CitaRepositorio extends CrudRepository<CitasModel, Long> {

    /**Citas por doctor**/

    @Query("SELECT c \n" +
            "FROM CitasModel c \n" +
            "JOIN UsuarioModel u ON c.usuario.id = u.id \n" +
            "JOIN TipoUsuarioModel tu ON u.tipoUsuario.id = tu.id \n" +
            "JOIN Paciente_MascotaModel pm ON c.paciente.id = pm.id \n" +
            "JOIN Encargado_MascotaModel em ON c.paciente.encargadoMascota.id= em.id \n" +
            "JOIN EstadoCitasModel ec ON c.estadoCita.id= ec.id \n" +
            "WHERE c.usuario.id = :id_doctor \n" +
             "  AND tu.id = 2 AND ec.id=:id_Estado_Cita " +
           " AND c.Estatus=1  AND u.Estatus=1  AND pm.Estatus=1 AND em.Estatus=1" )
    ArrayList<CitasModel> findAllCitasBy_Doctor(Long id_doctor, Long id_Estado_Cita);

    /**Citas por doctor pendientes**/
    @Query("SELECT c \n" +
            "FROM CitasModel c \n" +
            "JOIN UsuarioModel u ON c.usuario.id = u.id \n" +
            "JOIN TipoUsuarioModel tu ON u.tipoUsuario.id = tu.id \n" +
            "JOIN Paciente_MascotaModel pm ON c.paciente.id = pm.id \n" +
            "JOIN Encargado_MascotaModel em ON c.paciente.encargadoMascota.id= em.id \n" +
            "JOIN EstadoCitasModel ec ON c.estadoCita.id= ec.id \n" +
            "WHERE c.usuario.id = :id_doctor \n" +
            "  AND tu.id = 2  AND ec.id = 1" +
            " AND c.Estatus=1  AND u.Estatus=1  AND pm.Estatus=1 AND em.Estatus=1" )
    ArrayList<CitasModel> findAllCitasBy_DoctorPendientes(Long id_doctor);

    /**Citas por doctor Finalizadas**/

    @Query("SELECT c \n" +
            "FROM CitasModel c \n" +
            "JOIN UsuarioModel u ON c.usuario.id = u.id \n" +
            "JOIN TipoUsuarioModel tu ON u.tipoUsuario.id = tu.id \n" +
            "JOIN Paciente_MascotaModel pm ON c.paciente.id = pm.id \n" +
            "JOIN Encargado_MascotaModel em ON c.paciente.encargadoMascota.id= em.id \n" +
            "JOIN EstadoCitasModel ec ON c.estadoCita.id= ec.id \n" +
            "WHERE c.usuario.id = :id_doctor \n" +
            "  AND tu.id = 2  AND ec.id = 2" +
            " AND c.Estatus=1  AND u.Estatus=1  AND pm.Estatus=1 AND em.Estatus=1" )
    ArrayList<CitasModel> findAllCitasBy_DoctorFinalizados(Long id_doctor);


    /****/

    @Query("SELECT c \n" +
            "FROM CitasModel c \n" +
            "JOIN UsuarioModel u ON c.usuario.id = u.id \n" +
            "JOIN TipoUsuarioModel tu ON u.tipoUsuario.id = tu.id \n" +
            "JOIN Paciente_MascotaModel pm ON c.paciente.id = pm.id \n" +
            "JOIN Encargado_MascotaModel em ON c.paciente.encargadoMascota.id= em.id \n" +
            "  WHERE c.Estatus=1  AND u.Estatus=1  AND pm.Estatus=1 AND em.Estatus=1" )
    ArrayList<CitasModel> findAllCitas();

}

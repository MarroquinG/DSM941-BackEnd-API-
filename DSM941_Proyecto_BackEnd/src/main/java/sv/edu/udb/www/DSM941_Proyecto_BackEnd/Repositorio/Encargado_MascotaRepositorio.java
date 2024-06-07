package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Encargado_MascotaModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.UsuarioModel;

import java.util.ArrayList;

public interface Encargado_MascotaRepositorio extends CrudRepository<Encargado_MascotaModel, Long> {

    @Query("SELECT em FROM Encargado_MascotaModel em WHERE  em.Estatus = 1")
    ArrayList<Encargado_MascotaModel> allEncargadosMascota();

}

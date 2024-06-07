package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Paciente_MascotaModel;

import java.util.ArrayList;

public interface Paciente_MascotaRepositorio extends CrudRepository<Paciente_MascotaModel, Long> {

    @Query("SELECT pm FROM Paciente_MascotaModel pm WHERE pm.Estatus = 1 AND pm.encargadoMascota.Estatus=1")
    ArrayList<Paciente_MascotaModel> allPacienteMascota();
}

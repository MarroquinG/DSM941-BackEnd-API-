package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;

import org.springframework.stereotype.Service;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Encargado_MascotaModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Paciente_MascotaModel;

import java.util.ArrayList;
import java.util.Optional;



public interface Paciente_MascotaServicio {

    ArrayList<Paciente_MascotaModel> getAllPacienteMascota();
    Optional<Paciente_MascotaModel> getPaciente_MascotaById(Long id);
    Paciente_MascotaModel GuardarPaciente_Mascota(Paciente_MascotaModel a);
    boolean EliminarPaciente_Mascota(Long id);

    Paciente_MascotaModel ActualizarPaciente_Mascota(Long id, Paciente_MascotaModel pacienteMascota);
}

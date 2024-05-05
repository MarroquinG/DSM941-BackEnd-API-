package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;

import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Encargado_MascotaModel;

import java.util.ArrayList;
import java.util.Optional;

public interface Encargado_MascotaServicio {

    ArrayList<Encargado_MascotaModel> getAllEncargado_Mascota();
    Optional<Encargado_MascotaModel> getEncargado_MascotaById(Long id);
    Encargado_MascotaModel GuardarEncargado_Mascota(Encargado_MascotaModel a);
    boolean EliminarEncargado_Mascota(Long id);

    Encargado_MascotaModel ActualizarEncargado_Mascota(Long id, Encargado_MascotaModel encargado_Mascota);
}

package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;

import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.CitasModel;

import java.util.ArrayList;
import java.util.Optional;

public interface CitasServicio {

    ArrayList<CitasModel> getAllCitas();
    Optional<CitasModel> getCitaById(Long id);
    CitasModel guardarCita(CitasModel cita);
    CitasModel actualizarCita(Long id, CitasModel cita);
    boolean desactivarCita(Long id);

    ArrayList<CitasModel> findAllCitasByDoctor(Long id, Long idE);

    ArrayList<CitasModel> findAllCitasByDoctor_Pendientes(Long id);

    ArrayList<CitasModel> findAllCitasByDoctor_Finalizado(Long id);


}

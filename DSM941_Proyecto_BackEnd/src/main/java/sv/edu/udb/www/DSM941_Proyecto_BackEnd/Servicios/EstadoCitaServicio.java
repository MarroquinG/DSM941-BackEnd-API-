package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;

import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.EstadoCitasModel;

import java.util.ArrayList;
import java.util.Optional;

public interface EstadoCitaServicio {
    ArrayList<EstadoCitasModel> getAllEstadoCita();
    Optional<EstadoCitasModel> getEstadoCitaById(Long id);
    EstadoCitasModel GuardarEstadoCita(EstadoCitasModel a);


    EstadoCitasModel ActualizarEstadoCita(Long id, EstadoCitasModel estadoCita);
}

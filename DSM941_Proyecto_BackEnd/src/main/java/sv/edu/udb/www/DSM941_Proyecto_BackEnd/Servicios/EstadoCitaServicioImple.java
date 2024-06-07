package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.EstadoCitasModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio.EstadoCitaRepositorio;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class EstadoCitaServicioImple implements EstadoCitaServicio{



    @Autowired
    EstadoCitaRepositorio estadoCitaRepositorio;
    @Override
    public ArrayList<EstadoCitasModel> getAllEstadoCita() {

        return (ArrayList<EstadoCitasModel>) estadoCitaRepositorio.findAll();
    }

    @Override
    public Optional<EstadoCitasModel> getEstadoCitaById(Long id) {
        return estadoCitaRepositorio.findById(id);
    }

    @Override
    public EstadoCitasModel GuardarEstadoCita(EstadoCitasModel a) {
        return estadoCitaRepositorio.save(a);
    }


    @Override
    public EstadoCitasModel ActualizarEstadoCita(Long id, EstadoCitasModel estadoCita) {
        Optional<EstadoCitasModel> estadoCitaOptional = estadoCitaRepositorio.findById(id);
        if (estadoCitaOptional.isPresent()) {
            EstadoCitasModel estadoCitaExistente = estadoCitaOptional.get();
            estadoCitaExistente.setNombre_Estado_Cita(estadoCita.getNombre_Estado_Cita());
            estadoCitaExistente.setStatus(estadoCita.getStatus());
            return estadoCitaRepositorio.save(estadoCitaExistente);
        }
        return null; // o puedes lanzar una excepción si lo prefieres
    }
}

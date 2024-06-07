package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.CitasModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio.CitaRepositorio;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class CitasServicioImple implements CitasServicio {

    @Autowired
    private CitaRepositorio citaRepositorio;

    @Override
    public ArrayList<CitasModel> getAllCitas() {
        return (ArrayList<CitasModel>) citaRepositorio.findAllCitas();
    }


    @Override
    public ArrayList<CitasModel> findAllCitasByDoctor(Long id,Long idE) {
        return  citaRepositorio.findAllCitasBy_Doctor(id,idE);
    }

    @Override
    public ArrayList<CitasModel> findAllCitasByDoctor_Pendientes(Long id) {
        return citaRepositorio.findAllCitasBy_DoctorPendientes(id);
    }

    @Override
    public ArrayList<CitasModel> findAllCitasByDoctor_Finalizado(Long id) {
        return citaRepositorio.findAllCitasBy_DoctorFinalizados(id);
    }

    @Override
    public Optional<CitasModel> getCitaById(Long id) {
        return citaRepositorio.findById(id);
    }

    @Override
    public CitasModel guardarCita(CitasModel cita) {
        return citaRepositorio.save(cita);
    }

    @Override
    public CitasModel actualizarCita(Long id, CitasModel cita) {
        Optional<CitasModel> citaOptional = citaRepositorio.findById(id);
        if (citaOptional.isPresent()) {
            CitasModel citaExistente = citaOptional.get();
            citaExistente.setFecha(cita.getFecha());
            citaExistente.setHora(cita.getHora());
            citaExistente.setUsuario(cita.getUsuario());
            citaExistente.setPaciente(cita.getPaciente());
            citaExistente.setEstadoCita(cita.getEstadoCita());
            // Actualiza otros campos según sea necesario
            return citaRepositorio.save(citaExistente);
        }
        return null;
    }

    @Override
    public boolean desactivarCita(Long id) {
        try {
            Optional<CitasModel> citaOptional = citaRepositorio.findById(id);
            if (citaOptional.isPresent()) {
                CitasModel cita = citaOptional.get();
                // Cambia el estado de la cita según tus necesidades
                citaRepositorio.save(cita);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }


}

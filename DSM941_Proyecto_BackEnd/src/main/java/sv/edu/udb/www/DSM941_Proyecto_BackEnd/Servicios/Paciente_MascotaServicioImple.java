package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Paciente_MascotaModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio.Paciente_MascotaRepositorio;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Paciente_MascotaServicioImple implements Paciente_MascotaServicio {

    @Autowired

    Paciente_MascotaRepositorio paciente_MascotaRepositorio ;

    @Override
    public ArrayList<Paciente_MascotaModel> getAllPacienteMascota() {
        return (ArrayList<Paciente_MascotaModel>) paciente_MascotaRepositorio.allPacienteMascota();
    }

    @Override
    public Optional<Paciente_MascotaModel> getPaciente_MascotaById(Long id) {
        return paciente_MascotaRepositorio.findById(id);
    }

    @Override
    public Paciente_MascotaModel GuardarPaciente_Mascota(Paciente_MascotaModel a) {
        return paciente_MascotaRepositorio.save(a);
    }


    @Override
    public Paciente_MascotaModel ActualizarPaciente_Mascota(Long id, Paciente_MascotaModel encargado_Mascota) {
        Optional<Paciente_MascotaModel> Encargado_MascotaOptional = paciente_MascotaRepositorio.findById(id);
        if (Encargado_MascotaOptional.isPresent()) {
            Paciente_MascotaModel pacienteMascotaExiste = Encargado_MascotaOptional.get();
            pacienteMascotaExiste.setNombre(encargado_Mascota.getNombre());
            pacienteMascotaExiste.setRaza(encargado_Mascota.getRaza());
            pacienteMascotaExiste.setEdad(encargado_Mascota.getEdad());
            pacienteMascotaExiste.setEncargadoMascota(encargado_Mascota.getEncargadoMascota());
            pacienteMascotaExiste.setFecha_nacimiento(encargado_Mascota.getFecha_nacimiento());
            return paciente_MascotaRepositorio.save(pacienteMascotaExiste);
        }
        return null;
    }


}

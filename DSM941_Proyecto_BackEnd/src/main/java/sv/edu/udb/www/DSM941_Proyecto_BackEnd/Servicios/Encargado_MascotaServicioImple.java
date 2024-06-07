package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio.Encargado_MascotaRepositorio;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Encargado_MascotaModel;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Encargado_MascotaServicioImple  implements Encargado_MascotaServicio {
    @Autowired

    Encargado_MascotaRepositorio encargado_MascotaRepositorio ;
    @Override
    public ArrayList<Encargado_MascotaModel> getAllEncargado_Mascota() {
        return (ArrayList<Encargado_MascotaModel>) encargado_MascotaRepositorio.allEncargadosMascota();
    }

    @Override
    public Optional<Encargado_MascotaModel> getEncargado_MascotaById(Long id) {
        return encargado_MascotaRepositorio.encargadoMascotaById(id);
    }

    @Override
    public Encargado_MascotaModel GuardarEncargado_Mascota(Encargado_MascotaModel a) {
        return encargado_MascotaRepositorio.save(a);
    }


    @Override
    public Encargado_MascotaModel ActualizarEncargado_Mascota(Long id, Encargado_MascotaModel encargado_Mascota) {
        Optional<Encargado_MascotaModel> Encargado_MascotaOptional = encargado_MascotaRepositorio.findById(id);
        if (Encargado_MascotaOptional.isPresent()) {
            Encargado_MascotaModel encargadoMascotaExiste = Encargado_MascotaOptional.get();
            encargadoMascotaExiste.setNombres(encargado_Mascota.getNombres());
            encargadoMascotaExiste.setApellidos(encargado_Mascota.getApellidos());
            encargadoMascotaExiste.setEdad(encargado_Mascota.getEdad());
            encargadoMascotaExiste.setDui(encargado_Mascota.getDui());
            encargadoMascotaExiste.setCiudad(encargado_Mascota.getCiudad());
            encargadoMascotaExiste.setDireccion(encargado_Mascota.getDireccion());
            return encargado_MascotaRepositorio.save(encargadoMascotaExiste);
        }
        return null;
    }

}

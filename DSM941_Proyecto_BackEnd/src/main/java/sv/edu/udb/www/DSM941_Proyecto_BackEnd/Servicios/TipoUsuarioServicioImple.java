package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.TipoUsuarioModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio.TipoUsuarioRepositorio;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;



@Service
public class TipoUsuarioServicioImple  implements TipoUsuarioServicio {

    @Autowired
    TipoUsuarioRepositorio tipoUsuarioRepositorio ;
    @Override
    public ArrayList<TipoUsuarioModel> getAllTipoUsuario() {
        return (ArrayList<TipoUsuarioModel>) tipoUsuarioRepositorio.findAll();
    }

    @Override
    public Optional<TipoUsuarioModel> getTipoUsuarioById(Long id) {
        return tipoUsuarioRepositorio.findById(id);
    }

    @Override
    public TipoUsuarioModel GuardarTipoUsuario(TipoUsuarioModel a) {
        return tipoUsuarioRepositorio.save(a);
    }

    @Override
    public boolean EliminarTipoUsuario(Long id) {
        try {
            Optional<TipoUsuarioModel> a = getTipoUsuarioById(id);

            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public TipoUsuarioModel ActualizarTipoUsuario(Long id, TipoUsuarioModel tipoUsuario) {
        Optional<TipoUsuarioModel> tipoUsuarioOptional = tipoUsuarioRepositorio.findById(id);
        if (tipoUsuarioOptional.isPresent()) {
            TipoUsuarioModel tipoUsuarioExistente = tipoUsuarioOptional.get();
            tipoUsuarioExistente.setNombre_Tipo_Usuario(tipoUsuario.getNombre_Tipo_Usuario());
            tipoUsuarioExistente.setEstatus(tipoUsuario.getEstatus());
            return tipoUsuarioRepositorio.save(tipoUsuarioExistente);
        }
        return null;
    }

}

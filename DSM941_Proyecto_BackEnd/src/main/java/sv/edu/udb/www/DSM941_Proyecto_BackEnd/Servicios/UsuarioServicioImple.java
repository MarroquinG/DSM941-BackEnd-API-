package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.UsuarioModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio.UsuarioRepositorio;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class UsuarioServicioImple implements UsuarioServicio{
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Override
    public ArrayList<UsuarioModel> getAllUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepositorio.findAll();
    }

    @Override
    public ArrayList<UsuarioModel> getDoctoresById(Long tipoUsuarioId) {
        return usuarioRepositorio.findByTipoUsuarioIdAndId(tipoUsuarioId);}
    @Override
    public Optional<UsuarioModel> getUsuarioById(Long id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    public Optional<UsuarioModel> getUsuarioByCorreo(String Correo, String Contra) {
        return usuarioRepositorio.findByUsuarioByCorreo(Correo,Contra);
    }

    @Override
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UsuarioModel actualizarUsuario(Long id, UsuarioModel usuario) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepositorio.findById(id);
        if (usuarioOptional.isPresent()) {
            UsuarioModel usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombres(usuario.getNombres());
            usuarioExistente.setApellidos(usuario.getApellidos());
            usuarioExistente.setCorreo(usuario.getCorreo());
            usuarioExistente.setPass(usuario.getPass());
            usuarioExistente.setTipoUsuario(usuario.getTipoUsuario());
            usuarioExistente.setEstatus(usuario.getEstatus());
            return usuarioRepositorio.save(usuarioExistente);
        }
        return null;
    }

    @Override
    public boolean desactivarUsuario(Long id) {
        try {
            Optional<UsuarioModel> usuarioOptional = usuarioRepositorio.findById(id);
            if (usuarioOptional.isPresent()) {
                UsuarioModel usuario = usuarioOptional.get();
                usuario.setEstatus(0L);
                usuarioRepositorio.save(usuario);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}

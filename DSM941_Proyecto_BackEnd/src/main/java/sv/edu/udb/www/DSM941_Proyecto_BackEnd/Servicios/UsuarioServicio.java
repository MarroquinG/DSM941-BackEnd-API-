package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios;

import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.UsuarioModel;

import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioServicio {


    ArrayList<UsuarioModel> getAllUsuarios();

    ArrayList<UsuarioModel> getDoctoresById(Long tipoUsuarioId);
    Optional<UsuarioModel> getUsuarioByCorreo(String correo);
    Optional<UsuarioModel> getUsuarioById(Long id);

    UsuarioModel guardarUsuario(UsuarioModel usuario);

    UsuarioModel actualizarUsuario(Long id, UsuarioModel usuario);

    boolean desactivarUsuario(Long id);

}

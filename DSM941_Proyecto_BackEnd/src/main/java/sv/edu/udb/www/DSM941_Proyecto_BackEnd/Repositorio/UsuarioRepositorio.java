package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.UsuarioModel;

import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioRepositorio extends CrudRepository<UsuarioModel, Long> {

    @Query("SELECT u FROM UsuarioModel u WHERE u.tipoUsuario.id = :tipoUsuarioId")
    ArrayList<UsuarioModel> findByTipoUsuarioIdAndId(Long tipoUsuarioId);

    @Query("SELECT u FROM UsuarioModel u WHERE u.Correo = :correo and u.Pass = :contra")
    Optional<UsuarioModel> findByUsuarioByCorreo(String correo,String contra);
}


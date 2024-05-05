package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.TipoUsuarioModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios.TipoUsuarioServicio;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("TipoUsuario")
public class TipoUsuarioController {
    @Autowired
    TipoUsuarioServicio  tipoUsuarioServicio;

    @GetMapping("/All")
    public ArrayList<TipoUsuarioModel> getAllTipoUsuario(){
        return tipoUsuarioServicio.getAllTipoUsuario();
    }

    @GetMapping("/Find/{id}")
    public Optional<TipoUsuarioModel> getEstadoCitaById(@PathVariable("id") long id){
        return tipoUsuarioServicio.getTipoUsuarioById(id);
    }

    @PostMapping("/Save")
    public TipoUsuarioModel GuardarEstadoCita(@RequestBody TipoUsuarioModel a){
        return tipoUsuarioServicio.GuardarTipoUsuario(a);
    }

    @DeleteMapping("/Delete/{id}")
    public String EliminarEstadoCita(@PathVariable("id") long id ){
        if (tipoUsuarioServicio.EliminarTipoUsuario(id)){
            return "Se desactivo correctamente el Tipo de usuario";

        }else {
            return "No se puede desactivar el Tipo de usuario";
        }


    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<TipoUsuarioModel> actualizarTipoUsuario(@PathVariable("id") Long id, @RequestBody TipoUsuarioModel tipoUsuario) {
        TipoUsuarioModel tipoUsuarioActualizado = tipoUsuarioServicio.ActualizarTipoUsuario(id, tipoUsuario);
        if (tipoUsuarioActualizado != null) {return new ResponseEntity<>(tipoUsuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Encargado_MascotaModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios.Encargado_MascotaServicio;


import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("Encargado_Mascota")
public class Encargado_MascotaController {

    @Autowired
    Encargado_MascotaServicio  encargado_MascotaServicio;

    @GetMapping("/All")
    public ArrayList<Encargado_MascotaModel> getAllTipoUsuario(){
        return encargado_MascotaServicio.getAllEncargado_Mascota();
    }

    @GetMapping("/Find/{id}")
    public Optional<Encargado_MascotaModel> getEstadoCitaById(@PathVariable("id") long id){
        return encargado_MascotaServicio.getEncargado_MascotaById(id);
    }

    @PostMapping("/Save")
    public Encargado_MascotaModel GuardarEstadoCita(@RequestBody Encargado_MascotaModel a){
        return encargado_MascotaServicio.GuardarEncargado_Mascota(a);
    }

    @DeleteMapping("/Delete/{id}")
    public String EliminarEstadoCita(@PathVariable("id") long id ){
        if (encargado_MascotaServicio.EliminarEncargado_Mascota(id)){
            return "Se desactivo correctamente el Tipo de usuario";

        }else {
            return "No se puede desactivar el Tipo de usuario";
        }


    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<Encargado_MascotaModel> actualizarTipoUsuario(@PathVariable("id") Long id, @RequestBody Encargado_MascotaModel tipoUsuario) {
        Encargado_MascotaModel tipoUsuarioActualizado = encargado_MascotaServicio.ActualizarEncargado_Mascota(id, tipoUsuario);
        if (tipoUsuarioActualizado != null) {return new ResponseEntity<>(tipoUsuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

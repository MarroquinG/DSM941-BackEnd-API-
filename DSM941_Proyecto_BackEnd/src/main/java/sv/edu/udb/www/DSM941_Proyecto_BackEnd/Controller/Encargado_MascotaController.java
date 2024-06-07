package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Encargado_MascotaModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.UsuarioModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios.Encargado_MascotaServicio;


import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("Encargado_Mascota")
public class Encargado_MascotaController {

    @Autowired
    Encargado_MascotaServicio  encargado_MascotaServicio;
    /**MOSTRAR TODOS LOS ENCARGADOS MASCOTAS ACTIVOS**/
    @GetMapping("/All")
    public ArrayList<Encargado_MascotaModel> getAllTipoUsuario(){
        return encargado_MascotaServicio.getAllEncargado_Mascota();
    }
    /**ENCONTRAR ENCARGADO MASCOTA**/
    @GetMapping("/Find/{id}")
    public Optional<Encargado_MascotaModel> getEstadoCitaById(@PathVariable("id") long id){
        return encargado_MascotaServicio.getEncargado_MascotaById(id);
    }
    /**GUARDAR ENCARGADO MASCOTA**/
    @PostMapping("/Save")
    public Encargado_MascotaModel GuardarEstadoCita(@RequestBody Encargado_MascotaModel a){
        return encargado_MascotaServicio.GuardarEncargado_Mascota(a);
    }

   /**ACTUALIZAR ENCARGADO MASCOTA**/
    @PutMapping("/Update/{id}")
    public ResponseEntity<Encargado_MascotaModel> actualizarTipoUsuario(@PathVariable("id") Long id, @RequestBody Encargado_MascotaModel tipoUsuario) {
        Encargado_MascotaModel tipoUsuarioActualizado = encargado_MascotaServicio.ActualizarEncargado_Mascota(id, tipoUsuario);
        if (tipoUsuarioActualizado != null) {return new ResponseEntity<>(tipoUsuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**DESACTIVAR ENCARGADO MASCOTA**/
    @PutMapping("/DesactivarEncargadoMascota/{id}")
    public ResponseEntity<Encargado_MascotaModel> desactivarEncargadoMascota(@PathVariable("id") Long id) {
        try {
            Optional<Encargado_MascotaModel> encargadoMascotaDesactivar = encargado_MascotaServicio.getEncargado_MascotaById(id);
            if (encargadoMascotaDesactivar.isPresent()) {
                Encargado_MascotaModel encargado = encargadoMascotaDesactivar.get();
                encargado.setEstatus(0L);
                Encargado_MascotaModel usuarioActualizado = encargado_MascotaServicio.ActualizarEncargado_Mascota(id,encargado);
                return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.CitasModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.UsuarioModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios.CitasServicio;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("Cita")
public class CitasController {

    @Autowired
    private CitasServicio citaServicio;
/**TODAS LAS CITAS**/
    @GetMapping("/All")
    public ResponseEntity<ArrayList<CitasModel>> getAllCitas() {
        ArrayList<CitasModel> citas = citaServicio.getAllCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
    /**CITAS POR DOCTOR**/
    @GetMapping("/All_Citas_Doctor/{id}")
    public ResponseEntity<ArrayList<CitasModel>> getAllCitas_Doctor(@PathVariable("id") Long id) {
        ArrayList<CitasModel> citas2 = citaServicio.findAllCitasByDoctor(id);
        return new ResponseEntity<>(citas2, HttpStatus.OK);
    }

    /**CITAS POR DOCTOR PENDIENTES**/
    @GetMapping("/All_Citas_Doctor_Pendientes/{id}")
    public ResponseEntity<ArrayList<CitasModel>> findAllCitasByDoctor_Pendientes(@PathVariable("id") Long id) {
        ArrayList<CitasModel> citas3 = citaServicio.findAllCitasByDoctor_Pendientes(id);
        return new ResponseEntity<>(citas3, HttpStatus.OK);
    }
    /**CITAS POR DOCTOR FINALIZADAS**/

        @GetMapping("/All_Citas_Doctor_Finalizadas/{id}")
        public ResponseEntity<ArrayList<CitasModel>> findAllCitasByDoctor_Finalizado(@PathVariable("id") Long id){
            ArrayList<CitasModel> citas4 = citaServicio.findAllCitasByDoctor_Finalizado(id);
            return new ResponseEntity<>(citas4, HttpStatus.OK);
        }

    /**ENCONTRAR CITA POR ID**/
    @GetMapping("/Find/{id}")
    public ResponseEntity<CitasModel> getCitaById(@PathVariable("id") Long id) {
        Optional<CitasModel> cita = citaServicio.getCitaById(id);
        return cita.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**GUARDAR UNA CITA NUEVA**/
    @PostMapping("/Save")
    public ResponseEntity<CitasModel> guardarCita(@RequestBody CitasModel cita) {
        CitasModel nuevaCita = citaServicio.guardarCita(cita);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }

    /**ACTUALIZAR CITA**/
    @PutMapping("/Update/{id}")
    public ResponseEntity<CitasModel> actualizarCita(@PathVariable("id") Long id, @RequestBody CitasModel cita) {
        CitasModel citaActualizada = citaServicio.actualizarCita(id, cita);
        return citaActualizada != null ?
                new ResponseEntity<>(citaActualizada, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**ELIMINAR CITA**/
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> desactivarCita(@PathVariable("id") Long id) {
        return citaServicio.desactivarCita(id) ?
                new ResponseEntity<>("Cita desactivada correctamente", HttpStatus.OK) :
                new ResponseEntity<>("No se puede desactivar la cita", HttpStatus.NOT_FOUND);
    }

}

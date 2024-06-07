package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.Paciente_MascotaModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.UsuarioModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios.Paciente_MascotaServicio;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios.UsuarioServicio;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("Paciente_Mascota")
public class Paciente_MascotaController {
    @Autowired
    Paciente_MascotaServicio pacienteMascotaServicio;
    /**MOSTRAR PACIENTES MASCOTAS**/
    @GetMapping("/All")
    public ArrayList<Paciente_MascotaModel> getAllPacienteMascota() {
        return pacienteMascotaServicio.getAllPacienteMascota();
    }

    /**GUARDAR NUEVO PACIENTE MASCOTA**/
    @PostMapping("/Save")
    public ResponseEntity<Paciente_MascotaModel> guardarUsuario(@RequestBody Paciente_MascotaModel Paciente_Mascota) {
        Paciente_MascotaModel nuevoPacienteMascota = pacienteMascotaServicio.GuardarPaciente_Mascota(Paciente_Mascota);
        return new ResponseEntity<>(nuevoPacienteMascota, HttpStatus.CREATED);
    }
    /**ACTUALIZAR PACIENTE MASCOTA**/
    @PutMapping("/Update/{id}")
    public ResponseEntity<Paciente_MascotaModel> actualizarPaciente(@PathVariable("id") Long id, @RequestBody Paciente_MascotaModel paciente) {
        Paciente_MascotaModel pacienteActualizado = pacienteMascotaServicio.ActualizarPaciente_Mascota(id, paciente);
        if (pacienteActualizado != null) {
            return new ResponseEntity<>(pacienteActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

/**DESACTIVAR PACIENTE MASCOTA**/
    @PutMapping("/DesactivarUsuario/{id}")
    public ResponseEntity<Paciente_MascotaModel> desactivarPacienteMascota(@PathVariable("id") Long id) {
        try {
            Optional<Paciente_MascotaModel> pacienteMascotaDesactivar = pacienteMascotaServicio.getPaciente_MascotaById(id);
            if (pacienteMascotaDesactivar.isPresent()) {
                Paciente_MascotaModel usuario = pacienteMascotaDesactivar.get();
                usuario.setEstatus(0L);
                Paciente_MascotaModel usuarioActualizado = pacienteMascotaServicio.ActualizarPaciente_Mascota(id,usuario);
                return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

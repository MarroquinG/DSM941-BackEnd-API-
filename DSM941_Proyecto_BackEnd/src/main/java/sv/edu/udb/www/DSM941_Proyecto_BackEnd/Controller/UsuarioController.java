package sv.edu.udb.www.DSM941_Proyecto_BackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Model.UsuarioModel;
import sv.edu.udb.www.DSM941_Proyecto_BackEnd.Servicios.UsuarioServicio;

import java.util.ArrayList;
import java.util.Optional;
@RestController
@RequestMapping("Usuario")
public class UsuarioController {


    @Autowired
    UsuarioServicio usuarioServicio;

    /**Todos los usuarios*/
    @GetMapping("/All")
    public ArrayList<UsuarioModel> getAllUsuarios() {
        return usuarioServicio.getAllUsuarios();
    }

    /**Todos los doctores Activos**/
    @GetMapping("/AllDoctores/{id}")
    public ResponseEntity<ArrayList<UsuarioModel>> getDoctoresById(@PathVariable("id") Long id) {
        ArrayList<UsuarioModel> doctores = usuarioServicio.getDoctoresById(id);
        return new ResponseEntity<>(doctores, HttpStatus.OK);
    }
    /**Verificar Login**/
    @GetMapping("/FindByCorreo/{correo}/{contra}")
    public ResponseEntity<UsuarioModel> getUsuarioByCorreo(@PathVariable("correo") String correo,@PathVariable("contra") String contra) {
        Optional<UsuarioModel> usuarioOptional = usuarioServicio.getUsuarioByCorreo(correo,contra);
        return usuarioOptional.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**Obtener Usuario Especifico**/
    @GetMapping("/Find/{id}")
    public ResponseEntity<UsuarioModel> getUsuarioById(@PathVariable("id") Long id) {
        Optional<UsuarioModel> usuarioOptional = usuarioServicio.getUsuarioById(id);
        return usuarioOptional.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**Guardar Nuevo Usuario**/
    @PostMapping("/Save")
    public ResponseEntity<UsuarioModel> guardarUsuario(@RequestBody UsuarioModel usuario) {
        UsuarioModel nuevoUsuario = usuarioServicio.guardarUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    /**Actualizar Usuario**/
    @PutMapping("/Update/{id}")
    public ResponseEntity<UsuarioModel> actualizarUsuario(@PathVariable("id") Long id,
                                                          @RequestBody UsuarioModel usuario) {
        UsuarioModel usuarioActualizado = usuarioServicio.actualizarUsuario(id, usuario);
        return usuarioActualizado != null ?
                new ResponseEntity<>(usuarioActualizado, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**Desactivar Usuario**/
    @PutMapping("/DesactivarUsuario/{id}")
    public ResponseEntity<UsuarioModel> desactivarUsuario(@PathVariable("id") Long id) {
        try {
            Optional<UsuarioModel> usuarioDesactivar = usuarioServicio.getUsuarioById(id);
            if (usuarioDesactivar.isPresent()) {
                UsuarioModel usuario = usuarioDesactivar.get();
                usuario.setEstatus(0L);
                UsuarioModel usuarioActualizado = usuarioServicio.actualizarUsuario(id,usuario);
                return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

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
    @GetMapping("/All")
    public ArrayList<UsuarioModel> getAllUsuarios() {
        return usuarioServicio.getAllUsuarios();
    }



    @PostMapping("/Save")
    public ResponseEntity<UsuarioModel> guardarUsuario(@RequestBody UsuarioModel usuario) {
        UsuarioModel nuevoUsuario = usuarioServicio.guardarUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

}

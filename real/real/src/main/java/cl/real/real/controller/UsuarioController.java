package cl.real.real.controller;

import cl.real.real.model.Usuario;
import cl.real.real.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron datos en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "trae a todos los usuarios",
            description = "no necesita valores previos",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Usuario>> findAll(){
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "trae a un usuario por su ID",
            description = "necesita la id del usuario",
            method = "POST")
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") Integer id){
        return usuarioService.findById(id);
    }

    @Operation(summary = "Crear un nuevo usuario",
             description = "Necesita los valores para la creacion de un nuevo usuario",
             method = "POST")
    @PostMapping
    public @ResponseBody Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }
}

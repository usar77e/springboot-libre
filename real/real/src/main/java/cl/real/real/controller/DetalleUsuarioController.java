package cl.real.real.controller;

import cl.real.real.model.DetalleUsuario;
import cl.real.real.service.DetalleUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("detalle-usuario")
public class DetalleUsuarioController {

    @Autowired
    private DetalleUsuarioService detalleUsuarioService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron datos en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Trae a todo los detalles de los usuarios",
            description = "no necesita valores previos",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<DetalleUsuario>> findAll(){
        return new ResponseEntity<>(detalleUsuarioService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "trae a un detalle usuario en base a su id",
            description = "necesita el id especifico",
            method = "GET")
    @GetMapping("/{id}")
    public DetalleUsuario findById(@PathVariable("id") Integer id){
        return detalleUsuarioService.findById(id);
    }

    @Operation(summary = "Crear un nuevo usuario",
            description = "Necesita los valores para la creacion de un nuevo detalle de usuario",
            method = "POST")
    @PostMapping
    public @ResponseBody DetalleUsuario save(@RequestBody DetalleUsuario detalleUsuario){
        return detalleUsuarioService.save(detalleUsuario);
    }
}

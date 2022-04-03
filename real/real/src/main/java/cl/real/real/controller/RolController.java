package cl.real.real.controller;

import cl.real.real.model.Rol;
import cl.real.real.service.RolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron datos en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Trae a todo los roles",
            description = "no necesita valores previos",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Rol>> findAll(){
        return new ResponseEntity<>(rolService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "trae un rol en base a su id",
            description = "necesita el id especifico",
            method = "GET")
    @GetMapping("/{id}")
    public Rol findById(@PathVariable("id") Integer id){
        return rolService.findById(id);
    }

    @Operation(summary = "Crear un nuevo rol",
            description = "Necesita los valores para la creacion de un nuevo rol",
            method = "POST")
    @PostMapping
    public @ResponseBody Rol save(@RequestBody Rol rol){
        return rolService.save(rol);
    }
}

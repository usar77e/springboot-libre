package cl.real.real.controller;

import cl.real.real.model.Perfil;
import cl.real.real.service.PerfilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired
    private PerfilService perfilService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron datos en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Trae a todo los Perfiles",
            description = "no necesita valores previos",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Perfil>> findAll(){
        return new ResponseEntity<>(perfilService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "trae a un perfil en base a su id",
            description = "necesita el id especifico",
            method = "GET")
    @GetMapping("/{id}")
    public Perfil findById(@PathVariable("id") Integer id){
        return perfilService.findById(id);
    }

    @Operation(summary = "Crear un nuevo perfil",
            description = "Necesita los valores para la creacion de un nuevo perfil",
            method = "POST")
    @PostMapping
    public @ResponseBody Perfil save(@RequestBody Perfil perfil){
        return  perfilService.save(perfil);
    }
}

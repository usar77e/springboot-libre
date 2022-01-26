package cl.backend.crud.controller;

import cl.backend.crud.exception.ResourceNotFoundException;
import cl.backend.crud.model.Empleado;
import cl.backend.crud.repository.EmpleadoRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    //listar empleados API
    @GetMapping("/")
    public List<Empleado> getAllEmpleados(){
        return empleadoRepository.findAll();
    }

    //crear empleados API
    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    //buscar empleados API
    @GetMapping("{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable long id){
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Empleado no existe con esta ID: " + id));
        return ResponseEntity.ok(empleado);
    }

    //actualizar empleados API
    @PutMapping("{id}")
    public ResponseEntity<Empleado> updateEmpleadoById(@PathVariable long id,@RequestBody Empleado detallesEmpleado){
        Empleado updateempleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con esta ID: " + id));
        updateempleado.setNombre(detallesEmpleado.getNombre());
        updateempleado.setApellido(detallesEmpleado.getApellido());
        updateempleado.setCorreo(detallesEmpleado.getCorreo());
        empleadoRepository.save(updateempleado);
        return ResponseEntity.ok(updateempleado);
    }

    //borrar empleados API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmpleado(@PathVariable long id){
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con esta ID: " + id));
        empleadoRepository.delete(empleado);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

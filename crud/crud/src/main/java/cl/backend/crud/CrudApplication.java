package cl.backend.crud;

import cl.backend.crud.model.Empleado;
import cl.backend.crud.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public void run(String... args) throws Exception {
		//solo usar la primera vez de lo contrario ingresara empleados duplicados no en ID pero si e info
		/*Empleado empleado = new Empleado();
		empleado.setNombre("Daniel");
		empleado.setApellido("mardones");
		empleado.setCorreo("dan@mardones.cl");
		empleadoRepository.save(empleado);

		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Jorge");
		empleado1.setApellido("Caceres");
		empleado1.setCorreo("jor@caceres.cl");
		empleadoRepository.save(empleado1);*/
	}
}

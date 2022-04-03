package cl.real.real.service.impl;

import cl.real.real.exception.ModelNoFoundException;
import cl.real.real.model.DetalleUsuario;
import cl.real.real.repository.DetalleUsuarioRepository;
import cl.real.real.service.DetalleUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleUsuarioServiceImpl implements DetalleUsuarioService {

    @Autowired
    private DetalleUsuarioRepository detalleUsuarioRepository;

    public DetalleUsuarioServiceImpl(DetalleUsuarioRepository detalleUsuarioRepository) {
        this.detalleUsuarioRepository = detalleUsuarioRepository;
    }

    @Override
    public List<DetalleUsuario> findAll() {
        return detalleUsuarioRepository.findAll();
    }

    @Override
    public DetalleUsuario findById(Integer id) {
        Optional<DetalleUsuario> detalleUsuario = detalleUsuarioRepository.findById(id);
        if (detalleUsuario.isPresent()){
            return detalleUsuario.get();
        }else{
            throw new ModelNoFoundException("Detalle de usuario no encontrado");
        }
    }

    @Override
    public DetalleUsuario save(DetalleUsuario detalleUsuario) {
        return detalleUsuarioRepository.save(detalleUsuario);
    }

    @Override
    public boolean delete(Integer id) {
        detalleUsuarioRepository.deleteById(id);
        return true;
    }
}

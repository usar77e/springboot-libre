package cl.real.real.service.impl;

import cl.real.real.exception.ModelNoFoundException;
import cl.real.real.model.Usuario;
import cl.real.real.repository.UsuarioRepository;
import cl.real.real.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            return usuario.get();
        } else {
            throw new ModelNoFoundException("Usuario no encontrado.");
        }
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean delete(Integer id) {
        usuarioRepository.deleteById(id);
        return true;
    }
}

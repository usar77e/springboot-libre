package cl.real.real.service.impl;

import cl.real.real.exception.ModelNoFoundException;
import cl.real.real.model.Perfil;
import cl.real.real.repository.PerfilRepository;
import cl.real.real.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public PerfilServiceImpl(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil findById(Integer id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        if(perfil.isPresent()){
            return perfil.get();
        }else{
            throw new ModelNoFoundException("Perfil no encontrado");
        }
    }

    @Override
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public boolean delete(Integer id) {
        perfilRepository.deleteById(id);
        return true;
    }
}

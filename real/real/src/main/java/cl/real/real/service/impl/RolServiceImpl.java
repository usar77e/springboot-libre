package cl.real.real.service.impl;

import cl.real.real.exception.ModelNoFoundException;
import cl.real.real.model.Rol;
import cl.real.real.repository.RolRepository;
import cl.real.real.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(Integer id) {
        Optional<Rol> rol = rolRepository.findById(id);
        if(rol.isPresent()){
            return rol.get();
        }else{
            throw new ModelNoFoundException("Rol no encontrado");
        }
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public boolean delete(Integer id) {
        rolRepository.deleteById(id);
        return true;
    }
}

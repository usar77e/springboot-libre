package cl.real.real.service;

import java.util.List;

public interface ICRUD<E> {
    List<E> findAll();

    E findById(Integer id);

    E save(E e);

    boolean delete(Integer id);
}

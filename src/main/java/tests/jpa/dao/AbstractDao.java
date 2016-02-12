package tests.jpa.dao;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tests.jpa.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<T extends BaseEntity, PK extends Serializable> {

    @Transactional(propagation = Propagation.REQUIRED)
    T saveOrUpdate(T object);

    T getById(PK id);

    List<T> getAll();
}

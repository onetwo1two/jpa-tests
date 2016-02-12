package tests.jpa.dao.impl;


import tests.jpa.dao.AbstractDao;
import tests.jpa.entities.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDaoImpl<T extends BaseEntity, PK extends Serializable> implements AbstractDao <T, PK> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> templateClass;

    public AbstractDaoImpl() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        templateClass = (Class) type.getActualTypeArguments()[0];
    }

    @Override
    public T saveOrUpdate(T object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
        if (object.getId() == null) {
            entityManager.persist(object);
            return object;
        }
        return entityManager.merge(object);
    }

    public T getById(PK id) {
        return entityManager.find(templateClass, id);
    }

    public List<T> getAll() {
        return entityManager.createQuery(String.format(
                "SELECT o FROM %s o", templateClass.getSimpleName()),
                templateClass).getResultList();
    }
}

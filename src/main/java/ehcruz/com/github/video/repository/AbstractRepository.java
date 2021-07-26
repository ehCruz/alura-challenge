package ehcruz.com.github.video.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractRepository<T, PK> {

    @Inject
    protected EntityManager em;

    private final Class<T> persistentClass;

    protected AbstractRepository(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public T findById(PK pk) {
        return em.find(this.persistentClass, pk);
    }

    public T save(T entity) {
        em.persist(entity);
        return entity;
    }

    public T update(T entity) {
        em.merge(entity);
        return entity;
    }

    public List<T> findAll() {
        return em.createQuery("from " + this.persistentClass.getName(), persistentClass).getResultList();
    }

    public void delete(PK pk) {
        T entity = findById(pk);
        em.remove(entity);
    }

}
package abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class AbstractService<T extends JpaRepository<E, Integer>,E extends EntityJpa> {

    @Autowired
    private T repository;

    @Transactional
    public E save(E entity){
        return repository.save(entity);
    }

    public E findById(Integer id){
        return repository.findById(id).get();
    }

    public List<E> findAll(){
        return repository.findAll();
    }

    @Transactional
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

}

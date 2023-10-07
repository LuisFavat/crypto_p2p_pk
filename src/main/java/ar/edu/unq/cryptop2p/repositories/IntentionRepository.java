package ar.edu.unq.cryptop2p.repositories;

import ar.edu.unq.cryptop2p.model.intention.Intention;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentionRepository extends CrudRepository<Intention, Integer>
{

}

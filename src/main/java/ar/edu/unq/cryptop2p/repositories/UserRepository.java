package ar.edu.unq.cryptop2p.repositories;

import ar.edu.unq.cryptop2p.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Long>
{
    Optional<AppUser> findById(Integer id);
}

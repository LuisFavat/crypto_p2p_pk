package ar.edu.unq.cryptop2p.repositories;

import ar.edu.unq.cryptop2p.model.Cryptos.Crypto;
import org.springframework.data.repository.CrudRepository;

public interface CryptoRepository extends CrudRepository<Crypto, Integer> {
}

package ar.edu.unq.cryptop2p.model.intention;

import ar.edu.unq.cryptop2p.model.Cryptos.Crypto;
import ar.edu.unq.cryptop2p.model.AppUser;
import jakarta.persistence.Entity;

@Entity
public class Sell extends Intention
{
    public Sell(Crypto crypto, float amount, float intentionPrice, AppUser appUser) throws Exception {
        super(crypto, amount, intentionPrice, appUser);
    }
}

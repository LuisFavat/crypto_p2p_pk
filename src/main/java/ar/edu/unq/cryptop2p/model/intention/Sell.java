package ar.edu.unq.cryptop2p.model.intention;

import ar.edu.unq.cryptop2p.model.Crypto;
import ar.edu.unq.cryptop2p.model.User;
import ar.edu.unq.cryptop2p.model.exceptions.IntentionPriceException;

public class Sell extends Intention
{
    public Sell(Crypto crypto, float amount, float intentionPrice, User user) throws Exception {
        super(crypto, amount, intentionPrice, user);
    }
}
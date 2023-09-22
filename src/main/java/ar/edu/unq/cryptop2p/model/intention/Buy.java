package ar.edu.unq.cryptop2p.model.intention;

import ar.edu.unq.cryptop2p.model.Crypto;
import ar.edu.unq.cryptop2p.model.User;
import ar.edu.unq.cryptop2p.model.exceptions.IntentionPriceException;

import java.text.Format;
import java.text.MessageFormat;

public class Buy extends Intention
{
    public Buy(Crypto crypto, float amount, float intentionPrice, User user) throws Exception {
        super(crypto, amount, intentionPrice, user);
    }
}

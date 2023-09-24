package ar.model;

import ar.edu.unq.cryptop2p.model.USD;
import ar.edu.unq.cryptop2p.model.intention.Intention;
import org.junit.jupiter.api.Test;
import static ar.model.builders.CryptoBuilder.anyCrypto;
import static ar.model.builders.IntentionBuilder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntentionTests
{
    @Test
    void cant_create_intention_case_intention_price_to_high()
    {
        var cryptoPrice = 30000;
        var intentionPrice = 1.051f * cryptoPrice;
        var crypto = anyCrypto().withPrice(cryptoPrice).build();
        Intention intention;
        String msg = "";

        try
        {
                intention = anyIntention().withCrypto(crypto).withIntentionPrice(intentionPrice).build();
        }
        catch (Exception e)
        {
            msg = e.getMessage();
        }

        assertEquals("Price to high! The intention price cannot be greater than 5% of the price of the crypto currency",
                msg);
    }

    @Test
    void cant_create_intention_case_intention_price_to_low()
    {
        var cryptoPrice = 30000;
        var intentionPrice = 0.94f * cryptoPrice;
        var crypto = anyCrypto().withPrice(cryptoPrice).build();
        Intention intention;
        String msg = "";

        try
        {
            intention = anyIntention().withCrypto(crypto).withIntentionPrice(intentionPrice).build();
        }
        catch (Exception e)
        {
            msg = e.getMessage();
        }

        assertEquals("Price to low! The intention price cannot be less than -5% of the price of the crypto currency",
                msg);
    }

}

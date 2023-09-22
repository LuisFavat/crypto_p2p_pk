package ar.model.builders;

import ar.edu.unq.cryptop2p.model.Crypto;
import ar.edu.unq.cryptop2p.model.User;
import ar.edu.unq.cryptop2p.model.intention.Buy;
import ar.edu.unq.cryptop2p.model.intention.Intention;
import ar.edu.unq.cryptop2p.model.intention.Sell;

import java.util.Objects;

public class IntentionBuilder
{
    private Crypto crypto;
    private float amount;
    private User user;
    private float intentionPrice = 30000f;
    public String typeOfBuild = "any";


    public static IntentionBuilder anyIntention()
    {
        return new IntentionBuilder();
    }
    public static IntentionBuilder buyIntention()
    {
        var obj = new IntentionBuilder();
        obj.setTypeOfBuild("buy");
        return obj;
    }
    public static IntentionBuilder sellIntention()
    {
        return new IntentionBuilder();
    }

    public void setTypeOfBuild(String typeOfBuild)
    {
        this.typeOfBuild = typeOfBuild;
    }

    public IntentionBuilder withCrypto(Crypto crypto)
    {
        this.crypto = crypto;
        return this;
    }

    public IntentionBuilder withAmount(float amount)
    {
        this.amount = amount;
        return this;
    }

    public IntentionBuilder withUser (User user)
    {
        this.user = user;
        return this;
    }

    public IntentionBuilder withIntentionPrice(float intentionPrice)
    {
        this.intentionPrice = intentionPrice;
        return this;
    }
    public Intention build() throws Exception {
        if(Objects.equals(this.typeOfBuild, "buy"))
        {
            return new Buy(crypto, amount, intentionPrice, user);
        }
        return  new Sell(crypto, amount, intentionPrice, user);
    }



}

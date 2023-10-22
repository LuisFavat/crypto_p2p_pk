package ar.edu.unq.cryptop2p.model.intention;

import ar.edu.unq.cryptop2p.model.Cryptos.Crypto;
import ar.edu.unq.cryptop2p.model.AppUser;
import ar.edu.unq.cryptop2p.model.Cryptos.CryptoName;
import ar.edu.unq.cryptop2p.model.exceptions.IntentionPriceException;
import jakarta.persistence.*;

import java.text.MessageFormat;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Intention
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;

    @ManyToOne
    protected Crypto crypto;
    protected float amount;
    @ManyToOne
    private AppUser IntentionUser;
    private float intentionPrice;
    @Transient
    private float maxIndex = 1.05f;
    @Transient
    private float minIndex = 0.95f;

    protected Intention(Crypto crypto, float amount, float intentionPrice, AppUser IntentionUser) throws Exception
    {
        this.crypto = crypto;
        this.amount = amount;
        this.IntentionUser = IntentionUser;
        setIntentionPrice(intentionPrice);
    }

    public float amountOperationInUSD()
    {
        return crypto.getPrice() * amount;
    }


    private void setIntentionPrice(float intentionPrice) throws IntentionPriceException {
        if(isGreaterThanMax(intentionPrice))
        {
            throw new IntentionPriceException(MessageFormat.format("Price to high! The intention price cannot be greater than {0}% of the price of the crypto currency", maxIndex * 100 -100));
        }
        if(isLessThanMin(intentionPrice))
        {
            throw new IntentionPriceException(MessageFormat.format("Price to low! The intention price cannot be less than -5% of the price of the crypto currency", maxIndex * 100 -100));
        }
        this.intentionPrice = intentionPrice;
    }

    private boolean isGreaterThanMax(float intentionPrice)
    {
        return  intentionPrice  > maxIndex * crypto.getPrice();
    }

    private boolean isLessThanMin(float intentionPrice)
    {
        return  intentionPrice  < minIndex * crypto.getPrice();
    }

    public boolean isIntentionPriceOutsideMinAndMax()
    {
        return isLessThanMin(intentionPrice) || isGreaterThanMax(intentionPrice);
    }

    public AppUser getUser()
    {
        return IntentionUser;
    }
}

package ar.model.builders;

import ar.edu.unq.cryptop2p.model.Crypto;
import ar.edu.unq.cryptop2p.model.CryptoName;

import java.time.LocalDateTime;

public class CryptoBuilder
{
    private CryptoName name = CryptoName.BTCUSDT;
    private LocalDateTime time = LocalDateTime.now();
    private float price = 30000;

    public static CryptoBuilder anyCrypto()
    {
        return new CryptoBuilder();
    }

    public  CryptoBuilder withName(CryptoName name)
    {
        this.name = name;
        return this;
    }

    public  CryptoBuilder withTime(LocalDateTime time)
    {
        this.time = time;
        return this;
    }
    public  CryptoBuilder withPrice(float price)
    {
        this.price = price;
        return this;
    }

    public  Crypto build()
    {
        return new Crypto(name, time, price);
    }
}

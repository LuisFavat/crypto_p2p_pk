package ar.edu.unq.cryptop2p.model;

import java.time.LocalDateTime;

public class Crypto {
    private CryptoName name;
    private LocalDateTime time;
    private float price;

    public Crypto(CryptoName name, LocalDateTime time, float price)
    {
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public CryptoName getName()
    {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public LocalDateTime getTime()
    {
        return time;
    }

    public void updateTimeAndPrice(LocalDateTime time, float price)
    {
        this.time = time;
        this.price = price;
    }
}

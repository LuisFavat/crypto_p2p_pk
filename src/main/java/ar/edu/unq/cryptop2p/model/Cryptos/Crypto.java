package ar.edu.unq.cryptop2p.model.Cryptos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.time.LocalDateTime;

@Entity
public class Crypto {
    @Id
    private CryptoName name;
    @Transient
    private LocalDateTime time;
    @Transient
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

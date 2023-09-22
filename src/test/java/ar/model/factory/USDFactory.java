package ar.model.factory;

import ar.edu.unq.cryptop2p.model.USD;
import ar.edu.unq.cryptop2p.model.USD.*;

public class USDFactory {
    public static USD aUSDWithSellPrice(float price)
    {
        return new USD(price,1);
    }

    public static USD aUSDWithBuyPrice(float price)
    {
        return new USD(1,price);
    }
}

package ar.edu.unq.cryptop2p.model;

public  class USD {

    //Prices from point of view of the user
    public static float sellPrice;
    public static float buyPrice;

    public USD(float sellPrice, float buyPrice)
    {
        USD.sellPrice = sellPrice;
        USD.buyPrice = buyPrice;
    }

    public static float USDBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        USD.buyPrice = buyPrice;
    }
    public static float USDSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        USD.sellPrice = sellPrice;
    }
}

package ar.edu.unq.cryptop2p.model;

public  class USD {

    private static float price;

    public USD(float price)
    {
        USD.price = price;
    }

    public static void setPrice(float price)
    {
        USD.price = price;
    }

    public static float getPrice()
    {
        return price;
    }

}

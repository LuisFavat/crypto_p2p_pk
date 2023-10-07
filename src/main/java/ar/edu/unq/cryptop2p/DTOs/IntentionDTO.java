package ar.edu.unq.cryptop2p.DTOs;

import ar.edu.unq.cryptop2p.model.AppUser;
import ar.edu.unq.cryptop2p.model.Cryptos.Crypto;
import ar.edu.unq.cryptop2p.model.Cryptos.CryptoName;
import ar.edu.unq.cryptop2p.model.intention.Buy;

import java.time.LocalDateTime;

public class IntentionDTO
{
    private CryptoName cryptoName;
    private float amount;
    private int appUserID;
    private float intentionPrice;

    public IntentionDTO(CryptoName cryptoName, float amount, int appUserID, float intentionPrice) {
        this.cryptoName = cryptoName;
        this.amount = amount;
        this.appUserID = appUserID;
        this.intentionPrice = intentionPrice;
    }

    public Buy toObjectModel(Crypto crypto, AppUser user)
    {
        //Crypto crypto = new Crypto(CryptoName.BTCUSDT, LocalDateTime.now(), 30000);
        Buy intentionBuy = null;
        //aca pedir la crypto a una pool de cryptos
        try
        {
            intentionBuy = new Buy(crypto, amount, intentionPrice, user);
        }
        catch (Exception e)
        {
            //Aca puede ser que no se genere la intention porque el precio supera el 5%
            //aca se lanzar exception y se detiene la ejecucion del metodo
        }
        return intentionBuy;
    }

    public int getAppUserID() {
        return appUserID;
    }
}

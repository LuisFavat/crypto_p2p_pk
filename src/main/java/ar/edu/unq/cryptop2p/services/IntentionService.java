package ar.edu.unq.cryptop2p.services;

import ar.edu.unq.cryptop2p.DTOs.IntentionDTO;
import ar.edu.unq.cryptop2p.model.AppUser;
import ar.edu.unq.cryptop2p.model.Cryptos.Crypto;
import ar.edu.unq.cryptop2p.model.Cryptos.CryptoName;

import ar.edu.unq.cryptop2p.model.intention.Buy;
import ar.edu.unq.cryptop2p.repositories.IntentionRepository;
import ar.edu.unq.cryptop2p.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class IntentionService
{
    @Autowired
    IntentionRepository intentionRepository;
    @Autowired
    UserRepository userRepository;
    public IntentionDTO createBuy(IntentionDTO intentionBuyDTO) throws Exception {
        //TODO usar una pool de cryptos desde el dto
        Crypto btc = new Crypto(CryptoName.BTCUSDT, LocalDateTime.now(), 30000);
        var userO  = userRepository.findById(1L);
        var user = userO.get();

        Buy intentionBuy = intentionBuyDTO.toObjectModel(btc,user);
        intentionRepository.save(intentionBuy);
        return intentionBuyDTO;
    }
}

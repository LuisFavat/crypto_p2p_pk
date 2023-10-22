package ar.edu.unq.cryptop2p.webservices;

import ar.edu.unq.cryptop2p.model.Cryptos.Crypto;
import ar.edu.unq.cryptop2p.services.CryptoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CryptoActiveController
{
//    @Autowired
//    CryptoService cryptoService;
//
//    @Operation(summary = "Get a cryptocurrency price")
//    @GetMapping("/crypto/{symbol}")
//    public ResponseEntity<Crypto> getCryptoCurrencyValue(
//            @Parameter(description = "The cryptocurrency symbol that needs to be fetched", required = true) @PathVariable String symbol) {
//        Crypto entity = cryptoService.getCryptoValue(symbol);
//        return ResponseEntity.ok().body(entity);
//    }
}

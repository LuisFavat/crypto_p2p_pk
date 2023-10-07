package ar.edu.unq.cryptop2p.webservices;

import ar.edu.unq.cryptop2p.DTOs.IntentionDTO;

import ar.edu.unq.cryptop2p.services.IntentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/intention")
public class IntentionController
{
    @Autowired
    IntentionService service;
    @PostMapping("/create/buy")
    public ResponseEntity<IntentionDTO> create(@RequestBody IntentionDTO intentionBuy) throws Exception {
        IntentionDTO intention = service.createBuy(intentionBuy);
        return  ResponseEntity.ok().body(intention);
    }
}

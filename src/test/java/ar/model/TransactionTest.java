package ar.model;

import ar.edu.unq.cryptop2p.model.Status;
import ar.edu.unq.cryptop2p.model.USD;
import ar.edu.unq.cryptop2p.model.exceptions.StateException;
import org.junit.jupiter.api.Test;

import static ar.model.builders.CryptoBuilder.anyCrypto;
import static ar.model.builders.IntentionBuilder.*;
import static ar.model.factory.TransactionFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    @Test
    void return_operation_amount_in_pesos() throws Exception {
        var cryptoPrice = 30000;
        var usdPrice = 780;
        var cryptoAmount = 0.01f;
        USD.setPrice(usdPrice);
        var crypto = anyCrypto().withPrice(cryptoPrice).build();
        var intention = anyIntention().withAmount(cryptoAmount).withCrypto(crypto).build();
        var transaction = aTransactionWithIntention(intention);


        assertEquals(cryptoAmount * cryptoPrice * usdPrice, transaction.operationAmountInPesos());
    }

    @Test
    void the_status_of_a_new_transaction_is_active() throws StateException {
        var transaction = anyTransaction();

        assertEquals(Status.active, transaction.getStatus());
    }

    @Test
    void a_succesful_transaction_can_be_processed_case_normal_procedure() throws StateException {
        var transaction = anyTransaction();

        transaction.transferDone(); //money transfer notification
        transaction.confirm();      //confirm money transfer
        transaction.transferDone(); //crypto transfer notification
        transaction.confirm();      //confirm crypto transfer

        assertEquals(Status.succesful, transaction.getStatus());
    }

    @Test
    void can_cancel_a_transaction() throws StateException {
        var transaction = anyTransaction();

        transaction.cancel();

        assertEquals(Status.cancelled, transaction.getStatus());
    }
}

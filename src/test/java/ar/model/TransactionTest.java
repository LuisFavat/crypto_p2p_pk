package ar.model;

import ar.edu.unq.cryptop2p.model.Status;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.USD;
import ar.edu.unq.cryptop2p.model.exceptions.StateException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static ar.model.builders.CryptoBuilder.anyCrypto;
import static ar.model.builders.IntentionBuilder.*;
import static ar.model.factory.TimeFactory.anyTime;
import static ar.model.factory.TransactionFactory.*;
import static ar.model.builders.TransactionBuilder.*;
import static ar.model.builders.UserBuilder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

public class TransactionTest {

    @Test
    void al_momento_de_crear_la_transaccion_se_fija_el_precio_de_venta_segun_la_ultima_cotizacion() throws Exception {
        var cryptoPrice = 30000;
        var usdPrice = 780;
        var cryptoAmount = 0.01f;
        USD.setPrice(usdPrice);
        var crypto = anyCrypto().withPrice(cryptoPrice).build();
        var intention = anyIntention().withAmount(cryptoAmount).withCrypto(crypto).build();

        //TODO aca uso el builder o el contructor (si uso el contructor necesito mas cosas)
        var transaction = aTransactionWithIntention(intention);
        //crypto.set

        assertEquals(30000 * 780 * 0.01, transaction.getOperatedAmountInPesos());
    }

    @Test
    void the_status_of_a_new_transaction_is_active() throws StateException {
        var transaction = anyTransaction();

        assertEquals(Status.STEP_1_WAITING_CASH_TRANSFER_CONFIRMATION, transaction.getStatus());
    }

    @Test
    void a_succesful_transaction_can_be_processed_case_normal_procedure() throws Exception {

        var transaction = aTransaction().build();

        transaction.notificationOfCashTransferred();
        transaction.notificationOfCryptoTransfered();

        assertEquals(Status.SUCCESFUL, transaction.getStatus());
    }

    @Test
    void can_cancel_a_transaction() throws Exception {
        var transaction = anyTransaction();
        var user = anyUser().build();

        transaction.cancelTransactionAndPunish(user);

        assertEquals(Status.CANCELLED_BY_USER, transaction.getStatus());
    }

    @Test
    void the_reputation_cant_be_less_than_zero() throws Exception {
        var transaction = anyTransaction();
        var user = anyUser().withReputation(0).build();

        transaction.cancelTransactionAndPunish(user);

        assertEquals(0, user.getReputation());
    }
    @Test
    void can_cancel_a_transaction_the_user_who_cancel_receives_a_punish() throws Exception {
        var transaction = anyTransaction();
        var user = anyUser().withReputation(20).build();

        transaction.cancelTransactionAndPunish(user);

        assertEquals(0, user.getReputation());
    }

    @Test
    void if_the_price_is_out_of_range_at_the_end_of_the_transaction_this_is_cancelled_by_system() throws Exception {
        var crypto = anyCrypto().withPrice(10).build();
        var intention = anyIntention().withCrypto(crypto).withIntentionPrice(10.01f).build();
        var transaction = aTransaction().withIntention(intention).build();
        crypto.updateTimeAndPrice(LocalDateTime.now(), 12);

        transaction.notificationOfCashTransferred();
        transaction.notificationOfCryptoTransfered();


        assertEquals(Status.CANCELLED_BY_SYSTEM_PRICE_OUT_OF_RANGE, transaction.getStatus());
    }

    @Test
    void if_the_operation_is_succeeds_before_the_time_limit_the_users_earn_points() throws Exception {

        var intentionUser = anyUser().withPoints(10).build();
        var interesedUser = anyUser().withPoints(100).build();
        var creationTime = LocalDateTime.of(2022,9,1,22,00);
        var finishTime   = LocalDateTime.of(2022,9,1,22,30);
        var intention = anyIntention().withUser(intentionUser).build();
        var transaction = aTransaction().withInteresedUser(interesedUser).withIntention(intention).build();

        transaction.notificationOfCashTransferred();
        transaction.notificationOfCryptoTransfered();

        assertEquals(20, intentionUser.getPoints());
        assertEquals(110, interesedUser.getPoints());
    }

    @Test
    void if_the_operation_is_succeeds_after_the_time_limit_the_users_earn_less_points() throws Exception
    {

//        var intentionUser = anyUser().withPoints(10).build();
//        var interesedUser = anyUser().withPoints(100).build();
//        var intention = anyIntention().withUser(intentionUser).build();
//        var transaction = aTransaction().withInteresedUser(interesedUser).withIntention(intention).build();
//
//        transaction.notificationOfCashTransferred();
//        try {
//            //Ponemos a "Dormir" el programa durante los ms que queremos
//            //Thread.sleep(60*1000);
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//        transaction.notificationOfCryptoTransfered();
//
//        assertEquals(15, intentionUser.getPoints());
//        assertEquals(105, interesedUser.getPoints());
    }

    @Test
    void la_idea_es_probar_que_despues_de_30_min_se_ganan_menos_puntos() throws Exception
    {
        /*
        //TODO este test. no funciona y revela la implementacion (se revela que se usa LocalDateTime)
        LocalDateTime creationTime = LocalDateTime.of(2020,1,1,23,35,00);
        LocalDateTime finishTime = LocalDateTime.of(2020,1,2,00,05,01);
        var duration = Duration.between(creationTime, finishTime);
        var intentionUser = anyUser().withPoints(10).build();
        var interesedUser = anyUser().withPoints(100).build();
        var intention = anyIntention().withUser(intentionUser).build();
        Transaction transaction;

        try (MockedStatic<LocalDateTime> mockedStatic = mockStatic(LocalDateTime.class)) {
            mockedStatic.when(LocalDateTime::now).thenReturn(creationTime);
            transaction = aTransaction().withInteresedUser(interesedUser).withIntention(intention).build();
            mockedStatic.when(LocalDateTime::now).thenReturn(finishTime);
            transaction.notificationOfCashTransferred();
            transaction.notificationOfCryptoTransfered();
//            try (MockedStatic<Duration> dur = mockStatic(Duration.class)) {
//                dur.when(Duration::).thenReturn();
//                transaction.notificationOfCryptoTransfered();
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        try (MockedStatic<Duration> mockedStatic = mockStatic(Duration.class)) {
//            mockedStatic.when(Duration::between).thenReturn(duration);
//            transaction = aTransaction().withInteresedUser(interesedUser).withIntention(intention).build();
//            mockedStatic.when(LocalDateTime::now).thenReturn(finishTime);
//            transaction.notificationOfCashTransferred();
//            transaction.notificationOfCryptoTransfered();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        assertEquals(15, intentionUser.getPoints());
        assertEquals(105, interesedUser.getPoints());

         */
    }





}

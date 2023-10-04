package ar.model.factory;

import ar.edu.unq.cryptop2p.model.Status;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.AppUser;
import ar.edu.unq.cryptop2p.model.intention.Intention;

import static ar.model.builders.IntentionBuilder.anyIntention;

public class TransactionFactory {

    private static Intention intention;

    static {
        try {
            intention = anyIntention().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static AppUser appUser;

    public static Transaction aTransactionWithInteresedUser(AppUser appUser)
    {
        return  new Transaction(intention, appUser, Status.STEP_1_WAITING_CASH_TRANSFER_CONFIRMATION);
    }

    public static Transaction aTransactionWithIntention(Intention intention)
    {
        return new Transaction(intention, TransactionFactory.appUser, Status.STEP_1_WAITING_CASH_TRANSFER_CONFIRMATION);
    }

    public static Transaction anyTransaction()
    {
        return new Transaction(TransactionFactory.intention, TransactionFactory.appUser, Status.STEP_1_WAITING_CASH_TRANSFER_CONFIRMATION);
    }

    public static Transaction aTransactionWithStatus(Status status)
    {
        return new Transaction(TransactionFactory.intention, TransactionFactory.appUser, status);
    }


}

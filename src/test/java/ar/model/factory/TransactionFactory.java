package ar.model.factory;

import ar.edu.unq.cryptop2p.model.Status;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.User;
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

    private static User user;

    public static Transaction aTransactionWithInteresedUser(User user)
    {
        return  new Transaction(intention, user, Status.STEP_1_WAITING_CASH_TRANSFER_CONFIRMATION);
    }

    public static Transaction aTransactionWithIntention(Intention intention)
    {
        return new Transaction(intention, TransactionFactory.user, Status.STEP_1_WAITING_CASH_TRANSFER_CONFIRMATION);
    }

    public static Transaction anyTransaction()
    {
        return new Transaction(TransactionFactory.intention, TransactionFactory.user, Status.STEP_1_WAITING_CASH_TRANSFER_CONFIRMATION);
    }

    public static Transaction aTransactionWithStatus(Status status)
    {
        return new Transaction(TransactionFactory.intention, TransactionFactory.user, status);
    }


}

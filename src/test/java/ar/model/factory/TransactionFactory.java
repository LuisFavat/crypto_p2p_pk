package ar.model.factory;

import ar.edu.unq.cryptop2p.model.Status;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.User;
import ar.edu.unq.cryptop2p.model.intention.Intention;
import ar.edu.unq.cryptop2p.model.state.CashTranfer;

public class TransactionFactory {

    private static Intention intention;
    private static User user;

    public static Transaction aTransactionWithInteresedUser(User user)
    {
        return  new Transaction(intention, user, Status.active, new CashTranfer());
    }

    public static Transaction aTransactionWithIntention(Intention intention)
    {
        return new Transaction(intention, TransactionFactory.user, Status.active, new CashTranfer());
    }

    public static Transaction anyTransaction()
    {
        return new Transaction(TransactionFactory.intention, TransactionFactory.user, Status.active, new CashTranfer());
    }

    public static Transaction aTransactionWithStatus(Status status)
    {
        return new Transaction(TransactionFactory.intention, TransactionFactory.user, status, new CashTranfer());
    }


}

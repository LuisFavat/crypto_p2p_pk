package ar.edu.unq.cryptop2p.model.state;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.StateException;

public class CashConfirmationer extends State
{
    @Override
    public void transferNotification(Transaction transaction) throws StateException
    {
        throw new StateException("Message transferNotification() should not be sent to CashConfirmationer intance");
    }

    @Override
    public void confirmNotification(Transaction transaction)
    {
        transaction.setState(new CryptoTranfer());
    }

}

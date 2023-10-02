package ar.edu.unq.cryptop2p.model.state;

import ar.edu.unq.cryptop2p.model.Status;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.StateException;

public class CashTranfer extends State
{
    @Override
    public void transferNotification(Transaction transaction)
    {
        transaction.setState(new CashConfirmationer());
    }

    @Override
    public void confirmNotification(Transaction transaction) throws StateException
    {
        throw new StateException("Message confirmNotification() should not be sent to CashTranfer intance");
    }
}
package ar.edu.unq.cryptop2p.model.state;

import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.StateException;

public class Closed extends State
{
    @Override
    public void transferNotification(Transaction transaction) throws StateException
    {
        throw new StateException("Message transferNotification() should not be sent to Closed instance");
    }

    @Override
    public void confirmNotification(Transaction transaction) throws StateException
    {
        throw new StateException("Message confirmNotification() should not be sent to Closed instance");
    }

    @Override
    public void cancel(Transaction transaction) throws StateException
    {
        throw new StateException("Message cancel() should not be sent to Closed instance");
    }
}

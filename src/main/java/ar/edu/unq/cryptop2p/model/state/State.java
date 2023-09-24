package ar.edu.unq.cryptop2p.model.state;

import ar.edu.unq.cryptop2p.model.Status;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.exceptions.StateException;

public abstract class State {
    public abstract void transferNotification(Transaction transaction) throws StateException;
    public abstract void confirmNotification(Transaction transaction) throws StateException;
    public void cancel(Transaction transaction) throws StateException
    {
        transaction.setState(new Closed());
        transaction.setStatus(Status.cancelled);
    }
}

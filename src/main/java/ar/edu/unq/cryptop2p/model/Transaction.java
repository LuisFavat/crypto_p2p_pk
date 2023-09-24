package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.StateException;
import ar.edu.unq.cryptop2p.model.intention.Intention;
import ar.edu.unq.cryptop2p.model.state.State;

public class Transaction
{
    private Intention intention;
    private User interesed;
    private State state;
    private Status status;


    public Transaction (Intention intention, User interested, Status status, State state)
    {
        this.intention = intention;
        this.interesed = interested;
        this.state = state;
        this.status = status;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public void transferDone() throws StateException {
        state.transferNotification(this);
    }

    public void confirm() throws StateException
    {
        state.confirmNotification(this);
    }

    public void cancel() throws StateException
    {
        state.cancel(this);
    }


    public float operationAmountInPesos()
    {
        return  intention.amountOperationInUSD() * USD.getPrice();
    }
}

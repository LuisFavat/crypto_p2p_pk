package ar.model.builders;

import ar.edu.unq.cryptop2p.model.Status;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.User;
import ar.edu.unq.cryptop2p.model.intention.Intention;
import ar.edu.unq.cryptop2p.model.state.CashTranfer;
import ar.edu.unq.cryptop2p.model.state.State;

import static ar.model.builders.IntentionBuilder.anyIntention;
import static ar.model.factory.UserFactory.anyUser;

public class TransactionBuilder
{
    private Intention intention = anyIntention().build();
    private User user = anyUser();
    private State state = new CashTranfer();
    private Status status = Status.active;

    public TransactionBuilder() throws Exception {
    }

    public static TransactionBuilder aTransaction() throws Exception {
        return new TransactionBuilder();
    }

    public TransactionBuilder withIntention(Intention intention)
    {
        this.intention = intention;
        return this;
    }

    public TransactionBuilder withUser(User user)
    {
        this.user = user;
        return this;
    }

    public  TransactionBuilder withState(State state)
    {
        this.state = state;
        return  this;
    }

    public TransactionBuilder withStatus(Status status)
    {
        this.status = status;
        return this;
    }

    public Transaction build()
    {
        return new Transaction(intention, user, status, state);
    }
}

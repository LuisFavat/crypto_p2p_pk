package ar.model.builders;

import ar.edu.unq.cryptop2p.model.Status;
import ar.edu.unq.cryptop2p.model.Transaction;
import ar.edu.unq.cryptop2p.model.AppUser;
import ar.edu.unq.cryptop2p.model.intention.Intention;

import static ar.model.builders.IntentionBuilder.anyIntention;
import static ar.model.factory.UserFactory.anyUser;

public class TransactionBuilder
{
    private Intention intention = anyIntention().build();
    private AppUser appUser = anyUser();
    private Status status = Status.STEP_1_WAITING_CASH_TRANSFER_CONFIRMATION;
    //private LocalDateTime creationTime = LocalDateTime.now();

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

    public TransactionBuilder withInteresedUser(AppUser appUser)
    {
        this.appUser = appUser;
        return this;
    }

    /*
    public TransactionBuilder withCreationTime(LocalDateTime creationTime)
    {
        this.creationTime = creationTime;
        return this;
    }

     */

    public TransactionBuilder withStatus(Status status)
    {
        this.status = status;
        return this;
    }

    public Transaction build()
    {
        return new Transaction(intention, appUser, status);
    }
}

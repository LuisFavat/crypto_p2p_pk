package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.model.exceptions.StateException;
import ar.edu.unq.cryptop2p.model.intention.Intention;

import java.time.Duration;
import java.time.LocalDateTime;

public class Transaction
{
    private Intention intention;
    private AppUser interesed;
    private Status status;
    private LocalDateTime creationTime;
    private LocalDateTime finishTime;
    private float operatedAmountInPesos;



    public Transaction (Intention intention, AppUser interested, Status status)
    {
        this.intention = intention;
        this.interesed = interested;
        this.status = status;
        this.creationTime = LocalDateTime.now();
        System.out.println(creationTime);
        operatedAmountInPesos = setOperationAmountInPesos();
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public void notificationOfCashTransferred() throws StateException {
        //state.transferred();
        if(status != Status.STEP_1_WAITING_CASH_TRANSFER_CONFIRMATION)
        {
            throw new StateException("You try to send .cashTranferred() message in an inconsistent state of the transaction");
        }
        status = Status.STEP_2_WAITING_CRYPTO_TRANSFER_CONFIRMATION;
    }



    public void notificationOfCryptoTransfered() throws  StateException
    {
        if(status != Status.STEP_2_WAITING_CRYPTO_TRANSFER_CONFIRMATION)
        {
            throw new StateException("You try to send .cryptoTransfered() message in an inconsistent state of the transaction");
        }
        if(intention.isIntentionPriceOutsideMinAndMax())
        {
            status = Status.CANCELLED_BY_SYSTEM_PRICE_OUT_OF_RANGE;
        }
        else
        {
            finishTime = LocalDateTime.now();
            status = Status.SUCCESFUL;
            addPointsToUsers();
        }
    }


    private void addPointsToUsers()
    {
        var duration = Duration.between(creationTime, finishTime).toMinutes();
        interesed.addPointsAccordingToDuration(duration);
        intention.getUser().addPointsAccordingToDuration(duration);
    }
    private void cancel() throws StateException
    {
        if(status == Status.CANCELLED_BY_USER || status == Status.SUCCESFUL )
        {
            throw new StateException("You try to send .cancel() message in an inconsistent state of the transaction");
        }
        status = Status.CANCELLED_BY_USER;
    }

    private void punish(AppUser appUser)
    {
        appUser.punish();
    }

    public void cancelTransactionAndPunish(AppUser appUser) throws StateException {
        this.cancel();
        punish(appUser);
    }

    private float setOperationAmountInPesos()
    {
        return  intention.amountOperationInUSD() * USD.getPrice();
    }

    public float getOperatedAmountInPesos()
    {
        return operatedAmountInPesos;
    }
}

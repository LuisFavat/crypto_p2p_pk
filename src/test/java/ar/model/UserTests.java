package ar.model;

import org.junit.jupiter.api.Test;

import static ar.model.factory.TransactionFactory.anyTransaction;
import static ar.model.builders.UserBuilder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests
{
    @Test
    void if_the_creator_of_the_intention_cancels_the_transaction_the_numbers_of_operations_id_not_modifed_and_reputation_decrease() throws Exception {
        var operations = 1;
        var user = anyUser().withSuccesfulOperations(operations).build();
        var transaction = anyTransaction();

        transaction.cancelTransactionAndPunish(user);

        assertEquals(operations, user.getSuccesfulOperations());
    }

    @Test
    void if_a_user_cancel_a_transaction_the_reputation_decrease() throws Exception {

        var reputation = 20;
        var user = anyUser().withReputation(reputation).build();
        var transaction = anyTransaction();

        transaction.cancelTransactionAndPunish(user);

        assertEquals(0, user.getReputation());
    }


}

package ar.dataForTesting;

import ar.edu.unq.cryptop2p.model.AppUser;

public class DataGenerator {

    public void GenerateUsers() throws Exception {
        AppUser user1 =  new AppUser("Victor", "Hugo","Francia 123", "vicorh@gmail.com","VerySecret!","01234567890123456789","12345678",0,0,0);
        AppUser user2 =  new AppUser(" ", "Hugo","Francia 123", "vicorh@gmail.com","VerySecret!","01234567890123456789","12345678",0,0,0);
        AppUser user3 =  new AppUser("Victor", "Hugo","Francia 123", "vicorh@gmail.com","VerySecret!","01234567890123456789","12345678",0,0,0);
    }
}

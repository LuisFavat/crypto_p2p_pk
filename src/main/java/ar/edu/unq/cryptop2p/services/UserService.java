package ar.edu.unq.cryptop2p.services;

import ar.edu.unq.cryptop2p.DTOs.UserRegisterDTO;
import ar.edu.unq.cryptop2p.model.AppUser;
import ar.edu.unq.cryptop2p.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    UserRepository repository;
    public UserRegisterDTO register(UserRegisterDTO userData) throws Exception {
        AppUser user = userData.toObjectModel();
        repository.save(user);
        return  userData;

    }
}

package ar.edu.unq.cryptop2p.webservices;

import ar.edu.unq.cryptop2p.DTOs.UserRegisterDTO;
import ar.edu.unq.cryptop2p.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController
{
    @Autowired
    private UserService service;

    @PutMapping("/register")
    public ResponseEntity<UserRegisterDTO> register(@RequestBody UserRegisterDTO user)
    {
        UserRegisterDTO userRegister = null;
        try
        {
            userRegister = service.register(user);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(userRegister);
        }

        return ResponseEntity.ok().body(userRegister);

    }


}

package co.simplon.gestiontask.controller;

import co.simplon.gestiontask.dao.UserRepository;
import co.simplon.gestiontask.entities.AppUser;
import co.simplon.gestiontask.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController 
{
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountService accountService;
    
    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm userForm)
    {
        if(!userForm.getPassword().equals(userForm.getRepassword()))
            throw new RuntimeException("You must confirm your password");

            AppUser user = accountService.findUserByUsername(userForm.getUsername());
        
            if(user!=null) throw 
                new RuntimeException("This user already exists");
        
            AppUser appUser = new AppUser();
            appUser.setUsername(userForm.getUsername());
            appUser.setPassword(userForm.getPassword());
            accountService.saveUser(appUser);
            accountService.addRoleToUse(userForm.getUsername(),"USER");
        
            return appUser;
        
     }
    
     @PostMapping("/login")
     public void login(@RequestBody  AppUser user)
     {
         user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
         userRepository.save(user);
      }

}

package com.nbms.bank.service;

import com.nbms.bank.entitis.User;
import com.nbms.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository usr;

    public User save(User user){
        if(!validation(user))
        return null;
        if(checkExistUsername(user.getEmail()))
            return null;
        prepareUserForSave(user);

        return usr.save(user);
    }

    private void prepareUserForSave(User user) {
        user.setUserName(user.getEmail());
        user.setPassword(encryptPassword(user.getPassword()));
    }

    private String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public User update(User user){
        return usr.save(user);
    }
    public User login(User  user){
        Optional<User> loginuser = usr.findById(user.getId());
        return loginuser.orElse(null);
    }
    public boolean changePassword(User user , String pass){
        Optional<User> fuser = usr.findById(user.getId());
        if(fuser.isPresent()){
            fuser.get().setPassword(pass);
            return true;
        }
        return false;
    }
    private boolean validation(User user){
        if(user.getEmail().isEmpty() || user.getPassword().isEmpty()){
            return false;
        }
        return true;
    }
    private boolean checkExistUsername(String s){
        User byUserName = usr.findByUserName(s);
        return byUserName != null;
    }


}

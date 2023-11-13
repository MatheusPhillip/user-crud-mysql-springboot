package br.com.userregistrationwebapi.project.user;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private IUser repository;
    private PasswordEncoder passwordEncoder;

    public UserService(IUser repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<User> getUserList(){
        List<User> userList = repository.findAll();
        return userList;
    }

    public User createUser(User user){
        String passwordEncoded = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        User newUser = repository.save(user);
        return newUser;
    }

    public User updateUser(User user){
        String passwordEncoded = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        User updatedUser = repository.save(user);
        return updatedUser;
    }

    public Boolean deleteUserById(Integer userId){
        repository.deleteById(userId);
        return true;
    }

    public Boolean validatePassword(User user) {
        String password = repository.getReferenceById(user.getId()).getPassword();
        Boolean isValid = passwordEncoder.matches(user.getPassword(), password);
        return isValid;
    }
}

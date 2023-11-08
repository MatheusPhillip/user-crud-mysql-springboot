package br.com.userregistrationwebapi.project.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private IUser repository;

    public UserService(IUser repository){
        this.repository = repository;

    }

    public List<User> getUserList(){
        List<User> userList = repository.findAll();
        return userList;
    }

    public User createUser(User user){
        User newUser = repository.save(user);
        return newUser;
    }

    public User updateUser(User user){
        User updatedUser = repository.save(user);
        return updatedUser;
    }

    public Boolean deleteUserById(Integer userId){
        repository.deleteById(userId);
        return true;
    }
}

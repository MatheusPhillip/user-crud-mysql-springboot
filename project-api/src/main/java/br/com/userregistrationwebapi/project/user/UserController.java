package br.com.userregistrationwebapi.project.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController{
    
    @Autowired
    private IUser dao;

    @GetMapping
    public List<User> getUserList(){
        List<User> userList = (List<User>) dao.findAll();
        return userList;
    }
    
    @PostMapping
    public User createUser(@RequestBody User user) {
    	User newUser = dao.save(user);
    	return newUser;
    }
    
    @PutMapping
    public User upadteUser(@RequestBody User user) {
    	User newUser = dao.save(user);
    	return newUser;
    }
    
    @DeleteMapping("/{id}")
    public Optional<User> deleteUserById(@PathVariable Integer id) {
    	Optional<User> user = dao.findById(id);
    	dao.deleteById(id);
    	return user;
    }
}

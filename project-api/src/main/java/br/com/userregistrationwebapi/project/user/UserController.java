package br.com.userregistrationwebapi.project.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUserList(){
        List<User> userList = userService.getUserList();
        return ResponseEntity.status(200).body(userList);
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	User newUser = userService.createUser(user);
    	return ResponseEntity.status(201).body(newUser);
    }
    
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
    	User updatedUser = userService.updateUser(user);
    	return ResponseEntity.status(200).body(updatedUser);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id) {
    	userService.deleteUserById(id);
    	return ResponseEntity.status(204).build();
    }
    @PostMapping("/login")
    public ResponseEntity<User> validatePassword(@RequestBody User user){
        Boolean passwordIsValid = userService.validatePassword(user);
        if(!passwordIsValid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        else{
            return ResponseEntity.status(200).build();
        }
    }

}

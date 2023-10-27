package br.com.userregistrationwebapi.project.user;

import org.springframework.data.repository.CrudRepository;

public interface IUser extends CrudRepository<User, Integer>{
    
}

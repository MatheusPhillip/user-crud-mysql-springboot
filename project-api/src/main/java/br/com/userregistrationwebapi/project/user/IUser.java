package br.com.userregistrationwebapi.project.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, Integer>{
    
}

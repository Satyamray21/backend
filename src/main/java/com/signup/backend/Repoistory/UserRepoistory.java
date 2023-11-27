package com.signup.backend.Repoistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signup.backend.Model.UserModel;

@Repository
public interface UserRepoistory extends JpaRepository<UserModel,Integer > {
    Optional<UserModel> findByUsernameAndPassword(String username,String password);

}

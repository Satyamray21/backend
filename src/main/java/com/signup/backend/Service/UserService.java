package com.signup.backend.Service;

import org.springframework.stereotype.Service;

import com.signup.backend.Model.UserModel;
import com.signup.backend.Repoistory.UserRepoistory;

@Service
public class UserService {
    private final UserRepoistory userRepoistory;

    public UserService(UserRepoistory userRepoistory) {
        this.userRepoistory = userRepoistory;
    }
public UserModel registerUser(String username,String password,String email,String fname,String sname,String phone){
    if (username== null || password == null || username.isEmpty() || password.isEmpty()) {
        throw new IllegalArgumentException("Username and password cannot be null or empty.");
    
    }else{
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setFname(fname);
         userModel.setSname(sname);
       userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone(phone);
        return userRepoistory.save(userModel);
    }
}
public UserModel authenticate(String username,String password)
{
    return userRepoistory.findByUsernameAndPassword(username,password).orElse(null);

}

}

    


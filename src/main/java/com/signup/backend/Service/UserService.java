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
public UserModel registerUser(String username,String fname,String sname,String password,String email,String phone){
    if (username== null || password == null || username.isEmpty() || password.isEmpty()) {
        throw new IllegalArgumentException("Username and password cannot be null or empty.");
    
    }else{
        UserModel userModel = new UserModel();
        userModel.setEmail(email);
        userModel.setFname(fname);
        userModel.setSname(sname);
        userModel.setPassword(password);
        userModel.setUsername(username);
        userModel.setPhone(phone);
        return userRepoistory.save(userModel);
    }
}
public UserModel authenticate(String username,String password)
{
    return userRepoistory.findByUsernameAndPassword(username,password).orElse(null);

}

}

    


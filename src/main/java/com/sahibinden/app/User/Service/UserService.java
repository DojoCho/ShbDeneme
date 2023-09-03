package com.sahibinden.app.User.Service;

import com.sahibinden.app.User.Dto.Request.UserLoginDto;
import com.sahibinden.app.User.Dto.Request.UserRegisterDto;
import com.sahibinden.app.User.Model.User;
import com.sahibinden.app.User.Repository.UserRepo;
import com.sahibinden.app.Utils.BaseResponse;
import com.sahibinden.app.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public BaseResponse<User> Login(UserLoginDto userLoginDto){
        if (!Utils.emailValidate(userLoginDto.getEmail()))
        {
            return new BaseResponse<>(false,"Email incorrect", null);
        }
        List<User> checkUser = userRepo.login(userLoginDto.getEmail(),userLoginDto.getPassword());
        if(checkUser.size() <= 0)
        {
            return new BaseResponse<>(false,"User not found", null);
        }
        return new BaseResponse<>(true,"", checkUser.get(0));
    }


    public BaseResponse<User> Register(UserRegisterDto userRegisterDto){
        if (!Utils.emailValidate(userRegisterDto.getEmail()))
        {
            return new BaseResponse<>(false,"Email incorrect", null);
        }
        List<User> checkUser = userRepo.checkByEmail(userRegisterDto.getEmail());
        if (checkUser.size() > 0)
        {
            return new BaseResponse<>(false,"User already exist", null);
        }
        User newUser = new User();
        newUser.setEmail(userRegisterDto.getEmail());
        newUser.setName(userRegisterDto.getName());
        newUser.setPassword(userRegisterDto.getPassword());
        newUser.setPhone(userRegisterDto.getPhone());

        userRepo.save(newUser);
        return new BaseResponse<>(true, "", newUser);

    }
}

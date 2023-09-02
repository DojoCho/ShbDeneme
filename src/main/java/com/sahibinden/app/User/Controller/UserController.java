package com.sahibinden.app.User.Controller;

import com.sahibinden.app.User.Dto.Request.UserLoginDto;
import com.sahibinden.app.User.Dto.Request.UserRegisterDto;
import com.sahibinden.app.User.Model.User;
import com.sahibinden.app.User.Service.UserService;
import com.sahibinden.app.Utils.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "User Controller", description = "User Controller")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public BaseResponse<User> Login(@RequestBody UserLoginDto userLoginDto){
        return userService.Login(userLoginDto);
    }

    @PostMapping("/register")
    public BaseResponse<User> Register(@RequestBody UserRegisterDto userRegisterDto){
        return userService.Register(userRegisterDto);
    }

}

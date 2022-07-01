package com.eno.baozi.wenjuan.controller;


import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api/login")
@Api(value = "login", description="登陆")
public class LoginController {
    private  final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    IUserService userService;

    @ApiOperation(value = "民警登陆，获取token信息等", notes = "民警登陆，获取token信息等")
    @PostMapping("/login")
    @ResponseBody
    public ResponseDTO<UserLoginInfo> login(@RequestBody LoginDTO loginDTO ){
        logger.info("login info:"+loginDTO.toString());
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            UserLoginInfo userLoginInfo =  userService.login(loginDTO);
        responseDTO.setData(userLoginInfo);
        responseDTO.setCode(20000);
        return responseDTO;

        }catch(Exception e){
            responseDTO.setMessage(e.getMessage());
            responseDTO.setCode(20001);
        }
        return responseDTO;
    }


    @ApiOperation(value = "犯人登陆", notes = "犯人登陆，获取token信息等")
    @PostMapping("/loginForCriminal")
    @ResponseBody
    public ResponseDTO<UserLoginInfo> loginForCriminal(@RequestBody CriminalLoginDTO loginDTO ){
        logger.info("login info:"+loginDTO.toString());
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            UserLoginInfo userLoginInfo =  userService.loginForCriminal(loginDTO);
            responseDTO.setData(userLoginInfo);
            responseDTO.setCode(20000);
            return responseDTO;

        }catch(Exception e){
            if ("20001".equals(e.getMessage())){
                responseDTO.setMessage("用户不存在");
                responseDTO.setCode(20001);
            }else{
                responseDTO.setMessage(e.getMessage());
                responseDTO.setCode(30001);
            }

        }
        return responseDTO;
    }


    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @GetMapping("/getUserInfo")
    @ResponseBody
    public ResponseDTO<LoginUserInfo> getUserInfo(@RequestParam Map<String, String> params, @RequestHeader("X-Token") String token){
        logger.info("login info:"+params.toString());
        logger.info("login token:"+token);
        LoginUserInfo loginUserInfo = new LoginUserInfo();

        LoginUserInfo userLoginInfo =  userService.queryUserInfo(params.get("token"));
        loginUserInfo.setRoles(new String[]{"editor"});
        loginUserInfo.setName(userLoginInfo.getName());
        loginUserInfo.setIntroduction("");
        loginUserInfo.setAvatar("");

//
//        loginUserInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//        loginUserInfo.setIntroduction("this is a test");
//        loginUserInfo.setName("江高生");
        loginUserInfo.setCode(params.get("token"));
        loginUserInfo.setRoles(new String[]{"editor"});

        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setData(userLoginInfo);
        responseDTO.setData(loginUserInfo);
        responseDTO.setCode(20000);
        return responseDTO;
    }

}

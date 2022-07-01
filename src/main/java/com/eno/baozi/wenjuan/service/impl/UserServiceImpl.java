package com.eno.baozi.wenjuan.service.impl;

import com.eno.baozi.wenjuan.common.domain.BusinessException;
import com.eno.baozi.wenjuan.dao.PoliceMapper;
import com.eno.baozi.wenjuan.dao.UnitsMapper;
import com.eno.baozi.wenjuan.dao.UserInfoDetailMapper;
import com.eno.baozi.wenjuan.dao.UserInfoMapper;
import com.eno.baozi.wenjuan.domain.*;
import com.eno.baozi.wenjuan.service.IBasicService;
import com.eno.baozi.wenjuan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceImpl implements IUserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserInfoDetailMapper userInfoDetailMapper;

    @Autowired
    PoliceMapper policeMapper;

    @Autowired
    UnitsMapper unitsMapper;

    @Autowired
    IBasicService basicService;
    //民警登陆
    @Override
    public UserLoginInfo login(LoginDTO loginDTO) {
        String no = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        UserLoginInfo userLoginInfo = new UserLoginInfo();


        //先从犯人中查
        UserInfo userInfo= userInfoMapper.selectByPrimaryKey(no);
        if (userInfo != null){
            if (!"123456".equals(password)){
                throw new BusinessException("用户名或密码错误");
            }
            userLoginInfo.setUserName(userInfo.getName());
            userLoginInfo.setToken(no);
            userLoginInfo.setNo(no);
            userLoginInfo.setRole("editor");
        } else{
            //登陆的编号对应police中的name字段
            Police police = policeMapper.selectByName(no);
            if (police  != null && password.equals(police.getPassword())){
                userLoginInfo.setUserName(police.getTrueName());
                userLoginInfo.setToken(no);
                userLoginInfo.setNo(no);
                userLoginInfo.setRole("admin");
            }else{
                throw new BusinessException("用户名或密码错误");
            }
        }


        return userLoginInfo;
    }

    //犯人登陆
    @Override
    public UserLoginInfo loginForCriminal(CriminalLoginDTO loginDTO) throws Exception {
        //如不存在直接返回不存在，
        String no = loginDTO.getNo();
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        //先从犯人中查
        UserInfo userInfo= userInfoMapper.selectByPrimaryKey(no);
        if (userInfo != null){
            userLoginInfo.setUserName(userInfo.getName());
            userLoginInfo.setToken(no);
            userLoginInfo.setNo(no);
            userLoginInfo.setRole("editor");
        }else{
            //不存在则返回提示
            throw new Exception("20001");
        }
        return userLoginInfo;
    }


    @Override
    public LoginUserInfo queryUserInfo(String no){
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        //先从犯人中查
        UserInfo userInfo= userInfoMapper.selectByPrimaryKey(no);
        if (userInfo != null){
            loginUserInfo.setIntroduction("");
            loginUserInfo.setName(userInfo.getName());
            loginUserInfo.setCode(no);
            loginUserInfo.setRoles(new String[]{"editor"});
            loginUserInfo.setRole("editor");
        } else{
            //登陆的编号对应police中的name字段
            Police police = policeMapper.selectByName(no);
            if (police  != null){
                loginUserInfo.setCode(no);
                loginUserInfo.setRole("admin");
                loginUserInfo.setRoles(new String[]{"admin"});
                loginUserInfo.setName(police.getTrueName());
            }
        }


//        if ("admin".equals(no)){
//            loginUserInfo.setIntroduction("管理员");
//            loginUserInfo.setName("管理员");
//            loginUserInfo.setRoles(new String[]{"admin"});
//            loginUserInfo.setCode(20000);
//
//        }else{
//            UserInfo userInfo= userInfoMapper.selectByPrimaryKey(no);
//            if (userInfo == null){
//                throw new BusinessException("用户不存在");
//            }
//            loginUserInfo.setIntroduction("this is a test");
//            loginUserInfo.setName(userInfo.getName());
//            loginUserInfo.setCode(20000);
//            loginUserInfo.setRoles(new String[]{"editor"});
//        }

        return loginUserInfo;
    }

    @Override
    public PoliceInfo queryPoliceInfo(String no) {
        Police police = policeMapper.selectByName(no);
        PoliceInfo policeInfo = new PoliceInfo();
        policeInfo.setTrueName(police.getTrueName());
        Units unit = unitsMapper.selectByPrimaryKey(police.getUnitId());
        policeInfo.setPrisonName(unit.getPrisonName());
        policeInfo.setPrisonNo(unit.getId()+"");
        List<PrisonBigGroupInfo> bigGroupList = basicService.queryBigGroupInfoByPoliceNo(no);
        if (bigGroupList != null && bigGroupList.size() == 1){
            PrisonBigGroupInfo prisonBigGroupInfo = bigGroupList.get(0);
            policeInfo.setBigGroupName(prisonBigGroupInfo.getName());
            policeInfo.setBigGroupNo(prisonBigGroupInfo.getNo());
            List<PrisonGroupInfo> prisonGroupInfoList = basicService.queryGroupInfoByPoliceNo(no);
            if (prisonGroupInfoList !=null  && prisonGroupInfoList.size() == 1){
                PrisonGroupInfo prisonGroupInfo = prisonGroupInfoList.get(0);
                policeInfo.setGroupName(prisonGroupInfo.getName());
                policeInfo.setGroupNo(prisonGroupInfo.getNo());
            }
        }
        return policeInfo;
    }

}

package com.eno.baozi.wenjuan.service;

import com.eno.baozi.wenjuan.domain.*;

public interface IUserService {
    UserLoginInfo login(LoginDTO loginDTO);
    LoginUserInfo queryUserInfo(String no);

    PoliceInfo queryPoliceInfo(String no );

    UserLoginInfo loginForCriminal(CriminalLoginDTO loginDTO) throws Exception;

}

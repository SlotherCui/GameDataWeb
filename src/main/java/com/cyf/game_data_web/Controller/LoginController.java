package com.cyf.game_data_web.Controller;

import com.cyf.game_data_web.VO.ResultVO;
import com.cyf.game_data_web.VO.ResultVOUtil;
import com.cyf.game_data_web.request.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private static final String keyword = "123456";

    @PostMapping(value = "/login1")//, produces="application/json;charset=utf-8"
    @ResponseBody
    public ResultVO<String> Login(@RequestBody LoginRequest password){
        System.out.println(password);
        if (keyword.equals(password.getPassword())){
            return ResultVOUtil.success();
        }else{
            return ResultVOUtil.error(101,"wrong password");
        }
    }
}

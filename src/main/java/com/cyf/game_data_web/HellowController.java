package com.cyf.game_data_web;


import com.cyf.game_data_web.VO.ResultVO;
import com.cyf.game_data_web.VO.ResultVOUtil;
import com.cyf.game_data_web.dataobject.GameDataIntegration;
import com.cyf.game_data_web.repository.*;
import com.cyf.game_data_web.service.GameDataService;
import com.cyf.game_data_web.service.GameSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class HellowController {

    @Autowired
    private GameDataService gameDataService;

    @Autowired
    private GameSearchRepository gameSearchRepository;
    @Autowired
    private GameDataSteamRepository gameDataRepository;

    @Autowired
    private GobleLRU lru;

    @GetMapping("/say")
    public String say(){

//        return gameSearchRepository.findGameDataByYouMinDesc("世界 -庞大 +血腥 统治", 0).toString();
//        return gameDataRepository.findByGameLink("https://store.steampowered.com/app/396420/_/?snr=1_7_7_230_150_1&l=schinese").toString();
        if(lru.get("test")==null){
            lru.set("test","123497");
            return "无缓存";
        }else{
            return lru.get("test");
        }

    }


    @GetMapping("/say2")
    public ResultVO<List<GameDataIntegration>> say2(Integer page, HttpServletRequest httpServletrequest){

        Cookie[] cookies =  httpServletrequest.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies) {
                System.out.println(cookie.getValue());
            }
        }
        System.out.println(page);
        Pageable pageable = new PageRequest(page,10, Sort.Direction.ASC,"_Id");
        Page<GameDataIntegration> page_able = gameDataService.findAll(pageable);

        return ResultVOUtil.success(page_able.getContent());
    }



    @PostMapping("/login")
    public ResultVO<String> loginSuccess(HttpServletResponse response)
    {
        Cookie cookie=new Cookie("sessionId","zyc");
        response.addCookie(cookie);
        return ResultVOUtil.success("goodman2");
    }

    @GetMapping("/cookie")
    public ResultVO<String> testCookie(HttpServletRequest request){
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("sessionId")){
                    System.out.println(cookie.getValue());
                }
            }
        }
        return ResultVOUtil.success();
    }
//    @GetMapping("/say2")
//    public String say2(){
//
//        return categoryService.findByCategoryIn(Arrays.asList(1,2)).toString();
//    }
//    @GetMapping("/say3")
//    public String say3(){
//
//        return categoryService.save(new ProductCategory("fsdaf",1)).toString();
//    }


}

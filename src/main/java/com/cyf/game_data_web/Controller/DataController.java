package com.cyf.game_data_web.Controller;

import com.cyf.game_data_web.Utils.CsvUtil;
import com.cyf.game_data_web.dataobject.GameDataIntegration;
import com.cyf.game_data_web.repository.GameSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

// 用于测试简单的数据下载
@Controller
public class DataController {

    @Autowired
    private GameSearchRepository gameSearchRepository;

    @GetMapping("/GetData")
    public ResponseEntity<byte[]> getDataFile() throws Exception {
        // 文件名
        String filename = "download.csv";  // 修改


        // 将查询结果保存为csv格式，并输出为数据流
        List<GameDataIntegration> list = gameSearchRepository.findGameDataByYouMinDesc("世界 -庞大 +血腥 统治", 0);  // 修改


        // 固定代码不需要修改，提示浏览器下载
        ByteArrayOutputStream baos = new CsvUtil().process(list);
        baos.close();
        HttpHeaders headers = new HttpHeaders();
        String downloadFielName = new String(filename.getBytes("UTF-8"),"UTF-8");
        headers.setContentDispositionFormData("attachment", downloadFielName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }
}

package com.cyf.game_data_web.Utils;

import com.csvreader.CsvWriter;
import com.cyf.game_data_web.dataobject.GameDataIntegration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;


public class CsvUtil {
    /**
     * 将数据写出csv格式，并转化成数据流
     * @param datalist
     * @return
     * @throws IOException
     */
    public ByteArrayOutputStream process(List<GameDataIntegration> datalist)throws IOException {

        // 创建CsvWriter对象
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        CsvWriter csvWriter = new CsvWriter(output, ',', Charset.forName("UTF-8"));

        // 设置csv文件头字段
        String[] tableheader = {"_Id", "GameName"};   // 修改
        csvWriter.writeRecord(tableheader);

        // 写入数据
        for (GameDataIntegration data : datalist) {
            csvWriter.writeRecord(this.getData(data));
        }
        // 关闭输出流
        csvWriter.close();
        output.close();
        return output;
    }

    /**
     * 修改
     * 转化数据对象为字符串数组
     * @param data
     * @return
     */
    public String[] getData(GameDataIntegration data){
        String[]strings = new String[2];

        strings[0] = data.get_Id();
        strings[1] = data.getGameName();
        return  strings;
     }

}

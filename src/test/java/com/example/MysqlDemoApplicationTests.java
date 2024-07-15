package com.example;

import com.alibaba.fastjson2.JSON;
import com.example.entity.TestData;
import com.example.entity.User;
import com.example.mapper.TestMapper;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = "com.example.mapper")
class MysqlDemoApplicationTests {

    @Autowired
    private TestMapper testMapper;

    @Test
    void contextLoads() {
        for(int i = 1;i<500000;i++){
            User user = new User();
            user.setId(i);
            user.setName("hutuya"+i);
            user.setEmail(i+"@qq.com");
            String jsonString = JSON.toJSONString(user);

            TestData testData = new TestData();
            testData.setId(i);
            testData.setData(jsonString);
            testMapper.insert(testData);
        }

    }

}

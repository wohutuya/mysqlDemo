package com.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.entity.TestData;
import com.example.mapper.TestMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestMapper testMapper;

    public TestController(TestMapper testMapper)
    {
        this.testMapper = testMapper;
    }

    //查询某一条数据
    @GetMapping("/getByid")
    public String get(int id)
    {
        LambdaQueryWrapper<TestData> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TestData::getId, id);
        TestData testData = testMapper.selectOne(lambdaQueryWrapper);

        String data = testData.getData();
        JSONObject jsonObject = JSON.parseObject(data);

        return "邮箱为："+jsonObject.getString("email");
    }

    @GetMapping("/getAll")
    public String getAll()
    {
        return "testMapper.selectList(null).toString()";
    }

}

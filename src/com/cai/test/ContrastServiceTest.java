package com.cai.test;

import com.cai.io.FileFunction;
import com.cai.service.ContrastService;
import com.cai.service.ContrastService_1;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author caiyifan
 * @Date 2022/9/26
 */

public class ContrastServiceTest {
    ContrastService contrastService=new ContrastService_1();

    @Test
    public void test(){
        FileFunction fileFunction=new FileFunction();
        Map<Integer,String>map1=fileFunction.readFile("Answer.txt");
        Map<Integer,String>map2=fileFunction.readFile("Answer.txt");
        List<List<Integer>> result=contrastService.getTitle(map1,map2);
        Assert.assertEquals(true,result.get(1).isEmpty());
    }

    @Test
    public void test1() throws IOException{
        contrastService.writeResult("Exercise.txt","Answer.txt");
    }
}

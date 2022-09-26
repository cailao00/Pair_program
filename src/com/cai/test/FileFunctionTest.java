package com.cai.test;

import com.cai.io.FileFunction;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @Author caiyifan
 * @Date 2022/9/26
 */
public class FileFunctionTest {

    @Test
    public void test1() throws IOException {
        StringBuilder context=new StringBuilder();
        context.append("你好");
        new FileFunction().saveFile("Hello.txt",context);
    }

    @Test
    public void test2(){
        Map<Integer,String>context=new FileFunction().readFile("Answer.txt");
        System.out.println(context);
    }
}

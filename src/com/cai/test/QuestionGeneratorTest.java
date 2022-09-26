package com.cai.test;

import org.junit.Test;

import java.io.IOException;
import com.cai.generator.QuestionsGenerator;

/**
 * @Author caiyifan
 * @Date 2022/9/26
 */
public class QuestionGeneratorTest {

    @Test
    public void test1()throws IOException{
        QuestionsGenerator generator=new QuestionsGenerator();
        generator.getQuestions(10,10);
    }
}

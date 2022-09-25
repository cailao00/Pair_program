package com.cai.generator;

import com.cai.fraction.Fraction;
import com.cai.service.Caculation;
import com.cai.service.Caculation_1;
import com.cai.service.DigitalProcessing;
import com.cai.service.DigitalProcessing_1;

import java.util.ArrayList;
import java.util.List;

public class QuestionsGenerator {
    public void getQuestions(int count,int number){
        DigitalProcessing digitalProcessing = new DigitalProcessing_1();
        Caculation caculation = new Caculation_1();
        //FileFunction file = new FileFunction();
        int temp = 1;
        Fraction answer = null;
        StringBuilder context = new StringBuilder();
        StringBuilder result = new StringBuilder();
        while(temp < count){    //题目生成数
            int flag = 0;       //是否有左括号 0：无左括号 1：有左括号 2：有右括号
            int flag_1 = 0;     //左括号的位置下标
            String question = ""; //算式
            int symbolNum = (int)(Math.random() * 3 + 1);   //运算符的数目
            List<Fraction> list = new ArrayList();  //存放表达式
            for(int i = 1;i <= symbolNum * 2 + 1;i++) {
                Fraction operation = new Fraction();    //数字 符号
                Fraction symbolOperation = new Fraction();  //括号
                if (i % 2 == 0) {   //运算符的位置
                    String symbol = digitalProcessing.getSymbol();
                    operation.setSymbol(symbol);
                    question = question + " " + symbol;
                } else {
                    if (i < symbolNum * 2 - 2 && flag == 0) {   //左括号出现的位置范围，及出现的条件
                        int flag_2 = (int) (Math.random() * 2); //随机出现左括号
                        if (flag_2 == 0) {
                            String symbol = "(";
                            symbolOperation.setSymbol(symbol);
                            question = question + " " + symbol;
                            flag = 1;
                            flag_1 = i;
                            list.add(symbolOperation);
                        }
                        list.add(operation);
                    }
                    operation = digitalProcessing.getRandomNum(number); //算式加入随机数
                    question = question + " " + digitalProcessing.getCanonicalFormat(operation);
                }
                list.add(operation);
                if (i == flag_1 + 2 && flag == 1) { //右括号出现的位置范围，及出现的条件
                    String symbol = ")";
                    symbolOperation.setSymbol(symbol);
                    question = question + " " + symbol;
                    flag = 2;
                    list.add(symbolOperation);
                }
            }
            try {
                answer = caculation.result(list);
            } catch (Exception e) {
                continue;
            }
            question = temp + "." + question + "=";
            context.append(question + System.lineSeparator());
            result.append(temp + "." + digitalProcessing.getCanonicalFormat(answer) + System.lineSeparator());
            temp++;
        }
        //file.save("Execrise.txt",context);
        //file.save("Answer.txt",result);
    }
}

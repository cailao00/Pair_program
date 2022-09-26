package com.cai.test;

import com.cai.fraction.Fraction;
import com.cai.service.Caculation;
import com.cai.service.Caculation_1;
import com.cai.service.DigitalProcessing;
import com.cai.service.DigitalProcessing_1;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author caiyifan
 * @Date 2022/9/26
 */
public class CalculateTest {
    private Caculation caculation =new Caculation_1();
    List<Fraction> list =new ArrayList<>();

    @Test
    public void test(){
        Fraction fraction1=new Fraction();
        fraction1.setMolecule(30);
        fraction1.setDenominator(10);
        Fraction fraction3=new Fraction();
        fraction3.setMolecule(10);
        fraction3.setDenominator(20);
        Fraction fraction2=new Fraction();
        fraction2.setSymbol("×");
        list.add(fraction1);
        list.add(fraction2);
        list.add(fraction3);
        Fraction result =caculation.result(list);
        String answer =new DigitalProcessing_1().getCanonicalFormat(result);
        System.out.println("计算结果"+answer);
    }

    @Test
    public void test1(){
        Fraction fraction=new Fraction();
        fraction.setSymbol("×");
        int i=caculation.priority(fraction);
        Assert.assertEquals(2,i);   //判断2==i?正常运行:报异常
    }

    @Test
    public void test2(){
        Fraction fraction1=new Fraction();
        fraction1.setMolecule(30);
        fraction1.setDenominator(10);
        Fraction fraction3=new Fraction();
        fraction3.setMolecule(30);
        fraction3.setDenominator(10);
        Fraction fraction2=new Fraction();
        fraction2.setSymbol("+");
        list.add(fraction1);
        list.add(fraction2);
        list.add(fraction3);
        List<Fraction> list1=caculation.listSuffix(this.list);
        Assert.assertEquals("[3, 3, +]",list1.toString());
    }

    @Test
    public void test3(){
        Fraction fraction1=new Fraction();
        fraction1.setMolecule(30);
        fraction1.setDenominator(10);
        Fraction fraction2=new Fraction();
        fraction2.setMolecule(10);
        fraction2.setDenominator(20);
        Fraction fraction=caculation.caculateResult(fraction1,fraction2,"÷");
        Assert.assertEquals(6,Integer.parseInt(fraction.toString()));
    }
}

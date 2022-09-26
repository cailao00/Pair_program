package com.cai.test;

        import com.cai.fraction.Fraction;
        import com.cai.service.DigitalProcessing;
        import com.cai.service.DigitalProcessing_1;
        import org.junit.Assert;
        import org.junit.Test;

        import java.io.File;
        import java.util.HashMap;
        import java.util.Map;

/**
 * @Author caiyifan
 * @Date 2022/9/26
 */

public class DigitalProcessingTest {
    private DigitalProcessing digitalProcessing =new DigitalProcessing_1();

    @Test
    public void test1(){
        Fraction number=digitalProcessing.getRandomNum(10);
        System.out.println(number);
    }

    @Test
    public void test2(){
        int i=0;
        while (i<100){
            Fraction number=digitalProcessing.getRandomNum(10);
            int commonMeasure=digitalProcessing.getGreatestCommonDivisor(number.getMolecule(), number.getDenominator());
            System.out.println(number.getMolecule()+" "+number.getDenominator()+" "+commonMeasure);
            i++;
        }
    }

    @Test
    public void test3(){
        Fraction fraction=new Fraction();
        fraction.setDenominator(4);
        fraction.setMolecule(9);
        String properFraction=digitalProcessing.getCanonicalFormat(fraction);
        Assert.assertEquals("2'1/4",properFraction);
    }

    @Test
    public void test4(){
        String symbol =digitalProcessing.getSymbol();
        Map<String,Integer> map=new HashMap<>();
        map.put("+",0);
        map.put("-", 1);
        map.put("×", 2);
        map.put("÷", 3);
        Assert.assertEquals(true,map.containsKey(symbol));
    }
}

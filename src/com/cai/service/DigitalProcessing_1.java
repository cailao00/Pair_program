package com.cai.service;

import com.cai.fraction.Fraction;

/**
 * @Author cai zefeng
 * @date 2022/9/25
 */

public class DigitalProcessing_1 implements DigitalProcessing{
    @Override
    public int getGreatestCommonDivisor(int molecule, int denominator) {    //求最大公约数
        if (molecule == 0){
            return 1;
        }
        while(true){
            if((molecule = molecule % denominator) == 0){
                return denominator;
            }
            else if ((denominator = denominator % molecule) == 0){
                return molecule;
            }
        }
    }

    @Override
    public String getCanonicalFormat(Fraction fraction) {   //规范分数格式
        if(fraction.getMolecule() == 0){
            return 0 + " ";
        }
        int GreatestCommonDivisor = getGreatestCommonDivisor(fraction.getMolecule(),fraction.getDenominator()); //获得最大公约数
        fraction.setMolecule(fraction.getMolecule() / GreatestCommonDivisor);       //分子分母除以最大公约数，进行化简
        fraction.setDenominator(fraction.getDenominator() / GreatestCommonDivisor);
        if(fraction.getMolecule() >= fraction.getDenominator()){    //假分数
            int quotient = fraction.getMolecule() / fraction.getDenominator();  //化简后的整数部分
            int remainder = fraction.getMolecule() % fraction.getDenominator(); //化简后的分子部分
            if(remainder == 0){
                return quotient + " ";
            }
            return quotient + "'" + remainder + "/" + fraction.getDenominator();
        }
        return fraction.getMolecule() + "/" + fraction.getDenominator();
    }

    @Override
    public Fraction getRandomNum(int number) {
        Fraction fraction = new Fraction();
        fraction.setMolecule((int)(0 + Math.random() * (number)));        //分子随机生成一个数
        fraction.setDenominator((int)(1 + Math.random() * (number - 1))); //分母随机生成一个数
        return fraction;
    }

    @Override
    public String getSymbol() {     //随机生成符号
        String symbol = "";
        int symbolNum = (int)(Math.random() * 4);
        switch (symbolNum){
            case 0:
                symbol = "+";
                break;
            case 1:
                symbol = "-";
                break;
            case 2:
                symbol = "×";
                break;
            case 3:
                symbol = "÷";
                break;
            default:
                System.out.println("获取符号失败");
        }
        return symbol;
    }
}

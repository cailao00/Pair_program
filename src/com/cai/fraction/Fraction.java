package com.cai.fraction;

/**
 * @Author cai zefeng
 * @date 2022/9/23 21:50
 *
 * element -> molecule
 */

public class Fraction {
    private int molecule;       //分子
    private int denominator;    //分母
    private String symbol;      //符号

    Fraction(){

    }

    public int getMolecule() {
        return molecule;
    }

    public void setMolecule(int molecule) {
        this.molecule = molecule;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    //分数加法
    public Fraction addition(Fraction num_1,Fraction num_2){
        Fraction result = new Fraction();
        result.setMolecule(num_1.getMolecule() * num_2.getDenominator() + num_2.getMolecule() * num_1.getDenominator());    //分子做加法
        result.setDenominator(num_1.getDenominator() * num_2.getDenominator()); //分母做加法
        return result;
    }

    //分数减法
    public Fraction subtraction(Fraction num_1,Fraction num_2){
        Fraction result = new Fraction();
        if((num_1.getMolecule() * num_2.getDenominator() - num_2.getMolecule() * num_1.getDenominator()) < 0){
            throw new RuntimeException("运算结果不能为负数!");
        }
        result.setMolecule(num_1.getMolecule() * num_2.getDenominator() - num_2.getMolecule() * num_1.getDenominator());    //分子做减法
        result.setDenominator(num_1.getDenominator() * num_2.getDenominator()); //分母做减法
        return result;
    }

    //分数乘法
    public Fraction multiplication(Fraction num_1,Fraction num_2){
        Fraction result = new Fraction();
        result.setMolecule(num_1.getMolecule() * num_2.getMolecule());  //分子做乘法
        result.setDenominator(num_1.getDenominator() * num_2.getDenominator()); //分母做乘法
        return result;
    }

    //分数除法
    public Fraction division(Fraction num_1,Fraction num_2){
        Fraction result = new Fraction();
        if(num_2.getMolecule() == 0){
            throw new RuntimeException("除数不能为零");
        }
        result.setMolecule(num_1.getMolecule() * num_2.getDenominator());   //分子做除法
        result.setDenominator(num_1.getDenominator() * num_2.getMolecule());//分母做除法
        return result;
    }

    //重写toString方法
    @Override
    public String toString() {
        if(symbol != null){
            return symbol;
        }
        else if(molecule == 0){
            return "0";
        }
        else if(molecule % denominator == 0){
            return molecule / denominator + " ";    //取整数部分
        }
        else {
            return molecule + "/" + denominator;
        }
    }
}

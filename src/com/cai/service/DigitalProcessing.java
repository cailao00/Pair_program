package com.cai.service;

import com.cai.fraction.Fraction;

/**
 * @Author cai zefeng
 * @date 2022/9/24
 *
 * getCommonMeasure -> getGreatestCommonDivisor
 * getProperFraction -> getCanonicalFormat
 * getNumber -> getRandomNum
 */

public interface DigitalProcessing {
    //求最大公约数
    int getGreatestCommonDivisor(int molecule,int denominator);
    //规范格式
    String getCanonicalFormat(Fraction fraction);
    //得到随机数
    Fraction getRandomNum(int number);
    //得到运算符
    String getSymbol();
}

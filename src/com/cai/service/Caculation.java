package com.cai.service;

import com.cai.fraction.Fraction;

import java.util.List;

/**
 * @Author cai zefeng
 * @date 2022/9/24
 *
 * calculate -> listSuffixResult
 * calculateNum -> caculateResult
 * getResult -> result
 */

public interface Caculation {
    //运算符优先级
    int priority(Fraction symbol);

    //求运算式通过逆波兰表达式而形成的后缀表达式
    List<Fraction> listSuffix(List<Fraction> list);

    //求后缀表达式的结果
    Fraction listSuffixResult(List<Fraction> list);

    //计算四则运算的结果
    Fraction caculateResult(Fraction num_1,Fraction num_2,String symbol);

    //计算式的最终结果
    Fraction result(List<Fraction> list);
}

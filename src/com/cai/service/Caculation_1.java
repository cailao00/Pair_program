package com.cai.service;

import com.cai.fraction.Fraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author cai zefeng
 * @date 2022/9/24
 *
 */

public class Caculation_1 implements Caculation{
    @Override
    public int priority(Fraction symbol) {      //设定符号的优先级
        switch (symbol.getSymbol()){
            case "+":
            case "-":
                return 1;
            case "×":
            case "÷":
                return 2;
        }
        throw new RuntimeException(symbol + "不是运算符");
    }

    @Override
    public List<Fraction> listSuffix(List<Fraction> list) {     //逆波兰表达式算法求出后缀表达式
        Stack<Fraction> symbolStack = new Stack<>();
        List<Fraction> result = new ArrayList<>();
        for(Fraction str:list) {
            //数字
            if(str.getSymbol() == null){
                result.add(str);
                continue;
            }
            //左括号
            else if(str.getSymbol().equals("(")){
                symbolStack.push(str);
                continue;
            }
            //右括号
            else  if(str.getSymbol().equals(")")){
                while(!symbolStack.peek().getSymbol().equals("(")){
                    result.add(symbolStack.pop());
                }
                symbolStack.pop();  //输出左括号
                continue;
            }
            //运算符
            else if(symbolStack.isEmpty() || symbolStack.peek().getSymbol().equals("(")){   //栈为空或者栈中有左括号
                symbolStack.push(str);
                continue;
            }
            else if(priority(str) > priority(symbolStack.peek())){  //输入的符号的优先级比栈中第一个符号优先级高
                symbolStack.push(str);
            }
            else {  //if?
                while(!symbolStack.isEmpty() && !symbolStack.peek().getSymbol().equals("(") && priority(str) <= priority(symbolStack.peek())){
                    //栈不为空，栈中的第一个符号不为左括号并且输入的符号的优先级比栈中第一个符号优先级相等或小
                    result.add(symbolStack.pop());
                }
                symbolStack.push(str);
            }
        }
        while(!symbolStack.isEmpty()){  //输入栈中的最后一个符号
            result.add(symbolStack.pop());
        }
        return result;
    }

    @Override
    public Fraction listSuffixResult(List<Fraction> list) {
        Stack<Fraction> caculateStack = new Stack<>();
        Fraction num_1 = null;
        Fraction num_2 = null;
        for(Fraction str:list){
            if(str.getSymbol() == null){
                caculateStack.push(str);
            }
            else{
                num_2 = caculateStack.pop();    //栈中的先进后出
                num_1 = caculateStack.pop();
                caculateStack.push(caculateResult(num_1,num_2,str.getSymbol()));    //计算过后的值重新放入栈中以便下一轮计算
            }
        }
        return caculateStack.pop();
    }

    @Override
    public Fraction caculateResult(Fraction num_1, Fraction num_2, String symbol) { //计算
        switch (symbol){
            case "+":
                return new Fraction().addition(num_1,num_2);
            case "-":
                return new Fraction().subtraction(num_1,num_2);
            case "×":
                return new Fraction().multiplication(num_1,num_2);
            case "÷":
                return new Fraction().division(num_1,num_2);
        }
        throw new RuntimeException(symbol + "不是运算符");
    }

    @Override
    public Fraction result(List<Fraction> list) {   //计算出表达式结果
        List<Fraction> listSuffix_0 = listSuffix(list);
        Fraction result = listSuffixResult(listSuffix_0);
        return result;
    }
}

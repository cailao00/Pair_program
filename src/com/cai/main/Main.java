package com.cai.main;

import java.util.Scanner;

/**
 * Date 2022/9/
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("请按照以下格式输入：");
        System.out.println("-n 生成题目数 -r 参数范围");
        Scanner scanner = new Scanner(System.in);
        String text_1 = scanner.nextLine();
        String[] parameter_1 = text_1.split(" ");   //按照空格分割出参数

        System.out.println("请按照以下格式输入：");
        System.out.println("-e 题目文件 -a 答案文件");
        String text_2 = scanner.nextLine();
        String[] parameter_2 = text_2.split(" ");
    }
}


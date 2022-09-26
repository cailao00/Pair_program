package com.cai.main;

import com.cai.generator.QuestionsGenerator;
import com.cai.service.ContrastService;
import com.cai.service.ContrastService_1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Date 2022/9/27
 */

public class Main {
    public static void main(String[] args) throws IOException {
        QuestionsGenerator questionsGenerator = new QuestionsGenerator();
        System.out.println("请按照以下格式输入：");
        System.out.println("-n 生成题目数 -r 参数范围");
        Scanner scanner = new Scanner(System.in);
        String text_1 = scanner.nextLine();
        String[] parameter_1 = text_1.split(" ");   //按照空格分割出参数
        questionsGenerator.getQuestions(Integer.parseInt(parameter_1[1]),Integer.parseInt(parameter_1[3]));
        System.out.println("请按照以下格式输入：");
        System.out.println("-e 待批改文件 -a 答案文件");
        String text_2 = scanner.nextLine();
        String[] parameter_2 = text_2.split(" ");
        ContrastService contrastService = new ContrastService_1();
        contrastService.writeResult(parameter_2[3],parameter_2[1]);
    }
}


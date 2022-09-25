package com.cai.service;

import com.cai.io.FileFunction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContrastService_1 implements ContrastService{
    @Override
    public List<List<Integer>> getTitle(Map<Integer, String> map1, Map<Integer, String> map2) {
        List<List<Integer>>List =new ArrayList<>();
        List<Integer>List1 =new ArrayList<>();      //存放正确题目
        List<Integer>List2 =new ArrayList<>();      //存放错误题目
        int i=1;
        while(i<=map1.size()){
            if(map1.get(i).equals(map2.get(i))){
                List1.add(i);
            }else {
                List2.add(i);
            }
            i++;
        }
        List.add(List1);
        List.add(List2);
        return List;
    }

    @Override
    public void writeResult(String answerFilePath, String actualFilePath) throws IOException {
        FileFunction fileHandler =new FileFunction();
        StringBuilder context=new StringBuilder();
        Map<Integer,String> answerFile=fileHandler.readFile(answerFilePath);
        Map<Integer,String> actualFile=fileHandler.readFile(actualFilePath);
        List<List<Integer>> lists=getTitle(answerFile,actualFile);
        List<Integer> list1=lists.get(0);
        StringBuffer sb = new StringBuffer();
        for (Integer str: list1) {
            sb.append(str).append(",");
        }
        String keywordStr = sb.deleteCharAt(sb.length() - 1).toString();
        List<Integer> list2=lists.get(1);
        StringBuffer sb1 = new StringBuffer();
        for (Integer str: list2) {
            sb1.append(str).append(",");
        }
        String keywordStr1 = sb1.deleteCharAt(sb1.length() - 1).toString();
        String CorrectTitle = "Correct: " + lists.get(0).size() + " (" + keywordStr + ")";
        String WrongTitle = "Wrong: " + lists.get(1).size() + " (" + keywordStr1 + ")";
        context.append(CorrectTitle + System.lineSeparator());  //System.lineSeparator()方法返回 "\r\n"
        context.append(WrongTitle + System.lineSeparator());
        fileHandler.saveFile("Grade.txt", context);
    }
}

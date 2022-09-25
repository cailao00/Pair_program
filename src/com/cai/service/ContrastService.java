package com.cai.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author caiyifan
 * @Date 2022/9/24 21:18
 */
public interface ContrastService {
    /**
     * 求对比答案后的对/错的题目
     * @param map1 题目的答案
     * @param map2 答题者的答案
     * @return
     */
    List<List<Integer>> getTitle(Map<Integer,String> map1, Map<Integer,String> map2);

    /**
     * 将结果写入Grade.txt文件
     * @param answerFilePath 答案的文件
     * @param actualFilePath 答题的文件
     * @throws IOException
     */
    void writeResult(String answerFilePath,String actualFilePath)throws IOException;
}

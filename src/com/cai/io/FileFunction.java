package com.cai.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author caiyifan
 * @Date 2022/9/24 20:49
 */
public class FileFunction {
    /**
     *保存文件
     * @param path
     * @param context
     * @throws IOException
     */
    public void saveFile(String path,StringBuilder context) throws IOException {
        File file=new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        PrintWriter out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8")));
        out.write(String.valueOf(context));
        out.flush();
        out.close();
    }

    public Map<Integer,String> readFile(String path){
        File file =new File(path);
        Map<Integer,String>map=new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String temp = null;
            while ((temp = br.readLine())!=null){
                map.put(Integer.parseInt(temp.split(". ")[0]), temp.split(". ")[1]);//通过题目的正则表达式". "拆分成Map的键值对
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }catch (IOException e2){
            e2.printStackTrace();
        }


        return map;
    }
}

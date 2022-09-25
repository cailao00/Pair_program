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
        File file = new File(path);
        Map<Integer, String> map = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String temp = null;
            while (((temp = reader.readLine()) != null) && (temp.length() > 0)) {
                map.put(Integer.parseInt(temp.split(". ")[0]), temp.split(". ",-1)[1]);
            }
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return map;
    }
}

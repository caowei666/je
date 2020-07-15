package com.caowei.utils;

import java.io.File;
import java.util.Map;
import java.util.UUID;

public class UploadUtils {
    //根据老的文件名生成新的文件名
    public static String createNewFileName(String oldFileName){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newFileName = uuid + "_" + oldFileName;
        return newFileName;
    }
    public static String createNewPath(String basePath,String oldFileName){
        int hashCode = oldFileName.hashCode();  //二进制的一串数字
        int dirl = hashCode&0xf;
        int dir2 = (hashCode&0xf0)>>>4;
        String newPath = basePath + "/" + dirl + "/" + dir2;
        File dir = new File(newPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        return newPath;
    }
    //遍历文件夹的方法
    public static void listFiles(File dir, Map<String,String> map){
        File[] files = dir.listFiles();
        if(files != null){
            for(File f:files){
                if(f.isDirectory()){
                    listFiles(f,map);
                }else{
                    String uuidfileName = f.getName();
                    String filename = uuidfileName.substring(uuidfileName.indexOf("_") + 1);
                    map.put(uuidfileName,filename);
                }
            }
        }
    }
}

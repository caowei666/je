package com.caowei.utils;

import java.io.File;
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
}

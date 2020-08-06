package controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("upload1.html")
    public String upload(@RequestParam("file") MultipartFile file, String str){
        try {
            System.out.println(str);
            FileUtils.copyInputStreamToFile(file.getInputStream(),
                    new File("D:/",file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload";
    }
    @RequestMapping("upload2.html")
    public String upload2(MultipartFile[] file){
        try {
            for (MultipartFile multipartFile:file){
                FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),
                        new File("D:/",multipartFile.getOriginalFilename()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload";
    }
}

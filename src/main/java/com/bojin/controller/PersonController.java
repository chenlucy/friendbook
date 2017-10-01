package com.bojin.controller;

import com.bojin.common.Response;
import com.bojin.entity.Person;
import com.bojin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/1.
 */
@RestController
@RequestMapping("person")
@CrossOrigin
public class PersonController {

    @Autowired
    private PersonService personService;

    private static String UPLOADED_FOLDER = "F:\\githubproject\\files\\";

    @RequestMapping("findAll")
    public Response findAll(){
        try{
            List<Person> personList = personService.findAll();
            return Response.ok(personList);
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("查询失败:"+e.getMessage());
        }
    }

    @RequestMapping("save")
    public Response save(Person person){
        try{
            personService.save(person);
            return Response.ok("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("保存失败:"+e.getMessage());
        }
    }
    @RequestMapping("delete")
    public Response delete(Integer id){
        try{
            personService.delete(id);
            return Response.ok("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("删除失败:"+e.getMessage());
        }
    }

    @RequestMapping("update")
    public Response update(Person person){
        try{
            personService.update(person);
            return Response.ok("修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return Response.fail("修改失败:"+e.getMessage());
        }
    }



    @RequestMapping("upload")
    public String upload(MultipartFile file){
        if(file.isEmpty()){
            return "上传文件为空";
        }
        File fileDir = new File(UPLOADED_FOLDER);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        try{
            int location = file.getOriginalFilename().lastIndexOf(".");
            String ext = file.getOriginalFilename().substring(location);
            String fileName = UUID.randomUUID()+ext;
            String filePath =UPLOADED_FOLDER +fileName;
            file.transferTo(new File(filePath));
            return filePath;
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败,原因:"+e.getMessage();
        }
    }




}

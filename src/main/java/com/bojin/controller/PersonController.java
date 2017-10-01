package com.bojin.controller;

import com.bojin.entity.Person;
import com.bojin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/10/1.
 */
@RestController
@RequestMapping("person")
@CrossOrigin
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("findAll")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @RequestMapping("save")
    public String save(Person person){
        try{
            personService.save(person);
            return "保存成功！";
        }catch (Exception e){
            e.printStackTrace();
            return "保存失败！";
        }
    }
    @RequestMapping("delete")
    public String delete(Integer id){
        try{
            personService.delete(id);
            return "删除成功！";
        }catch (Exception e){
            e.printStackTrace();
            return "删除失败！";
        }
    }

    @RequestMapping("update")
    public String update(Person person){
        try{
            Person per = personService.update(person);
            return "修改成功！"+per.toString();
        }catch (Exception e){
            e.printStackTrace();
            return "修改失败！";
        }
    }




}

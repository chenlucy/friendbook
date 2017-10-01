package com.bojin.service.impl;

import com.bojin.dao.PersonDao;
import com.bojin.entity.Person;
import com.bojin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/1.
 */
@Service("PersonService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;


    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void delete(Integer id) {
        personDao.delete(id);
    }

    @Override
    public Person update(Person person) {
        return personDao.save(person);
    }


}

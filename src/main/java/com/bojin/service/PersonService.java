package com.bojin.service;

import com.bojin.entity.Person;

import java.util.List;

/**
 * Created by Administrator on 2017/10/1.
 */
public interface PersonService {

    List<Person> findAll();

    void save(Person person);

    void delete(Integer id);

    Person update(Person person);


}

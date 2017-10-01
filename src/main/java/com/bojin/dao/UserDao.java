package com.bojin.dao;

import com.bojin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/10/1.
 */
public interface UserDao extends JpaRepository<User,Integer> {
}

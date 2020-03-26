package com.example.springboot.service;

import com.example.springboot.dto.User;

import java.util.List;

/**
 * describe:
 *
 * @author 林旭南(linxnsz @ sinosoft.com.cn)
 * @date 2019-12-25 下午 02:48
 */
public interface UserService {
    List<User> findAll();
    void insert(User user);
}

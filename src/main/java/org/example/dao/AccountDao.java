package org.example.dao;

import org.example.entity.Account;

import java.util.List;

//接口
public interface AccountDao {
    /**
     * 新增
     */
    void save(Account account);
    /**
     * 修改
     */
    void update(Account account);
    /**
     * 删除
     */
    void delete(Integer id);
    /**
     * 根据id查询
     */
    Account findById(Integer id);
    /**
     * 查询所有
     */
    List<Account> findAll();
}


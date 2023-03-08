package org.example.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.example.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

//类
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    public AccountDaoImpl(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public void save(Account account) {
        try {
            String sql = "insert into account (name,money) values(?,?);";
            queryRunner.update(sql, account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        try {
            String sql = "update account set name=?,money=? where id=?;";
            queryRunner.update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            String sql = "delete from account where id=?;";
            queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account findById(Integer id) {
        try {
            Account account = queryRunner.query("select * from account where id=?", new BeanHandler<Account>(Account.class), id);
            return account;
        } catch (SQLException e) {
            throw new RuntimeException("SQL 查询出错!!!!");
        }
    }

    public List<Account> findAll() {
        try {
            String sql = "select * from account;";
            List<Account> accounts = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException("SQL 查询出错!!!!");
        }
    }
}

package org.example.entity;

public class Account {
    private Integer id;
    private String name;//用户名称
    private Double money;//账户金额

    public Account() {
    }

    public Account(Integer id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", money=").append(money);
        sb.append('}');
        return sb.toString();
    }
}
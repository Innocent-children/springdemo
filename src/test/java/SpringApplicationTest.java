import org.example.configure.SpringConfiguration;
import org.example.entity.Account;
import org.example.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringApplicationTest {

    private AccountService accountService;

    @Before
    public void init(){
        //获取Spring的ioc容器
        //通过XML配置文件，初始化Spring的ioc容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //通过配置类，初始化Spring的ioc容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(org.example.configure.SpringConfiguration.class);
        //获取AccountService接口的实现类对象
        accountService = ac.getBean(AccountService.class);
    }

    //测试新增
    @Test
    public void testSave(){
        //模拟账户信息
        Account a = new Account();
        a.setName("迪丽热巴");
        a.setMoney(10000.0);
        //新增
        accountService.save(a);
    }
    //测试修改
    @Test
    public void testUpdate(){
        //模拟账户信息
        Account a = new Account();
        a.setId(13);
        a.setName("古力娜扎");
        a.setMoney(1000.0);
        //修改
        accountService.update(a);
    }
    //测试根据id查询
    @Test
    public void testFindById(){
        //根据id查询账户信息
        Account a = accountService.findById(13);
        System.out.println(a);
    }
    //测试查询所有
    @Test
    public void testFindAll(){
        //查询所有账户信息
        List<Account> accounts = accountService.findAll();
        for (Account a : accounts) {
            System.out.println(a);
        }
    }
    //测试删除
    @Test
    public void testDelete(){
        //删除账户
        accountService.delete(13);

    }
}
package org.example.configure;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * 配置类，替代ApplicationContext配置文件
 *
 * @Configuration 注解作用：设置当前类为配置类
 * @ComponentScan("com.abc") 注解作用：配置开启注解扫描
 * @Import(DatabaseConfiguration.class) 标签作用：导入外部的配置类
 * value属性：设置外部配置类的字节码文件
 */
@Configuration
@ComponentScan("org.example")
@Import(DatabaseConfiguration.class)
public class SpringConfiguration {

}
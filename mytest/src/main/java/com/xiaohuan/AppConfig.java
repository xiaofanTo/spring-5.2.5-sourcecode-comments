package com.xiaohuan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>Title: com.xiaohuan.AppCofig</p >
 * <p>Description: </p >
 * <p>Company: http://www.taiyuejinfu.com</p >
 * <p>Project: spring</p >
 *
 * @author: xiaohuan
 * @Date: 2020/5/16 11:29 上午
 * @Version: 1.0
 */
@Configuration
@ComponentScan("com.xiaohuan")
@Import(MyImportBeanDefinition.class)
//@Conditional(MyCondition.class)
public class AppConfig {
}

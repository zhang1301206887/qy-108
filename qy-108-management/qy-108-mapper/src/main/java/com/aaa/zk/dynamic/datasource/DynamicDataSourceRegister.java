package com.aaa.zk.dynamic.datasource;


import com.aaa.zk.dynamic.properties.DBProperties;
import com.aaa.zk.dynamic.properties.PropertiesUtils;
import com.aaa.zk.utils.StringUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
/**
* @Author: He create on 2020/5/30 19:18
* @param:
* @return:
* @Description:  把整个数据源的操作(开启事务，设置数据源，连接数据库，加载驱动...)托管给spring处理
*/
@Configuration
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    /**
     * 指定默认的数据源类型
     * 其实springboot2.x所默认使用的是hikari，如果自己想使用其他的数据源可以进行配置
     * 如果不配置则使用的就是默认的，一定记得添加jar包spring-boot-jdbc
     * <dependency>
     *     <groupId>org.springframework.boot</groupId>
     *     <artifactId>spring-boot-starter-jdbc</artifactId>
     * </dependency>
     *
     * 咱们这里使用阿里巴巴的druid
     */
    private static final String DATASOURCE_TYPE_DEFAULT = "com.alibaba.druid.pool.DruidDataSource";

    /**
     * 在spring.application中所配置的默认数据源(mysql)
     */
    private DataSource defaultDataSource;

    /**
     * 在spring.application中所配置的自定义数据源
     */
    private Map<String, DataSource> slaveDataSource = new HashMap<String, DataSource>();

    /**
    * @Author: He create on 2020/5/30 19:17
    * @param: [environment]
    * @return: void
    * @Description: 设置数据源初始化的环境
    */
    @Override
    public void setEnvironment(Environment environment) {
        // 也就是说在这里需要初始化一些连接数据库的操作
        initDefaultDataSource(environment);
        initSlaveDataSource(environment);
    }

    /**
    * @Author: He create on 2020/5/30 19:16
    * @param: [env]
    * @return: void
    * @Description: 初始化默认的数据源
    */
    private void initDefaultDataSource(Environment env) {
        // 读取主数据源
        String primary = env.getProperty("spring.datasource.primary");
        if(StringUtils.isEmpty(primary) || null == primary) {
            primary = "mysql";
        }
        /**
         * 这个意思就是:
         *  从application.properties文件中找到以前缀为spring.datasource的所有属性值
         *  然后把所有属性值赋值给PropertiesUtils这个类
         *  换句话说:
         *      以spring.datasource为前缀的属性值就和PropertiesUtils绑定了
         *
         *  返回值就是已经赋值过后的PropertiesUtils对象
         *
         *  其实这个方法就是为了单纯的从application.properties中来获取值
         */
        PropertiesUtils property = Binder.get(env).bind("spring.datasource", PropertiesUtils.class).get();
        Map<String, DBProperties> dbMaps = property.getDynamic();
        for(Map.Entry<String, DBProperties> item : dbMaps.entrySet()) {
            String pollName = item.getKey();// mysql, oracle, sqlserver
            if(primary.equals(pollName)) {
                // 一定是mysql
                DBProperties dbProperties = item.getValue();
                dbProperties.setPollName(pollName);
                Map<String, Object> dsMap = new HashMap<String, Object>();
                dsMap.put("driver", dbProperties.getDriverClassName());
                dsMap.put("url", dbProperties.getUrl());
                dsMap.put("username", dbProperties.getUsername());
                dsMap.put("password", dbProperties.getPassword());
                defaultDataSource = buildDataSource(dsMap);
            }
        }
    }

    /**
    * @Author: He create on 2020/5/30 19:16
    * @param: [env]
    * @return: void
    * @Description: 数据源构建的初始方法 自定义数据源
    */
    private void initSlaveDataSource(Environment env) {
        String primary = env.getProperty("spring.datasource.primary");
        PropertiesUtils property = Binder.get(env).bind("spring.datasource", PropertiesUtils.class).get();
        Map<String, DBProperties> dynamic = property.getDynamic();
        for(Map.Entry<String, DBProperties> item : dynamic.entrySet()) {
            String pollName = item.getKey();
            if(primary.equals(pollName)) {
                continue;
            }
            DBProperties dbProperties = item.getValue();
            dbProperties.setPollName(pollName);
            Map<String, Object> dsMap = new HashMap<String, Object>();
            dsMap.put("driver", dbProperties.getDriverClassName());
            dsMap.put("url", dbProperties.getUrl());
            dsMap.put("username", dbProperties.getUsername());
            dsMap.put("password", dbProperties.getPassword());
            DataSource ds = buildDataSource(dsMap);
            slaveDataSource.put(pollName, ds);
        }
    }

    /**
    * @Author: He create on 2020/5/30 19:15
    * @param: [importingClassMetadata, registry]
    * @return: void
    * @Description: 将数据源注册到IOC容器
     * 让DI反向生成对象
    */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> targetDataSources = new HashMap<String, Object>();
        // 添加默认数据源
        targetDataSources.put("dataSource", this.defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        // 添加自定义数据源
        targetDataSources.putAll(slaveDataSource);
        for(String key : slaveDataSource.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }
        // 创建动态数据源对象
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        propertyValues.addPropertyValue("targetDataSource", targetDataSources);

        // 注册就完事了
        registry.registerBeanDefinition("dataSource", beanDefinition);

    }

    /**
    * @Author: He create on 2020/5/30 19:15
    * @param: [dataSourceMap]
    * @return: javax.sql.DataSource
    * @Description: 构建数据源
    */
    public DataSource buildDataSource(Map<String, Object> dataSourceMap) {
        try {
            //获取传入的数据源类型
            Object type = dataSourceMap.get("type");
            if(null == type) {
                //为空时 使用默认的类型
                type = DATASOURCE_TYPE_DEFAULT;
            }
            Class<? extends DataSource> dataSourceType;
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);
            String driverClassName = dataSourceMap.get("driver").toString();
            String url = dataSourceMap.get("url").toString();
            String username = dataSourceMap.get("username").toString();
            String password = dataSourceMap.get("password").toString();
            // 自定义DataSource配置
            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
                    .username(username).password(password).type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return null;
    }

}

package io.github.changebooks.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;

/**
 * Application Context
 * Hold and Use
 *
 * @author changebooks@qq.com
 */
public class ApplicationContextHolderSupport implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextHolderSupport.class);

    /**
     * hold the {@link ApplicationContext} instance
     */
    @Nullable
    private ApplicationContext applicationContext;

    /**
     * hold the {@link Environment} instance
     */
    @Nullable
    private Environment environment;

    /**
     * 获取Bean实例
     *
     * @param name         名称
     * @param requiredType 匹配类型，接口、父类
     * @param <T>          类型
     * @return Bean instance
     * @throws BeansException 创建实例失败
     */
    @Nullable
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        ApplicationContext applicationContext = getApplicationContext();

        if (applicationContext != null) {
            return applicationContext.getBean(name, requiredType);
        } else {
            LOGGER.warn("ApplicationContextHolderSupport getBean, applicationContext is null, name: {}, requiredType: {}",
                    name, requiredType);
            return null;
        }
    }

    /**
     * 获取一个配置
     *
     * @param key 配置键
     * @return 配置值
     */
    @Nullable
    public String getProperty(String key) {
        Environment environment = getEnvironment();

        if (environment != null) {
            return environment.getProperty(key);
        } else {
            LOGGER.warn("ApplicationContextHolderSupport getProperty, environment is null, key: {}", key);
            return null;
        }
    }

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        if (applicationContext != null) {
            LOGGER.info("ApplicationContextHolderSupport setApplicationContext, applicationContext is ok");

            this.applicationContext = applicationContext;
            this.environment = applicationContext.getEnvironment();
        } else {
            LOGGER.warn("ApplicationContextHolderSupport setApplicationContext, applicationContext is null");
        }
    }

    @Nullable
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Nullable
    public Environment getEnvironment() {
        return environment;
    }

}

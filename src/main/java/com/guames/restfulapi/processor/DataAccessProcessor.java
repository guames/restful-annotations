package com.guames.restfulapi.processor;

import com.guames.restfulapi.access.DataAccessFieldCallback;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class DataAccessProcessor implements BeanPostProcessor {

    private ConfigurableListableBeanFactory configurableBeanFactory;

    @Autowired
    public DataAccessProcessor(ConfigurableListableBeanFactory beanFactory) {
        this.configurableBeanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        this.scanDataAccessAnnotation(bean, beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    protected void scanDataAccessAnnotation(Object bean, String beanName) {
        this.configureFieldInjection(bean);
    }

    private void configureFieldInjection(Object bean) {
        Class<?> managedBeanClass = bean.getClass();
        ReflectionUtils.FieldCallback fieldCallback =
                new DataAccessFieldCallback(configurableBeanFactory, bean);
        ReflectionUtils.doWithFields(managedBeanClass, fieldCallback);
    }
}
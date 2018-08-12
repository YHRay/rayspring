package com.rayspring.beans.factory;

import com.rayspring.beans.BeanDefinition;

public interface BeanFactory {
    BeanDefinition getBeanDefinition(String beanID);

    Object getBean(String beanID);
}

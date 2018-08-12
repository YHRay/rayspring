package com.rayspring.test.v1;

import com.rayspring.beans.BeanDefinition;
import com.rayspring.beans.factory.BeanCreationException;
import com.rayspring.beans.factory.BeanDefinitionStoreException;
import com.rayspring.beans.factory.BeanFactory;
import com.rayspring.beans.factory.support.DefaultBeanFactory;
import com.rayspring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;
import static  org.junit.Assert.*;

public class BeanFactoryTest {

    @Test
    public void testGetBean(){
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        assertEquals("com.rayspring.service.v1.PetStoreService",bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

        assertNotNull(petStore);
    }

    @Test
    public void testInvalidBean(){
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        try{
            factory.getBean("invalidBean");
        }catch (BeanCreationException e){
            return;
        }

        Assert.fail("expect BeanCreationException ");
    }

    @Test
    public void testInvalidXML(){

        try{
            new DefaultBeanFactory("xxxx.xml");
        }catch (BeanDefinitionStoreException e){
            return;
        }

        Assert.fail("expect BeanDefinitionStoreException ");
    }
}

package com.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src\\main\\java\\com\\example\\spring.xml"));
        Alien obj = (Alien)factory.getBean("alien");
        System.out.println("g");
        obj.code();
    }
}

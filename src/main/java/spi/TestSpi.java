package spi;

import java.util.ServiceLoader;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2019-08-02 15:24
 **/
public class TestSpi {

    public static void main(String[] args) {
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        System.out.println("JAVA Spi");
        serviceLoader.forEach(Animal::say);
    }

}
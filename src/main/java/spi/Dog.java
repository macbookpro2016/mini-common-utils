package spi;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2019-08-02 15:22
 **/
public class Dog implements Animal {

    @Override
    public void say() {
        System.out.println("i am dog");
    }
}
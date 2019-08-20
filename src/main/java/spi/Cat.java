package spi;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2019-08-02 15:21
 **/
public class Cat implements Animal {

    @Override
    public void say() {
        System.out.println("i am cat");
    }
}
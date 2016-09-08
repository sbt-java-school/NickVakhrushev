package ru.sbt.homework6;

/**
 * Created by Work on 25.08.2016.
 */
public class Main {


    public static void main(String[] args) {
        From from1 = new From();

        From fromTo = new From();
        To to = new To();
        ParentFrom parentFrom = new ParentFrom();

        from1.setSurname(123);
        from1.setTdyu("567");

        BeanUtils.assign(fromTo, from1);
        BeanUtils.assign(to, from1);
        BeanUtils.assign(parentFrom, from1);

        int k = 2;

        int name = to.getName();
        int surname = fromTo.getSurname();
        int surname1 = from1.getSurname();
    }
}

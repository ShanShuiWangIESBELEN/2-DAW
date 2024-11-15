package com.OOP.JavaBean;

public class test {
    public static void main(String[] args) {

        student s1 = new student();
        s1.setName("zhangsan");
        s1.setMath(9);
        s1.setEnglish(7);

        System.out.println(s1.getName());
        System.out.println(s1.getMath());
        System.out.println(s1.getEnglish());

        student s2 =new student("lisi",8,9);
        System.out.println(s2.getName());
        System.out.println(s2.getMath());
        System.out.println(s2.getEnglish());


        studentOperator o = new studentOperator(s1);
        o.printTotalScore();
        o.printMediaScore();


    }

}

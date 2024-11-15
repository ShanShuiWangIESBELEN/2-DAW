package com.OOP.JavaBean;

public class studentOperator {

    //必须拿到要处理的学生对象
    private student s; //用于记住将来要操作的学生对象

    public studentOperator(student s) {
        this.s = s;
    }

    //方法
    public void printTotalScore (){
        System.out.println(s.getName()+" La suma de su nota es: "+ s.getMath()+s.getEnglish());
    }
    public void printMediaScore (){
        System.out.println(s.getName()+" La media de su nota es:"+ s.getMath()+s.getEnglish()/2);
    }

}


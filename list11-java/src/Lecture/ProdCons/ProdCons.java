package Lecture.ProdCons;

import Lecture.ProdCons.Producer;

public class ProdCons {

    public static void main(String[] args) {

//        Buffer buf = new Buffer();
//        ( new Producer("Pro", buf) ).start();
//        ( new Consumer("Con", buf) ).start();

        Lecture.ProdCons.BoundedBuffer buff = new Lecture.ProdCons.BoundedBuffer(5);
        ( new Producer("Pro", buff) ).start();
        ( new Lecture.ProdCons.Consumer("Con", buff) ).start();

    }

}

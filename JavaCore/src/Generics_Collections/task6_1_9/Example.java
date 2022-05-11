package Generics_Collections.task6_1_9;

import java.util.Optional;

public class Example<X> {

    public void someMethod (Object obj) {
        X x1 = (X) obj;                             // +
        Optional<X> x2 = Optional.empty();          // +
//        boolean b1 = (obj instanceof Optional<X>);
//        boolean b2 = (obj instanceof X);
//        X x3 = new X();
//        X[] xArr = new X[1];
    }
}

package facade;

/**
 *
 * @author ksoff
 */

/*
 Facade Pattern
 - Simplified Interface: Providdes a single, simplified interface to a complex subsystem.
 - Encapsulation: Hides the complexities of the subsystem from the client.
 */
class A {

    public void a1() {
        System.out.println("a1");
    }

    public void a2() {
        System.out.println("a2");
    }

}

class B {

    public void b1() {
        System.out.println("b1");
    }

}

class C {

    public void c1() {
        System.out.println("c1");
    }

}

// <editor-fold defaultstate="collapsed" desc="Without Facade">
//class Test {
//
//    public static void main(String[] args) {
//        A a = new A();
//        a.a1();
//        B b = new B();
//        b.b1();
//        a.a2();
//        C c = new C();
//        c.c1();
//    }
//}
// </editor-fold>
// <editor-fold defaultstate="expanded" desc="With Facade">
class X { // This is the Facade

    private A a;
    private B b;
    private C c;

    public X() {
        this.c = new C();
        this.a = new A();
        this.b = new B();
    }

    public void x1() {
        a.a1();
        b.b1();
        a.a2();
        c.c1();
        /*
        * Think that these methods should be called in this correct order.
        * If this facade isn't given, the user will have to figure out this order by own. 
         */
    }
}

class Test {

    public static void main(String[] args) {
        X x = new X();
        x.x1();
    }
}
// </editor-fold>

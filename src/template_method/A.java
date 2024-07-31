package template_method;

/**
 *
 * @author ksoff
 */

/*
Template Method Design Pattern
- Algorithm Framework: Sets up the main steps of an algorithm, letting subclasses fill in the details.
- Consistency: Keeps the core structure of the algorithm the same, preventing changes to key parts.
 */

/* Part 1 */
abstract class A {

    public final void process() {
        m();
        n();
        p();
    }

    private void m() {
        System.out.println("A m");
    }

    //public void n() {
    //    System.out.println("A n");
    //}
    public abstract void n();

    private void p() {
        System.out.println("A p");
    }
}

class X extends A {
    @Override
    public void n() {
        System.out.println("X n");
    }    
}

class Test {
    public static void main(String[] args) {
        A a = new X();
        a.process();
    }
}
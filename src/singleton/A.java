package singleton;

/*
Singleton Pattern
- Single Instance: Only one instance of the class is created.
- Global Access: Provides a way to access that single instance from anywhere in the application.
*/

/**
 *
 * @author ksoff
 */
// <editor-fold defaultstate="collapsed" desc="Without Singleton">
//class A {
//
//    int x = 10;
//    
//}
//
//class Test {
//
//    public static void main(String[] args) {
//        
//        A a1 = new A();
//        A a2 = new A();
//        
//        System.out.println(a1 == a2);
//    }
//
//}
// </editor-fold>

// <editor-fold defaultstate="expanded" desc="With Singleton Pattern">
public class A { // class should be public to access globally

    public static int y = 10;

    public int x = 10;

    /* object could be null referrenced or reassigned if it is public */
    //public static A a = new A();
    /* so we use encapsulation or final modifier */

 /* creating an object on the initialization is not good */
    //public final static A a = new A(); 
    //private static A a = new A();
    //public static A getA() {
    //    return a;
    //}
    /* so we use split into declaration and initialization */
    private static A a;

    public static A getInstance() { // getA == getInstance is the general pattern
        if (a == null) { // checking for being initiated only for once
            a = new A();
        }
        return a;
    }

    /* to stop creating instances outside the class */
    private A() {
    }

}

class Test {

    public static void main(String[] args) {

        //A a2 = new A();
        //A a2 = new A();
        //System.out.println(a1 == a2); // -> false
        //A.a = null; // not good if the one single object could be null referrenced
        A a1 = A.getInstance();
        A a2 = A.getInstance();

        System.out.println(a1 == a2); // -> true
    }

}
// </editor-fold>

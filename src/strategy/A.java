package strategy;

/**
 *
 * @author ksoff
 */
class A {    
}

interface AStrategy { // Makes algorithm interchangeable through interface by implementing them. // abstract classes are also applicable
    public boolean check(String text);
}

class SahanStrategy implements AStrategy { // implements strategy through parent without changing the code (method signature, ... etc) with different algorithms

    @Override
    public boolean check(String text) {
        return text.contains("J");
    }

}

class ChathuraStrategy implements AStrategy {

    @Override
    public boolean check(String text) {
        boolean b = true;
        return b;
    }

}

class Context {
    private AStrategy strategy;

    public void setStrategy(AStrategy strategy) {
        this.strategy = strategy;
    }

    public void useStrategy(String text) {
        strategy.check(text);
    }    
}

class Test {
    public static void main(String[] args) {
        String text = "Hello Java";

        Context context = new Context();
        
        context.setStrategy(new SahanStrategy());
        context.useStrategy(text);
        
        context.setStrategy(new ChathuraStrategy());
        context.useStrategy(text);
        
        /* without context - not flexible */
        //AStrategy s1 = new SahanStrategy();
        //System.out.println(s1.check(text));

        //AStrategy s2 = new ChathuraStrategy();
        //System.out.println(s2.check(text));
    }
}
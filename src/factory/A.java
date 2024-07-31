package factory;

/**
 *
 * @author ksoff
 */
/*
 Factory Pattern
 - Object Creation: Encapsulates object creation to avoid exposing the instantiation logic to the client.
 - Decoupling: Decouples the client code from the specific classes it needs to instantiate.
*/
class A {    
}

/* just leave the class modifiers as defaul and left the interface and factory class public */
interface Gun {
    public abstract void fire();
}

class AK47 implements Gun {
    @Override
    public void fire() {
        System.out.println("Trrr");
    }    
}

class Sniper implements Gun {
    @Override
    public void fire() {
        System.out.println("...");
    }    
}

class GunFactory {
    public Gun makeGun(String name) { // this method could be static or instance method. return type should be expected outcome
        if (name.equalsIgnoreCase("AK47")) { // use your own logics
            return new AK47();
        } else if (name.equalsIgnoreCase("sniper")) {
            return new Sniper();
        } else {
            return null;
        }
    }
}

class Test {
    public static void main(String[] args) {
        GunFactory factory = new GunFactory();
        
        Gun gun1 = factory.makeGun("AK47");
        gun1.fire();
        
        Gun gun2 = factory.makeGun("sniper");
        gun2.fire();
    }
}


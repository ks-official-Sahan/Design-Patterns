package adapter;

/**
 *
 * @author ksoff
 */
public class A {
}

/* Client */
class Laptop {

    private SD sd;

    public void setSd(SD sd) {
        this.sd = sd;
    }

    public void viewFiles() {
        if (this.sd != null) {
            this.sd.read();
        }
    }

}

/* Target */
//class SD { // using a class as a target is not good in adapter pattern.
//    private void read() {
//        System.out.println("Read SD");
//    }
//}

/* Use an abstract or interface class as targer */
//abstract class SD {
//    public abstract void read();    
//}
interface SD {

    public abstract void read();
}

class SamsundSD implements SD {

    @Override
    public void read() {
        System.out.println("Read Samsung SD");
    }
}

/* Adaptee */
/* could be done in both ways*/
//class MicroSD {
//    public void read() {
//        System.out.println("Read Micro SD");
//    }    
//}
interface MicroSD {

    public abstract void read();
}

class SamsundMicroSD implements MicroSD {

    @Override
    public void read() {
        System.out.println("Read Samsung Micro SD");
    }
}

/* Adapter -> is-a target and has-a adaptee */
//class Adapter extends SD {
class Adapter implements SD {

    private MicroSD microSD;

    public Adapter(MicroSD microSD) {
        this.microSD = microSD;
    }

    @Override
    public void read() {
        this.microSD.read();
    }
}

class Test {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();

        /* connecting SDs */
        laptop.setSd(new SD() {
            @Override
            public void read() {
                System.out.println("Read SD");
            }
        });
        laptop.viewFiles();

        laptop.setSd(new SamsundSD());
        laptop.viewFiles();

        /* trying to connect Micro SDs directly */
        //laptop.setSd(new MicroSD());
        //laptop.setSd(new SamsungMicroSD()); // this can't be done. So we'll use an adapter with MicroSD within it.

        /* Connecting Micro SDs via an Adapter */
        //laptop.setSd(new Adapter(new MicroSD()));
        laptop.setSd(new Adapter(new MicroSD() {
            @Override
            public void read() {
                System.out.println("Read Micro SD");
            }
        }));
        laptop.viewFiles();

        laptop.setSd(new Adapter(new SamsundMicroSD()));
        laptop.viewFiles();
    }
}

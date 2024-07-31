package template_method;

/**
 *
 * @author ksoff
 */
public class B {
}

abstract class FruitJuice {

    public final void prepare() {
        select();
        if (canAddIngrediants()) {
            addIngrediants();
        }
        blend();
        serve();
    }

    protected abstract void select();

    protected abstract void addIngrediants();

    private void blend() {
        System.out.println("Blend");
    }

    private void serve() {
        System.out.println("Serve");
    }

    protected boolean canAddIngrediants() { // Hook Method
        return true;
    }
}

class AppleJuice extends FruitJuice {

    @Override
    protected void select() {
        System.out.println("Select Apple");
    }

    @Override
    protected void addIngrediants() {
        System.out.println("Add Water + Salt");
    }

}

class orangeJuice extends FruitJuice {

    @Override
    protected void select() {
        System.out.println("Select Orange");
    }

    @Override
    protected void addIngrediants() {
        System.out.println("Add Water + Sugar");
    }

}

class watermelonJuice extends FruitJuice {

    @Override
    protected void select() {
        System.out.println("Select Watermelon");
    }

    @Override
    protected void addIngrediants() {
        System.out.println("None");
    }

    @Override
    protected boolean canAddIngrediants() {
        return false;
    }

}

class Test {

    public static void main(String[] args) {
        FruitJuice juice1 = new AppleJuice();
        juice1.prepare();

        FruitJuice juice2 = new orangeJuice();
        juice2.prepare();

        FruitJuice juice3 = new watermelonJuice();
        juice3.prepare();
    }
}

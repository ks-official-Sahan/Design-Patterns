package state;

/**
 *
 * @author ksoff
 */
interface State {
    public abstract void handle();
}

class ConcreateStateA implements State {
    @Override
    public void handle() {
        System.out.println("Concreate State A");
    }    
}

class ConcreateStateB implements State {
    @Override
    public void handle() {
        System.out.println("Concreate State B");
    }    
}

class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }
    
    public void request() {
        this.state.handle();
    }   
}

class Test {
    public static void main(String[] args) {
        Context context = new Context();
        
        ConcreateStateA concreateStateA = new ConcreateStateA();
        ConcreateStateB concreateStateB = new ConcreateStateB();
        
        context.setState(concreateStateA);
        context.request();
        
        context.setState(concreateStateB);
        context.request();
    }
}
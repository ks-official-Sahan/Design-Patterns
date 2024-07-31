package command;

/**
 *
 * @author ksoff
 */
class A {
}

interface Command {

    public abstract void execute();
}

class ConcreteCommand1 implements Command {

    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionA();
    }
}

class ConcreteCommand2 implements Command {

    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionB();
    }
}

class Receiver {

    public void actionA() {
        System.out.println("Action A");
    }

    public void actionB() {
        System.out.println("Action A");
    }
}

class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invokeAction() {
        command.execute();
    }
}

class Test {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        //receiver.actionA();
        //receiver.actionB();

        Command command1 = new ConcreteCommand1(receiver);
        Command command2 = new ConcreteCommand2(receiver);

        //command1.execute();
        //command2.execute();
        Invoker invoker1 = new Invoker();
        invoker1.setCommand(command1);
        invoker1.invokeAction();
        invoker1.setCommand(command2);
        invoker1.invokeAction();
    }
}

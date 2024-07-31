package observer;

import java.util.ArrayList;

/**
 *
 * @author ksoff
 */
class B {
}

/*
 Observer Pattern
 - Defines a One to Many Dependancy: When one object changes state, all its dependants (observers) are notified and updated automatically.
 */

 /* Method 2 */
interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}

class ConcreateSubject implements Subject {

    private int x;

    private ArrayList<Observer> observerList;

    public ConcreateSubject() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(x);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        notifyObservers();
    }

}

interface Observer {

    public abstract void update(int x);

    public abstract void register(Subject subject);
}

class ConcreateObserver1 implements Observer {

    @Override
    public void update(int x) {
        System.out.println("Observer 1: " + x);
    }

    @Override
    public void register(Subject subject) {
        subject.registerObserver(this);
    }
}

class ConcreateObserver2 implements Observer {

    @Override
    public void update(int x) {
        System.out.println("Observer 2: " + x);
    }

    @Override
    public void register(Subject subject) {
        subject.registerObserver(this);
    }
}

class Test {

    public static void main(String[] args) {
        ConcreateSubject subject = new ConcreateSubject();

        Observer observer1 = new ConcreateObserver1();
        observer1.register(subject);

        ConcreateObserver2 cObserver2 = new ConcreateObserver2();
        cObserver2.register(subject);

        //subject.registerObserver(observer1);
        //subject.registerObserver(cObserver1);
        //subject.registerObserver(new ConcreateObserver2());
        subject.setX(10);
    }
}

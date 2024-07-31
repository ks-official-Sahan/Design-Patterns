package iterator;

import java.util.ArrayList;

/**
 *
 * @author ksoff
 */
class A {    
}

/*
 Iterator Pattern
 - Sequential Access: Allows you to access elements one by one in a collection
 - Seperate Traversal Logic: Keeps the logic of how to traverse a collection seperate from the collection itself.
*/

interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}

class ArrayIterator implements Iterator {

    private Object object[];
    private int index;

    public ArrayIterator(Object[] object) {
        this.object = object;
    }
    
    @Override
    public boolean hasNext() {
        return index < object.length;
    }

    @Override
    public Object next() {
        return object[index++];
    }
    
}

class ArrayListIterator implements Iterator {

    private ArrayList list;
    private int index;

    public ArrayListIterator(ArrayList list) {
        this.list = list;
    }
    
    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Object next() {
        return list.get(index++);
    }
    
}

class Test {
    public static void main(String[] args) {
        // Array
        String array1[] = {"Java", "PHP", "C"};
//        for (int i = 0; i < array1.length; i++) {
//            System.out.println(array1[i]);
//        }
        
        // List
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Java");
        list1.add("PHP");
        list1.add("C");
        
//        for (String string : list1) {
//            System.out.println(string);
//        }
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }

        Iterator iterator1 = new ArrayIterator(array1);
        Iterator iterator2 = new ArrayListIterator(list1);
        
        while (iterator1.hasNext()) {
            Object next = iterator1.next();            
            System.out.println(next);
        }
        while (iterator2.hasNext()) {
            Object next = iterator2.next();            
            System.out.println(next);
        }
    }
}


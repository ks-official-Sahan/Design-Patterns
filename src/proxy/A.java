package proxy;

/**
 *
 * @author ksoff
 */
class A {
}

interface Database {

    public abstract void search(String query);
}

class RealDatabase implements Database {

    @Override
    public void search(String query) {
        System.out.println("Database Search: " + query);
    }
}

class ProxyDatabase implements Database {

    private RealDatabase realDatabase;
    private String password;

    public ProxyDatabase(String password) {
        this.password = password;
        realDatabase = new RealDatabase();
    }

    @Override
    public void search(String query) {
        System.out.println("Proxy Searchs: " + query);
        if (authenticate()) {
            this.realDatabase.search(query);
        }
    }

    private boolean authenticate() {
        return this.password.equals("Pass@123");
    }

}

class Test {

    public static void main(String[] args) {
        ProxyDatabase proxyDatabase = new ProxyDatabase("Pass@123");
        proxyDatabase.search("SELECT * FROM `user`");
    }
}

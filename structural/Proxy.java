/**
 * Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. 
 * A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object. 
 * Proxy pattern is used when we want to provide controlled access of a functionality.
 */

interface Machine {
    void executeJob();
}

class MachineImpl implements Machine {
    @Override
    public void executeJob() {
        System.out.println("Executing Job");
    }
}

class MachineProxy implements Machine {

    private MachineImpl machine;

    @Override
    public void executeJob() {
        if (machine == null)
            machine = new MachineImpl();

        this.checkHealth();

        machine.executeJob();

        this.cleanup();
    }

    private void checkHealth() {
        System.out.println("Checking health");
    }

    private void cleanup() {
        System.out.println("Self cleaning");
    }
}


public class Proxy {

    public static void main(String[] args) {
        Machine m1 = new MachineProxy();
        m1.executeJob();
    }

}

/**
 * Singleton pattern is one of the simplest design patterns in Java.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * This pattern involves a single class which is responsible to create an object while making sure that only single object gets created.
 * This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
 */

class SingletonLogger {
    private static SingletonLogger instance;

    private SingletonLogger() {

    }

    public static SingletonLogger getInstance() {
        if (instance == null)
            instance = new SingletonLogger();

        return instance;
    }

    public void debug(String message) {
        System.out.printf("DEBUG: %s\n", message);
    }

    public void error(String message) {
        System.out.printf("ERROR: %s\n", message);
    }
}


public class Singleton {

    public static void main(String[] args) {
        SingletonLogger logger = SingletonLogger.getInstance();
        logger.debug("In main");
        logger.error("Something went wrong !!");
    }

}

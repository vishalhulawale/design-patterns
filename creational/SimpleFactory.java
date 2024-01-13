/**
 * Simple Factory is a factory that creates objects without exposing the creation logic to the client.
 * It is a way to create objects while hiding the creation logic, rather than instantiating objects directly using a new operator.
 */

enum VehicleType {
    CAR,
    BIKE
}

interface Vehicle {
    void accelerate();

    void stop();
}

class Bike implements Vehicle {
    @Override
    public void accelerate() {
        System.out.println("Accelerating Bike");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Bike");
    }
}

class Car implements Vehicle {
    @Override
    public void accelerate() {
        System.out.println("Accelerating Car");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Car");
    }
}

class VehicleFactory {
    public static Vehicle create(VehicleType type) {

        switch (type) {
            case CAR:
                return new Car();

            case BIKE:
                return new Bike();

            default:
                throw new RuntimeException("Invalid vehicle type");
        }
    }
}

public class SimpleFactory {

    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.create(VehicleType.BIKE);
        Vehicle v2 = VehicleFactory.create(VehicleType.CAR);

        v1.accelerate();
        v1.stop();

        v2.accelerate();
        v2.stop();
    }

}

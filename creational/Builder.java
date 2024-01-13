/**
 * Builder pattern is used to create complex objects with constituent parts that must be created in the same order or using a specific algorithm.
 * An external class controls the construction algorithm.
 */

class Computer {
    // Required parameters
    private final String CPU;
    private final String RAM;

    // Optional parameters
    private final String storage;
    private final String graphicsCard;

    // Private constructor to enforce the use of the builder
    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    // Getter methods
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    // Builder class
    public static class ComputerBuilder {
        // Required parameters
        private final String CPU;
        private final String RAM;

        // Optional parameters with default values
        private String storage = "HDD";
        private String graphicsCard = "Integrated";

        // Constructor with required parameters
        public ComputerBuilder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        // Setter methods for optional parameters

        public ComputerBuilder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        // Build method to create the Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Builder {

    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("Intel i7", "16GB")
                .storage("SSD")
                .graphicsCard("NVIDIA GeForce RTX 3080")
                .build();

        // Access computer properties
        System.out.println("CPU: " + computer.getCPU());
        System.out.println("RAM: " + computer.getRAM());
        System.out.println("Storage: " + computer.getStorage());
        System.out.println("Graphics Card: " + computer.getGraphicsCard());
    }

}

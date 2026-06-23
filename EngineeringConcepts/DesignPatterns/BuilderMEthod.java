// Builder Pattern Example - Computer Class

class Computer {
    // Product attributes
    private String CPU;
    private String RAM;
    private String storage;

    // Private constructor (only Builder can access it)
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    // Display method
    public void showConfig() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
        System.out.println("----------------------");
    }

    // Static Nested Builder Class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        // Build method returns final object
        public Computer build() {
            return new Computer(this);
        }
    }
}

// Test Class
public class BuilderPatternExample {
    public static void main(String[] args) {

        // High-end computer
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .build();

        // Basic computer
        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("512GB SSD")
                .build();

        gamingPC.showConfig();
        officePC.showConfig();
    }
}
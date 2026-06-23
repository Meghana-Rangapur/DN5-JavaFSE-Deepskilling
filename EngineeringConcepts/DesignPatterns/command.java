// Command Interface
interface Command {
    void execute();
}

// Receiver Class (Real device)
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command: Turn ON
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Concrete Command: Turn OFF
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Invoker Class (Remote Control)
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Test Class
public class CommandPatternExample {
    public static void main(String[] args) {

        Light light = new Light();

        // Create commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Remote control
        RemoteControl remote = new RemoteControl();

        // Turn ON light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn OFF light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
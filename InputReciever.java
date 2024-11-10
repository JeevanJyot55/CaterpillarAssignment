import java.util.Scanner;

public class InputReciever {

    private Scanner scanner;
    private int faultcode;
    private String fuelLevel;
    private boolean fault;
    private boolean connection = false;

    public InputReciever(int fuelLevel, boolean fault) {
        this.fuelLevel = String.valueOf(fuelLevel);
        this.fault = fault;
    }

    public void runCommandLoop(String input){
        String output = null;
        while (!output.equals("100")) {
            String sc = scanner.nextLine();
            output = response(input);
            System.out.println(output);
        }
    }

    public String response(String input) {
        switch (input) {
            case "001":
                this.connection = true;
                System.out.println("Connection Established!");
                return "001";
            case "010":
                String in = scanner.nextLine();
                if (fault) {
                    return "110 " + faultcode;
                } else {
                    return "101";
                }
            case "011":
                return fuelLevel;

            case "100":
                System.out.println("End of Connection");
                this.connection = false;
                return "100";
        }
        return "Incorrect Input";
    }
}

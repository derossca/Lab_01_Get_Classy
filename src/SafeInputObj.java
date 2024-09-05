import java.util.Scanner;

public class SafeInputObj {

    private  Scanner pipe = new Scanner(System.in);

    public SafeInputObj() {
        pipe = new Scanner(System.in);
    }

    public SafeInputObj(Scanner scanner){
        pipe = scanner;
    }
}

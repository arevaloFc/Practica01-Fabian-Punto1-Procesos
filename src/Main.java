import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ProcessBuilder pb = new ProcessBuilder();

        pb.command("firefox","google.es");

        ArrayList<Process> listaProcesos = new ArrayList<Process>();

        Process proceso = null;

        System.out.println("¿Cuantas ventanas quieres?");
        int numeroVentanas = scan.nextInt();

        try {
            
            for (int i = 0; i < numeroVentanas; i++) {
                listaProcesos.add(pb.start());
            }

            for (int i = 0; i < listaProcesos.size(); i++) {
                proceso = listaProcesos.remove(i);
                proceso.waitFor();
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

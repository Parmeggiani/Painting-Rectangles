import java.io.FileNotFoundException;
import java.util.*;

public class PaintRectangles {

    public static void main(String []args) throws FileNotFoundException{
        Implementation imple = new Implementation();

        long inicio = System.currentTimeMillis();

        imple.initializesRectanglesAndAreas();
        imple.overlappingRectangles();
        imple.printColorsTotalAreas();

        long fim  = System.currentTimeMillis();

        System.out.println("Tempo de execução: "+ (fim - inicio)*1E-3 +" segundos.");

    }

}

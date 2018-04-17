import java.io.FileNotFoundException;
import java.util.*;

public class PaintRectangles {

    public void main(String []args) throws FileNotFoundException{
        Implementation imple = new Implementation();

        imple.initializesRectangles();
        imple.addArea();
        imple.overlappingRectangles();
        imple.testNegativeAreas();
        imple.printColors();

    }

}

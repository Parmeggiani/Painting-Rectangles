import java.io.*;
import java.util.*;

public class FileReading {

    ArrayList<String> readColors = new ArrayList();
    ArrayList<Integer[]> readCoordinates = new ArrayList();

    public void readFile() throws FileNotFoundException {
        File read = new File("teste000100.txt");
        Scanner file = new Scanner(read);

        //Pula a primeira linha
        file.nextLine();

        while(file.hasNextLine()) {
            Integer[] vet = new Integer[4];
            String str = file.nextLine();
            String[] linha = str.split(" ");

            vet[0] = Integer.parseInt(linha[0]);
            vet[1] = Integer.parseInt(linha[1]);
            vet[2] = Integer.parseInt(linha[2]);
            vet[3] = Integer.parseInt(linha[3]);
            readCoordinates.add(vet);
            readColors.add(linha[4]);

        }

    }

    public ArrayList getCoordinates(){
        return readCoordinates;
    }

    public ArrayList getColors(){
        return readColors;
    }

}

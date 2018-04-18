import java.io.FileNotFoundException;
import java.util.*;

public class Implementation {

    ArrayList<String> colors = new ArrayList();
    ArrayList<Integer[]> coordinates = new ArrayList();
    ArrayList<Long> areas = new ArrayList();

    public void initializesRectangles() throws FileNotFoundException {
        FileReading arq = new FileReading();
        arq.readFile();
        colors = arq.getColors();
        coordinates = arq.getCoordinates();
        //System.out.println(coordinates.get(0)[0]+" "+coordinates.get(0)[1]+" "+coordinates.get(0)[2]+" "+coordinates.get(0)[3]);
    }

    private long calculateArea(int x1, int y1, int x2, int y2){
        long area = (x2-x1)*(y2-y1);
        return area;
    }

    private void decreaseArea(int index, int x1, int y1, int x2, int y2){
        long oldArea = areas.get(index);
        long areaAux = calculateArea(x1,y1, x2, y2);
        long newArea = oldArea - areaAux;
        areas.set(index, newArea);
    }

    public void addArea(){
        int x1, y1, x2, y2;
        long areaAux;

        for(int i=0; i<colors.size(); i++){
            x1=coordinates.get(i)[0];
            y1=coordinates.get(i)[1];
            x2=coordinates.get(i)[2];
            y2=coordinates.get(i)[3];
            areaAux=calculateArea(x1,y1,x2,y2);
            areas.add(areaAux);
        }

    }

    public void testNegativeAreas(){
        for(int i=0; i<colors.size(); i++){
            if(areas.get(i)<0){
                areas.set(i, (long)0);
            }
        }
    }

    public void overlappingRectangles(){
        int x1, y1, x2, y2;
        int auxX1, auxY1, auxX2, auxY2;

        for(int i=0;i<colors.size();i++){
            x1=coordinates.get(i)[0];
            y1=coordinates.get(i)[1];
            x2=coordinates.get(i)[2];
            y2=coordinates.get(i)[3];
            for(int j=i+1;j<colors.size();j++){
                auxX1=coordinates.get(j)[0];
                auxY1=coordinates.get(j)[1];
                auxX2=coordinates.get(j)[2];
                auxY2=coordinates.get(j)[3];

                if(x1<auxX1 && x2>auxX1 && x2<=auxX2 &&
                        y1>=auxY1 && y2>auxY2 && y1<auxY2){
                    decreaseArea(i, auxX1, y1, x2, auxY2);
                    continue;
                    //1
                }

                if(x1<auxX1 && x2>auxX1 && x2<=auxX2 &&
                        y1<auxY1 && y2>auxY2){
                    decreaseArea(i, auxX1, auxY1, x2, auxY2);
                    continue;
                    //2
                }

                if(x1<auxX1 && x2>auxX1 && x2<=auxX2 &&
                        y1>=auxY1 && y2<=auxY2){
                    decreaseArea(i, auxX1, y1, x2, y2);
                    continue;
                    //3
                }

                if(x1<auxX1 && x2>auxX1 && x2<=auxX2 &&
                        y1<auxY1 && y2<=auxY2 && y2>auxY1){
                    decreaseArea(i, auxX1, auxY1, x2, y2);
                    continue;
                    //4
                }
                //...

                if(x1<auxX1 && x2>auxX1 && x1>=auxX1 &&
                        y1>=auxY1 && y2>auxY2 && y1<auxY2){
                    decreaseArea(i, x1, y1, auxX2, auxY2);
                    continue;
                    //5
                }

                if(x1<auxX1 && x2>auxX1 && x1>=auxX1 &&
                        y1<auxY1 && y2>auxY2){
                    decreaseArea(i, x1, auxY1, auxX2, auxY2);
                    continue;
                    //6
                }

                if(x1<auxX1 && x2>auxX1 && x1>=auxX1 &&
                        y1>=auxY1 && y2<=auxY2){
                    decreaseArea(i, x1, y1, auxX2, y2);
                    continue;
                    //7
                }

                if(x1<auxX1 && x2>auxX1 && x1>=auxX1 &&
                        y1<auxY1 && y2<=auxY2 && y2>auxY1){
                    decreaseArea(i, x1, auxY1, auxX2, y2);
                    continue;
                    //8
                }
                //...

                if(x1>=auxX1 && x2<=auxX2 &&
                        y1>=auxY1 && y2>auxY2 && y1<auxY2){
                    decreaseArea(i, x1, y1, x2, auxY2);
                    continue;
                    //9
                }

                if(x1>=auxX1 && x2<=auxX2 &&
                        y1<auxY1 && y2>auxY2){
                    decreaseArea(i, x1, auxY1, x2, auxY2);
                    continue;
                    //10
                }

                if(x1>=auxX1 && x2<=auxX2 &&
                        y1>=auxY1 && y2<=auxY2){
                    areas.set(i, (long)0);
                    break;
                    //11
                }

                if(x1>=auxX1 && x2<=auxX2 &&
                        y1<auxY1 && y2<=auxY2 && y2>auxY1){
                    decreaseArea(i, x1, auxY1,x2, y2);
                    continue;
                    //12
                }
                //...

                if(x1<auxX1 && x2>auxX2 &&
                        y1>=auxY1 && y2>auxY2 && y1<auxY2){
                    decreaseArea(i, auxX1, y1, auxX2, auxY2);
                    continue;
                    //13
                }

                if(x1<auxX1 && x2>auxX2 &&
                        y1<auxY1 && y2>auxY2){
                    decreaseArea(i, auxX1, auxY1, auxX2, auxY2);
                    continue;
                    //14
                }

                if(x1<auxX1 && x2>auxX2 &&
                        y1>=auxY1 && y2<=auxY2){
                    decreaseArea(i, auxX1, y1, auxX2, y2);
                    continue;
                    //15
                }

                if(x1<auxX1 && x2>auxX2 &&
                        y1<auxY1 && y2<=auxY2 && y2>auxY1){
                    decreaseArea(i, auxX1, auxY1, auxX2, y2);
                    //16
                }

            }
        }

    }

    public void printColors(){
        long verdeC=0, vermelho=0, azulC=0, amarelo=0, verdeE=0, marrom=0,
                azulE=0, cinza=0, dourado=0, violeta=0, preto=0, laranja = 0;

        for(int i=0; i<colors.size(); i++){

            if("verde-claro".equals(colors.get(i))){
                verdeC = verdeC + areas.get(i);
            }
            if("vermelho".equals(colors.get(i))){
                vermelho = vermelho + areas.get(i);
            }
            if("azul-claro".equals(colors.get(i))){
                azulC = azulC + areas.get(i);
            }
            if("amarelo".equals(colors.get(i))){
                amarelo = amarelo + areas.get(i);
            }
            if("verde-escuro".equals(colors.get(i))){
                verdeE = verdeE + areas.get(i);
            }
            if("marrom".equals(colors.get(i))){
                marrom = marrom + areas.get(i);
            }
            if("azul-escuro".equals(colors.get(i))){
                azulE = azulE + areas.get(i);
            }
            if("cinza".equals(colors.get(i))){
                cinza = cinza + areas.get(i);
            }
            if("dourado".equals(colors.get(i))){
                dourado = dourado + areas.get(i);
            }
            if("violeta".equals(colors.get(i))){
                violeta = violeta + areas.get(i);
            }
            if("preto".equals(colors.get(i))){
                preto = preto + areas.get(i);
            }
            if("laranja".equals(colors.get(i))){
                laranja = laranja + areas.get(i);
            }

        }

        System.out.println("A area total da cor verde-claro é: "+verdeC);
        System.out.println("A area total da cor vermelho é: "+vermelho);
        System.out.println("A area total da cor azul-claro é: "+azulC);
        System.out.println("A area total da cor amarela é: "+amarelo);
        System.out.println("A area total da cor verde-escuro é: "+verdeE);
        System.out.println("A area total da cor marrom é: "+marrom);
        System.out.println("A area total da cor azul-escuro é: "+azulE);
        System.out.println("A area total da cor cinza é: "+cinza);
        System.out.println("A area total da cor dourado é: "+dourado);
        System.out.println("A area total da cor violeta é: "+violeta);
        System.out.println("A area total da cor preto é: "+preto);
        System.out.println("A area total da cor laranja é: "+laranja);


    }

}
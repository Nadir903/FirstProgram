import java.util.ArrayList;

public class Daniela {
    //----------------------------------------METHODEN------------------------------------------------------------------
    public static void addXWert(double wert, ArrayList<Double> xWerte){
        xWerte.add(wert);
    }
    public static void wichtungFaktor(ArrayList<Double> wichtungFaktoren, double unsicherheitQuadrat){
        double faktor = 1/(Math.pow(unsicherheitQuadrat,2));
        wichtungFaktoren.add(faktor);
    }
    public static double gewichteteMittelwert (ArrayList<Double> wichtungFaktoren, ArrayList<Double> xWerte){
        if(wichtungFaktoren.size() != xWerte.size()){
            System.out.println("Not the same size!!");
            return -1;
        }
        double mittelwertOben = 0;
        double mittelwertUnten = 0;
        for (int i = 0; i < wichtungFaktoren.size(); i++) {
            mittelwertOben += wichtungFaktoren.get(i) * xWerte.get(i);
            mittelwertUnten += wichtungFaktoren.get(i);
        }
        return mittelwertOben/mittelwertUnten;
    }
    public static double inUnsicherheit(ArrayList<Double> wichtungFaktoren){
        double faktoren = wichtungFaktoren.stream().mapToDouble(Double::doubleValue).sum();
        return Math.sqrt(1/faktoren);
    }
    public static double outUnsicherheit(ArrayList<Double> wichtungFaktoren, ArrayList<Double> xWerte, double mittelWert){
        if(wichtungFaktoren.size() != xWerte.size()){
            System.out.println("Not the same size!!");
            return -1;
        }
        double wertOben = 0;
        double wertUnten = 0;
        for (int i = 0; i < wichtungFaktoren.size(); i++) {
            wertOben += wichtungFaktoren.get(i)*Math.pow((xWerte.get(i)- mittelWert),2);
            wertUnten += wichtungFaktoren.get(i);
        }
        wertUnten = wertUnten*(wichtungFaktoren.size()-1);

        return Math.sqrt(wertOben/wertUnten);
    }

    //----------------------------------------PLAYGROUND----------------------------------------------------------------

    public static void main(String[] args) {
        ArrayList<Double> wichtungFaktoren = new ArrayList<>();
        ArrayList<Double> xWerte = new ArrayList<>();

        double gewMittelwert;
        double inUnsicher;
        double outUnsicher;

        addXWert(17540.22, xWerte);
        addXWert(17442.6, xWerte);
        addXWert(17529.76, xWerte);

        wichtungFaktor(wichtungFaktoren, 5801.819);
        wichtungFaktor(wichtungFaktoren, 2798.141);
        wichtungFaktor(wichtungFaktoren, 1803.937);

        //Gewichtetes Mittelwert
        gewMittelwert = gewichteteMittelwert(wichtungFaktoren, xWerte);
        System.out.println("Das gewichtete MittelWert ist : " + gewMittelwert);

        //Innere Unsicherheit
        inUnsicher = inUnsicherheit(wichtungFaktoren);
        System.out.println("Die innere Unsicherheit ist : " + inUnsicher);

        //Äussere Unsicherheit
        outUnsicher = outUnsicherheit(wichtungFaktoren, xWerte, gewMittelwert);
        System.out.println("Das äussere Unsicherheit ist : " + outUnsicher);
    }
}

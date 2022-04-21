import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MatheLibrary {
    //------------------------------------------------------------------------------------------------------------------
    public static class Sort{
        //---------------------------------------------BubbleSort-------------------------------------------------------
        public static int[] bubbleSort(int[] array){
            for (int i = 0; i < array.length; i++) {
                for (int j = 1; j < array.length-i; j++) {
                    if(array[j-1]>array[j]){
                        int tmp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = tmp;
                    }
                }
            }
            return array;
        }
        //---------------------------------------------MergeSort--------------------------------------------------------
        private static int[] merge(int[] left, int[] right){
            int i = 0;      //index for left
            int j = 0;      //index for right
            int k = 0;      //index for new Array
            int[] merged = new int[left.length + right.length];

            while (i < left.length && j < right.length){
                if(left[i]<right[j]){
                    merged[k++] = left[i++];
                }else{
                    merged[k++] = right[j++];
                }
            }
            while(i < left.length){
                merged[k++] = left[i++];
            }
            while(j< right.length){
                merged[k++] = right[j++];
            }
            return merged;
        }
        public static int [] mergeSort(int[] array){
            if(array.length<=1){
                return array;
            }
            int[] left;
            int[] right;
            if(array.length % 2 == 0){
                left = new int[array.length/2];
            }else{
                left = new int[array.length/2 + 1];
            }
            right = new int[array.length/2];
            for (int i = 0; i < left.length; i++) {
                left[i] = array[i];
            }
            int j = 0;
            for (int i = left.length; i < array.length ; i++) {
                right[j++] = array[i];
            }
            return merge(mergeSort(left),mergeSort(right));
        }
        //-------------------------------------------MergeSortSort------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------
    public static class Converter{
        public static int length(long number){
            return (int)(Math.log10(number) + 1);
        }
        public static String longToString(long number){
            return Long.toString(number);
        }
        public static long StringToLong(String number){
            return Long.parseLong(number);
        }
        public static String intToString(int number){
            return Integer.toString(number);
        }
        public static int StringToInt(String number){
            return Integer.parseInt(number);
        }
        public static long HexToDec(String hexNumber){
            hexNumber = hexNumber.toLowerCase();
            if(hexNumber.startsWith("0x")){
                hexNumber = hexNumber.substring(2);
            }
            char[] hex = hexNumber.toCharArray();
            long decimal = 0;
            long potencia = 0;
            for (int i = hex.length-1; i >=0 ; i--) {
                if (hex[i] >= '0' && hex[i] <= '9'){
                    decimal += (hex[i] - '0' )* Math.pow(16,potencia);
                }
                else if(hex[i]>='a' && hex[i]<='f'){
                    decimal += (hex[i] - 'a' + 10) * Math.pow(16,potencia);
                }else{
                    return -1;
                }
                potencia++;
            }
            return decimal;
        }
        public static long BinToDec(String binNumber){
            long decimal = 0;
            long potencia = 0;
            for (int i = binNumber.length() - 1; i >= 0 ; i--) {
                if(binNumber.charAt(i) - '0' >= 2){
                    return -1;
                }
                decimal += (binNumber.charAt(i) - '0') * Math.pow(2, potencia);
                potencia++;
            }
            return decimal;
        }
        public static String DecToHex(long decNumber){
            int length = (int)(Math.log10(decNumber) + 1);
            String strHex = "";
            if(decNumber%16<= 9){
                strHex = Long.toString(decNumber%16);
            }else{
                switch ((int)decNumber%16){
                    case 10 -> strHex = "A";
                    case 11 -> strHex = "B";
                    case 12 -> strHex = "C";
                    case 13 -> strHex = "D";
                    case 14 -> strHex = "E";
                    case 15 -> strHex = "F";
                }
            }
            if (length == 1){
                return Long.toString(decNumber%16);
            }
            return DecToHex(decNumber/16) + strHex;
        }
        public static String DecToBin(long decNumber){
            String strBin = Long.toString(decNumber%2);
            if(decNumber == 1){
                return Long.toString(decNumber%2);
            }
            return DecToBin(decNumber/2) + strBin;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static class ForMate {
        public static void elementeDerOrdnungXModY(int ordnung, int modulo) {
            Map<Integer, Double> AnzahlDerElemente = new HashMap<>();
            for (int i = 0; i < modulo; i++) {
                double numero = (Math.pow(i, ordnung)) % modulo;
                System.out.println(i + " --> " + numero);
                if (numero == 1) {
                    AnzahlDerElemente.put(i, numero);
                }
            }
            System.out.println(AnzahlDerElemente.keySet()); //these Values sind der Ordnung X
            System.out.println(AnzahlDerElemente.values());

        }

        public static int ggt(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return ggt(b, a % b);
            }
        }
        //--------------------------------------------------------------------------------------------------------------
        public static void erweiterteEuklidischerAlgorithmus(int a, int b){
            AtomicInteger x = new AtomicInteger(), y = new AtomicInteger();
            System.out.println("The GCD is " + ErweiterteEuklidischerAlgorithmusIntern(a, b, x, y));
            System.out.printf("α = %d, β = %d\n", x.get(), y.get());
        }
        private static int ErweiterteEuklidischerAlgorithmusIntern(int a, int b, AtomicInteger x, AtomicInteger y) {
            if (a == 0) {
                x.set(0);
                y.set(1);
                return b;
            }
            AtomicInteger _x = new AtomicInteger(), _y = new AtomicInteger();
            int gcd = ErweiterteEuklidischerAlgorithmusIntern(b % a, a, _x, _y);
            x.set(_y.get() - (b / a) * _x.get());
            y.set(_x.get());
            return gcd;
        }
        //--------------------------------------------------------------------------------------------------------------
        public static void factoresPrimos(int n){
            HashSet<Integer> factoresPrim = new HashSet<>();
            for (int i = 2; i <= n; i++) {
                if(n%i==0 && isPrime(i)){
                    factoresPrim.add(i);
                }
            }
            System.out.println("Los factores primos de " + n + " son " + factoresPrim.toString());
        }
        public static void ordnungVon(int numero, int modulo, int mächtigkeit){
            double ordnung = ordnungVonIntern(numero,modulo,mächtigkeit);
            System.out.println("Die Ordnung von " + numero +" in der Grupe von mod " + modulo + " deren Mächtigkeit "+
                    mächtigkeit +" ist, ist :: "+ ordnung + " . Also " +numero + " ist von Ordnung " + ordnung );
        }
        private static double ordnungVonIntern(int numero,int modulo, int mächtigkeit){
            HashSet<Integer> factoresPrim = new HashSet<>();
            for (int i = 2; i <= mächtigkeit; i++) {
                if(mächtigkeit%i==0 && isPrime(i)){
                    factoresPrim.add(i);
                }
            }
            List<Integer> factores = factoresPrim.stream().toList().stream().sorted().toList();
            for(Integer i : factores){
                if(Math.pow(numero,i)%modulo == 1) {
                    return i;
                }
            }
            return mächtigkeit;
        }

        //--------------------------------------------------------------------------------------------------------------
        public static void querSumme(int limis, int summe){
            ArrayList<Integer> cantidad = new ArrayList<>();
            for (int i = 0; i < limis; i++) {
                String num = String.valueOf(i);
                int sum = 0;
                for (int j = 0; j < num.length(); j++) {
                    sum += Integer.parseInt(String.valueOf(num.charAt(j)));
                }
                if(sum == summe){
                    cantidad.add(i);
                }
            }
            System.out.println(cantidad.size() + " números tienen la Quersumme " + summe + " dentro del rango 0 < x < " + limis);
            System.out.println("Estos son:");
            for (int i = 0; i < cantidad.size(); i++) {
                System.out.println(i + 1 + ") " + cantidad.get(i));
            }
        }
        //--------------------------------------------------------------------------------------------------------------
        public static void binomialKoeffizient(int n, int k){
            int binom = binomialKoeffizientIntern(n,k);
            System.out.println("Das binomial Koeffizient C(n,k) mit n = " + n +" und k=  " + k +"\nist " + binom);
        }
        private static int binomialKoeffizientIntern(int n, int k){
            if( k == 0 || k == n ) {
                return 1;
            }
            return binomialKoeffizientIntern(n-1,k) + binomialKoeffizientIntern(n-1,k-1);
        }
        //--------------------------------------------------------------------------------------------------------------
        public static ArrayList<Integer> primNumbersUntil(int n){
            ArrayList<Integer> primNumbers = new ArrayList<>();
            for (int i = 2 ; i <= n ; i++) {
                int counter = 0;
                for(int j = 2; j<=i; j++){
                    if(i%j==0){
                        counter++;
                    }
                }
                if (counter <=1){
                    primNumbers.add(i);
                }
            }
            return primNumbers;
        }
        public static boolean isPrime(int n){
            if(n == 2){return true;}
            boolean isPrime = true;
            for (int i = 2; i <= n/2 ; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        }
        //--------------------------------------------------------------------------------------------------------------
        public static void teilbareZahlenFor3Zahlen(int[] zahlen, int limis){
            int first = zahlen[0];
            int second = zahlen[1];
            int third = zahlen[2];
            ArrayList<Integer> divisibleFirst = new ArrayList<>();
            ArrayList<Integer> divisibleSecond = new ArrayList<>();
            ArrayList<Integer> divisibleThird = new ArrayList<>();
            ArrayList<Integer> divisibleFirstAndSecond = new ArrayList<>();
            ArrayList<Integer> divisibleFirstAndThird = new ArrayList<>();
            ArrayList<Integer> divisibleSecondAndThird = new ArrayList<>();
            ArrayList<Integer> divisibleFirstAndSecondAndThird = new ArrayList<>();
            for (int i = 1; i <=limis ; i++) {
                if(i%first == 0){
                    divisibleFirst.add(i);
                }
                if(i%second == 0){
                    divisibleSecond.add(i);
                }
                if(i%third == 0){
                    divisibleThird.add(i);
                }
                if(i%first == 0 && i%second == 0){
                    divisibleFirstAndSecond.add(i);
                }
                if(i%first == 0 && i%third == 0){
                    divisibleFirstAndThird.add(i);
                }
                if(i%second == 0 && i%third == 0){
                    divisibleSecondAndThird.add(i);
                }
                if(i%first == 0 && i%second == 0 && i%third == 0) {
                    divisibleFirstAndSecondAndThird.add(i);
                }
            }
            int primeros = divisibleFirst.size() + divisibleSecond.size() + divisibleThird.size();
            int segundos = divisibleFirstAndSecond.size() + divisibleFirstAndThird.size() + divisibleSecondAndThird.size();
            int tercero = divisibleFirstAndSecondAndThird.size();
            int total = primeros - segundos + tercero;
            System.out.println("A = " + zahlen[0] + " | B = " + zahlen[1] + " | C = " + zahlen[2]);
            String a = "| A | = " + divisibleFirst.size();
            String b = "| B | = " + divisibleSecond.size();
            String c = "| C | = " + divisibleThird.size();
            String ab = "| A ∩ B | = " + divisibleFirstAndSecond.size();
            String ac = "| A ∩ C | = " + divisibleFirstAndThird.size();
            String bc = "| B ∩ C | = " + divisibleSecondAndThird.size();
            String abc ="| A ∩ B ∩ C | = " + divisibleFirstAndSecondAndThird.size();
            String[] toGib = {a,b,c,ab,ac,bc,abc};
            for (int i = 0; i < toGib.length; i++) {
                System.out.println(toGib[i]);
            }
            int rest = limis - total;
            System.out.println("GrundMenge ist : " + limis + " und die Anzahl der \ndurch " + zahlen[0] + ", " + zahlen[1] + ", " + zahlen[2] + " teilbaren Zahlen ist : " + total+"\n");
            System.out.println("Und die Anzahl der Zahlen die weder durch "+zahlen[0] + "\nnoch durch " + zahlen[1] + " noch durch " + zahlen[2] + " teilbar sind, ist " + rest);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static class Generator{
        public static int[] genIntArray(int size){
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * size);
            }
            return array;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static class PlayGround{
        public static void main(String[] args) {
            //System.out.println("-----------------------------------------------------------------------------------");
            //ForMate.erweiterteEuklidischerAlgorithmus(6570,7387);
            //System.out.println("-----------------------------------------------------------------------------------");
            //ForMate.querSumme(1000,8);
            //ForMate.querSumme(100000,17);
            //System.out.println("-----------------------------------------------------------------------------------");
            ForMate.teilbareZahlenFor3Zahlen(new int[]{2,11,31},1000000);
            //System.out.println("-----------------------------------------------------------------------------------");
            //ForMate.binomialKoeffizient(21,17);
            //ForMate.binomialKoeffizient(13,11);
            /*ArrayList<Integer> si = ForMate.primNumbersUntil(100);
            System.out.println(si);
            for (int i = 0; i < si.size(); i++) {
                System.out.println(ForMate.isPrime(si.get(i)));
            }
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println(ForMate.isPrime(4));*/
            //System.out.println(Converter.length(10000));
            //ForMate.erweiterteEuklidischerAlgorithmus(159,2573);
            //ForMate.factoresPrimos(78);
            //ForMate.factoresPrimos(920);
            //ForMate.ordnungVon(860,1385,920);
        }
    }
}

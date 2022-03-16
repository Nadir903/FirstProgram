public class First {
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
    public static class Retos{
        public static int sumatoria(int beginn, int ende){
            int total = 0;
            for (int i = beginn; i <= ende; i++) {
                 total += i;
            }
             return total;
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
            int ende = 10;
            System.out.println(Retos.sumatoria(1,ende));
        }
    }

}

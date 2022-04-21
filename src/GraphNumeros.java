import java.util.ArrayList;

class Rotacion {
    ArrayList<Integer> outgoingInt;
    ArrayList<Duplas> duplas;
    private StringBuilder rotacionFinal;
    public Rotacion(int numero){
        outgoingInt = new ArrayList<>();
        duplas = new ArrayList<>();
        rotacionFinal = new StringBuilder();
        for (int i = 1; i <=numero ; i++) {
            outgoingInt.add(i);
        }
    }
    public void rotar(Ciclo ciclo){
        ArrayList<Integer> cycle = ciclo.getCiclo();
        if(cycle.size()==2){
            int primero = cycle.get(0);     //8
            int segundo = cycle.get(1);     //2

            int lugarUno = 0;
            int lugarDos = 0;
            for (int i = 0; i < outgoingInt.size(); i++) {
                if(outgoingInt.get(i) == primero){lugarUno = i;}
                if(outgoingInt.get(i)==segundo){lugarDos = i;}
            }
            outgoingInt.set(lugarUno,segundo);
            outgoingInt.set(lugarDos,primero);
        }else if(cycle.size()==4){
            int primero = cycle.get(0); //8
            int segundo = cycle.get(1); //1
            int tercero = cycle.get(2); //2
            int cuarto = cycle.get(3);  //3

            int lugarUno = 0;
            int lugarDos = 0;
            int lugarTres = 0;
            int lugarCuatro = 0;
            for (int i = 0; i < outgoingInt.size(); i++) {
                if(outgoingInt.get(i) == primero){lugarUno = i;}
                if(outgoingInt.get(i) ==segundo){lugarDos = i;}
                if(outgoingInt.get(i) == tercero){lugarTres=i;}
                if(outgoingInt.get(i) == cuarto){lugarCuatro=i;}
            }
            outgoingInt.set(lugarUno,segundo);
            outgoingInt.set(lugarDos,tercero);
            outgoingInt.set(lugarTres,cuarto);
            outgoingInt.set(lugarCuatro,primero);
        }else if(cycle.size()==3){
            int primero = cycle.get(0); //8
            int segundo = cycle.get(1); //1
            int tercero = cycle.get(2); //2

            int lugarUno = 0;
            int lugarDos = 0;
            int lugarTres = 0;
            for (int i = 0; i < outgoingInt.size(); i++) {
                if(outgoingInt.get(i) == primero){lugarUno = i;}
                if(outgoingInt.get(i) ==segundo){lugarDos = i;}
                if(outgoingInt.get(i) == tercero){lugarTres=i;}
            }
            outgoingInt.set(lugarUno,segundo);
            outgoingInt.set(lugarDos,tercero);
            outgoingInt.set(lugarTres,primero);
        }
    }
    public void ejecutarRotaciones(ArrayList<Ciclo> ro){
        for (Ciclo ciclo: ro) {
            rotar(ciclo);
        }
    }
    public void ejecutarRotaciones(ArrayList<Ciclo> ro, ArrayList<Ciclo>tetha){
        for (Ciclo ciclo: ro) {
            rotar(ciclo);
        }
        for (Ciclo ciclo: tetha) {
            rotar(ciclo);
        }
    }
    public void concatenar(){
        for (int i = 1; i <=8 ; i++) {
            duplas.add(new Duplas(i,outgoingInt.get(i-1)));
        }
        for (int i = 0; i < duplas.size(); i++) {
            if(duplas.get(i).getX() == duplas.get(i).getY()){
                duplas.remove(duplas.get(i));
            }
        }
    }
    public String getRotacionFinal(){
        return rotacionFinal.toString();
    }
    public String visualizarDuplas(){
        StringBuilder duplasString = new StringBuilder();
        for (Duplas duplas: duplas) {
            duplasString.append(duplas.toString()).append("\n");
        }
        return duplasString.toString();
    }

    @Override
    public String toString() {
        return outgoingInt.toString();
    }
}
class Ciclo{
    private ArrayList<Integer> ciclo = new ArrayList<>();
    public Ciclo(int uno, int dos){
        ciclo.add(uno);
        ciclo.add(dos);
    }
    public Ciclo(int uno, int dos,int tres){
        ciclo.add(uno);
        ciclo.add(dos);
        ciclo.add(tres);
    }
    public Ciclo(int uno, int dos,int tres, int cuatro){
        ciclo.add(uno);
        ciclo.add(dos);
        ciclo.add(tres);
        ciclo.add(cuatro);
    }

    public ArrayList<Integer> getCiclo() {
        return ciclo;
    }
    @Override
    public String toString() {
        if (ciclo.size() == 2) {
            return "( " + ciclo.get(0) + " , " + ciclo.get(1) + " )";
        } else if (ciclo.size() == 3) {
            return "( " + ciclo.get(0) + " , " + ciclo.get(1) + " , " + ciclo.get(2) + " )";
        } else {
            return "( " + ciclo.get(0) + " , " + ciclo.get(1) + " , " + ciclo.get(2) + " , " + ciclo.get(3) + " )";
        }
    }
}
class Duplas{
    private int x;
    private int y;
    public Duplas(int x, int y){
        this.x = x;
         this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {return y;}
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "( " + getX() + " , " + getY() + " )";
    }
}
class PlayGround{
    public static void main(String[] args) {

        ArrayList<Ciclo> ro = new ArrayList<>();
        Ciclo ro1 = new Ciclo(3,7);
        Ciclo ro2 = new Ciclo(5,1);
        Ciclo ro3 = new Ciclo(8,2);
        //Ciclo ro4 = new Ciclo(1,5);
        ro.add(ro1);ro.add(ro2);ro.add(ro3);//ro.add(ro4);

        ArrayList<Ciclo> tetha = new ArrayList<>();
        //Ciclo tetha1 = new Ciclo(8,1,2,3);
        //Ciclo tetha2 = new Ciclo(4,5,6,7);

        Ciclo tetha1 = new Ciclo(3,7);
        Ciclo tetha2 = new Ciclo(6,4);
        Ciclo tetha3 = new Ciclo(2,1);
        //Ciclo tetha4 = new Ciclo(1,5);
        tetha.add(tetha1);tetha.add(tetha2);tetha.add(tetha3);//tetha.add(tetha4);

        Rotacion rotacion = new Rotacion(8);

        rotacion.ejecutarRotaciones(ro,tetha);
        rotacion.concatenar();

        System.out.println(rotacion);
        System.out.println(rotacion.visualizarDuplas());
        System.out.println(rotacion.getRotacionFinal());
    }
}
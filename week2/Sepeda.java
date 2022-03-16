public class Sepeda {

    String Jenis;
    String Merk;
    int JumlahRoda;
    int gear = 5;

    public Sepeda() {
    }

    void ngerem() {
        System.out.println("Sepeda direm");
    }
}

class AksiSepeda {

    public static void main(String[] args) {
        Sepeda Bicycle = new Sepeda();
        Bicycle.Jenis = "Mountain";
        Bicycle.Merk = "Polygon";
        Bicycle.JumlahRoda = 2;
        System.out.println("Sepeda berjenis " + Bicycle.Jenis + " bermerk " + Bicycle.Merk +
                " memiliki jumlah roda " + Bicycle.JumlahRoda);
        int gearSepeda = Bicycle.gear;
        System.out.println("Jumlah gear " + gearSepeda);
        Bicycle.ngerem();
    }
}
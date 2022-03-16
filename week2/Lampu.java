public class Lampu {

    String Color;
    String Merk;
    Boolean status;

    public Lampu() {
    }

    void NyalakanLampu() {
        if (status == false) {
            System.out.println("Apakah lampu menyala? true");
            status = true;
        } else {
            System.out.println("Lampu sudah menyala");
        }
    }

    void MatikanLampu() {
        if (status == true) {
            System.out.println("Apakah lampu mati? false");
            status = false;
        } else {
            System.out.println("Lampu sudah mati");
        }
    }
}

class AksiLampu {

    public static void main(String[] args) {
        Lampu Lamps = new Lampu();
        Lamps.Color = "Kuning";
        Lamps.Merk = "Lubu";
        System.out.println("Lampu berwana " + Lamps.Color + " bermerk " + Lamps.Merk);
        Lamps.status = false;
        Lamps.NyalakanLampu();
        Lamps.MatikanLampu();
    }
}

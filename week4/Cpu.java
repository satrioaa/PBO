package week4;

public class Cpu {

    double price;

    // nested class
    class Processor {
        double cores;
        String manufacturer;

        double getCache() {
            return 4.3;
        }
    }

    // nested protected class
    protected class RAM {
        double size;
        String manufacturer;

        double getClockSpeed() {
            return 5.5;
        }
    }
}

class CpuAksi {

    public static void main(String[] args) {
        Cpu cpu = new Cpu();
        Cpu.Processor processor = cpu.new Processor();
        System.out.println("Processor Cache " + processor.getCache());

        Cpu.RAM ram = cpu.new RAM();
        System.out.println("RAM Clock speed " + ram.getClockSpeed());
    }
}
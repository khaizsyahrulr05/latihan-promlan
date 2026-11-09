
package com.mycompany.latihanpromlan;


// 1. CLASS INDUK (Parent Class)
class Kendaraan {
    private String nomorKendaraan;
    private String merk;
    private double hargaSewaPerHari;

    // Constructor Induk
    public Kendaraan(String nomorKendaraan, String merk, double hargaSewaPerHari) {
        this.nomorKendaraan = nomorKendaraan;
        this.merk = merk;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    // Getter & Setter (Encapsulation)
    public String getNomorKendaraan() {
        return nomorKendaraan;
    }

    public String getMerk() {
        return merk;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    // Method perhitungan biaya sewa dasar (akan di-override oleh class anak)
    public double hitungBiayaSewa(int jumlahHari) {
        return hargaSewaPerHari * jumlahHari;
    }

    // Method menampilkan informasi umum kendaraan
    public void tampilan() {
        System.out.println("Nomor Kendaraan : " + nomorKendaraan);
        System.out.println("Merk            : " + merk);
        System.out.println("Harga Sewa/Hari : Rp " + hargaSewaPerHari);
    }
}

// 2. CLASS ANAK 1 - Mobil
class Mobil extends Kendaraan {
    private double biayaAsuransiPerHari = 50000; // Biaya asuransi tambahan per hari

    // Constructor Mobil
    public Mobil(String nomorKendaraan, String merk, double hargaSewaPerHari) {
        super(nomorKendaraan, merk, hargaSewaPerHari); // Mengoper data ke constructor induk
    }

    // Method Overriding: Menghitung sewa per hari + biaya asuransi Rp 50.000 per hari
    @Override
    public double hitungBiayaSewa(int jumlahHari) {
        double biayaDasar = getHargaSewaPerHari() * jumlahHari;
        double totalAsuransi = biayaAsuransiPerHari * jumlahHari;
        return biayaDasar + totalAsuransi;
    }
}

// 3. CLASS ANAK 2 - Motor
class Motor extends Kendaraan {
    
    // Constructor Motor
    public Motor(String nomorKendaraan, String merk, double hargaSewaPerHari) {
        super(nomorKendaraan, merk, hargaSewaPerHari);
    }

    // Method Overriding: Hanya menghitung biaya sewa per hari tanpa biaya asuransi
    @Override
    public double hitungBiayaSewa(int jumlahHari) {
        return getHargaSewaPerHari() * jumlahHari;
    }
}

// 4. CLASS MAIN (Menjalankan Program)
public class LatihanPromlan {
    public static void main(String[] args) {
        int lamaSewa = 3; // Contoh lama sewa: 3 hari

        System.out.println("=== SISTEM RENTAL KENDARAAN ===\n");

        // Membuat objek Mobil dan Motor (Point 4)
        Mobil mobil = new Mobil("B 1234 ABC", "Toyota Avanza", 300000);
        Motor motor = new Motor("D 5678 XYZ", "Honda Vario", 75000);

        // Menampilkan Informasi Mobil (Point 5)
        System.out.println("--- INFORMASI RENTAL MOBIL ---");
        mobil.tampilan();
        System.out.println("Lama Sewa       : " + lamaSewa + " hari");
        System.out.println("Total Biaya Sewa: Rp " + mobil.hitungBiayaSewa(lamaSewa));
        System.out.println();

        // Menampilkan Informasi Motor (Point 5)
        System.out.println("--- INFORMASI RENTAL MOTOR ---");
        motor.tampilan();
        System.out.println("Lama Sewa       : " + lamaSewa + " hari");
        System.out.println("Total Biaya Sewa: Rp " + motor.hitungBiayaSewa(lamaSewa));
    }
}
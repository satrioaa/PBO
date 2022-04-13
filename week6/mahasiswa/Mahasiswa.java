package week6.mahasiswa;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class Mahasiswa {
	String nim;
	String nama;
	Double ipk;
	int sks;
	String tglLahir; // format yyyy-mm-dd

	public Mahasiswa(String nim, String nama, Double ipk, int sks, String tglLahir) {
		this.nim = nim;
		this.nama = nama;
		this.ipk = ipk;
		this.sks = sks;
		this.tglLahir = tglLahir;
	}

	public String getProgdi() {
		String[] arr = nim.split("\\.");
		String ps = "";
		if (arr[0].equals("A11")) {
			ps = "Teknik Informatika";
		} else if (arr[0].equals("A12")) {
			ps = "Sistem Informasi";
		} else if (arr[0].equals("B11")) {
			ps = "Manajemen";
		} else if (arr[0].equals("B12")) {
			ps = "Akuntansi";
		} else {
			ps = "Belum terdaftar";
		}

		return ps;
	}

	public String ipkStatus() {
		String stat = "";
		/**
		 * jika 0 < ipk <=1 , maka stat = "Perlu usaha lebih"
		 * jika 1 < ipk <=2, maka stat = "Perlu segera menaikkan IPK"
		 * jika 2 < ipk <=2.75, maka stat = "Sedikit lagi"
		 * jika 2.75 < ipk <= 3, maka stat = "Memuaskan"
		 * jika 3 < ipk <= 3.5, maka stat = "Sangat Memuaskan
		 * jika 3.5 < ipk <=4, maka stat = "Dengan pujian"
		 * jika di atas 4, maka stat = "Range ipk di luar jalur"
		 * 
		 */
		if (ipk <= 1) {
			stat = "Perlu usaha lebih";
		} else if (ipk <= 2) {
			stat = "Perlu segera menaikkan IPK";
		} else if (ipk <= 2.75) {
			stat = "Sedikit lagi";
		} else if (ipk <= 3) {
			stat = "Memuaskan";
		} else if (ipk <= 3.5) {
			stat = "Sangat Memuaskan";
		} else if (ipk <= 4) {
			stat = "Dengan pujian";
		} else {
			stat = "Range ipk di luar jalur";
		}

		return stat;
	}

	public int getTahun() {
		int angkatan;
		/**
		 * cari angkatan dari nim yang diinput
		 * misal A11.2000.00001, maka akan mengembalikan 2000
		 * 
		 */
		String[] arr = nim.split("\\.");
		angkatan = Integer.parseInt(arr[1]);
		return angkatan;
	}

	public int getTagihanSks() {
		int perSks = 250000;

		/**
		 * cari berapa jumlah tagihan mahasiswa yang bersangkutan
		 * sks*perSks
		 */
		int tagihan = sks * perSks;

		return tagihan;
	}

	public int getMhsSemester() {
		int smt = 0;
		Calendar kld = Calendar.getInstance();
		int thnSkr = kld.get(Calendar.YEAR);

		/**
		 * Hitung mahasiswa sudah berapa semester kuliah
		 */
		smt = thnSkr - getTahun();

		return smt;
	}

	public String getUmur() {
		String umur = "";

		/**
		 * Hitung umur di sini
		 */
		LocalDate tglLahirLocalDate = LocalDate.parse(tglLahir);
		LocalDate curDate = LocalDate.now();
		umur += Period.between(tglLahirLocalDate, curDate).getYears();

		return umur;
	}
}

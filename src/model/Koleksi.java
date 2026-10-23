package model;

/** Kelas induk seluruh jenis koleksi perpustakaan. */
public abstract class Koleksi {
    private final String kode;
    private final String judul;
    private final int tahunTerbit;
    private boolean sedangDipinjam;

    protected Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKode() { return kode; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
    public boolean isSedangDipinjam() { return sedangDipinjam; }
    public void setSedangDipinjam(boolean sedangDipinjam) { this.sedangDipinjam = sedangDipinjam; }

    /** Aturan kelayakan pinjam, berbeda untuk tiap jenis koleksi. */
    public abstract boolean layakDipinjam();

    /** Alasan yang mudah dipahami bila koleksi tidak layak dipinjam. */
    public abstract String alasanTidakLayak();

    public String deskripsi() {
        return kode + " - \"" + judul + "\" (" + tahunTerbit + ")";
    }
}

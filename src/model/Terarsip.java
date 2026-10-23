package model;

/** Dimiliki koleksi yang punya lokasi fisik di rak. */
public interface Terarsip {
    String nomorRak();
    String lokasiLantai();

    default String ringkasanArsip() {
        return "Rak " + nomorRak() + ", " + lokasiLantai();
    }
}

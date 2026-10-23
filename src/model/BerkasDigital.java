package model;

/** Tidak mengimplementasikan Terarsip karena tidak punya lokasi fisik. */
public class BerkasDigital extends Koleksi {
    private final int ukuranMB;
    private final String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahunTerbit, int ukuranMB, String tautanUnduh) {
        super(kode, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    public int getUkuranMB() { return ukuranMB; }
    public String getTautanUnduh() { return tautanUnduh; }

    @Override
    public boolean layakDipinjam() { return true; }

    @Override
    public String alasanTidakLayak() { return ""; }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " [Berkas Digital, " + ukuranMB + " MB, " + tautanUnduh + "]";
    }
}

package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private final List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    /** Memproses seluruh koleksi secara polimorfik (tanpa percabangan tipe). */
    public void cetakStatus() {
        for (Koleksi k : daftarKoleksi) {
            String status = k.isSedangDipinjam() ? "DIPINJAM"
                    : k.layakDipinjam() ? "LAYAK PINJAM" : "TIDAK LAYAK";
            System.out.println(k.deskripsi() + " -> " + status);
        }
    }

    /** Aturan pengurutan ditentukan dari luar lewat Comparator. */
    public void urut(Comparator<Koleksi> pembanding) {
        daftarKoleksi.sort(pembanding);
    }

    public void pinjam(String kode) throws PustakaException {
        Koleksi koleksi = cari(kode);
        if (koleksi.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(koleksi.getJudul());
        }
        if (!koleksi.layakDipinjam()) {
            throw new KoleksiTidakLayakException(koleksi.getJudul(), koleksi.alasanTidakLayak());
        }
        koleksi.setSedangDipinjam(true);
    }

    private Koleksi cari(String kode) throws PustakaException {
        for (Koleksi k : daftarKoleksi) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        throw new PustakaException("Koleksi dengan kode " + kode + " tidak ditemukan di katalog.");
    }
}

package layanan;

import model.Koleksi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EksporKatalog {
    private static final String FORMAT = "%-8s %-14s %-32s %-6s %-13s%n";

    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(namaBerkas)))) {
            out.printf(FORMAT, "KODE", "JENIS", "JUDUL", "TAHUN", "STATUS");
            out.println("-".repeat(78));
            for (Koleksi k : katalog.getDaftarKoleksi()) {
                String status = k.isSedangDipinjam() ? "Dipinjam"
                        : k.layakDipinjam() ? "Layak pinjam" : "Tidak layak";
                out.printf(FORMAT, k.getKode(), k.getClass().getSimpleName(),
                        k.getJudul(), k.getTahunTerbit(), status);
            }
        }
    }
}

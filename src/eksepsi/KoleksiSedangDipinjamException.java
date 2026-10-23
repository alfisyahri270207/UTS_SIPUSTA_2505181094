package eksepsi;

public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException(String judul) {
        super("Maaf, \"" + judul + "\" sedang dipinjam anggota lain. Silakan coba lagi setelah dikembalikan.");
    }
}

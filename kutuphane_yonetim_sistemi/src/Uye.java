import java.util.ArrayList;
//ADİ clasından miras aldım
class Uye extends Adi {
    ArrayList<Kitap> oduncKitaplar;

    public Uye(String ad) {
        super(ad);
        this.oduncKitaplar = new ArrayList<>();
    }
}

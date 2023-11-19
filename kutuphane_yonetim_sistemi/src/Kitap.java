import java.util.ArrayList;
//ADİ clasından miras aldım
class Kitap extends Adi {

    boolean oduncAlindi;
    ArrayList<Kitap> oduncKitaplar;
    public Kitap(String ad) {
        super(ad);

        this.oduncAlindi = false;
        this.oduncKitaplar = new ArrayList<>();
    }
}

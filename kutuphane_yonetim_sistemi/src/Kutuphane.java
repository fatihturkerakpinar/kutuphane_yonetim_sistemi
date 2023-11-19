import java.util.ArrayList;
import java.util.HashMap;

class Kutuphane {
    ArrayList<Kitap> kitaplar;
    ArrayList<Uye> uyeler;
    ArrayList<Gorevli> gorevliler;
    HashMap<Uye, Kitap> oduncKitaplar;
    //kitapları üyeleri görevlileri arraylistlerde tuttum
    //ödünç alınan kitaplar dediğimiz üye- kitap eşleşmmesini hashmaple tuttum

    public Kutuphane() {
        this.kitaplar = new ArrayList<>();
        this.uyeler = new ArrayList<>();
        this.gorevliler = new ArrayList<>();
        this.oduncKitaplar = new HashMap<>();
    }

    public void kitapEkle(String ad) {
        Kitap kitap = new Kitap(ad);
        kitaplar.add(kitap);
        System.out.println(ad + " kitabı kütüphaneye eklendi.");
    }
    //kitapEkle adlı bir method oluşturdum bu method kullanıldıkça kitaplar adlı listeye kitap eklenecek
    public void kitapCikar(String ad) {
        Kitap kitap = null;
        for (Kitap k : kitaplar) {
            if (k.ad.equals(ad)) {
                kitap = k;
                break;
            }
        }

        if (kitap != null) {
            kitaplar.remove(kitap);
            System.out.println(ad + " kitabı kütüphaneden çıkarıldı.");
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }
    //kitapCikar adlı bir method oluşturdum bu method kullanıldıkça kitaplar adlı listeden kitap silinecek
    // girilen isimle eşleşen bir kitap yoksa kitap bulunamadı diye dönüt verecek

    public void uyeEkle(String ad) {
        Uye uye = new Uye(ad);
        uyeler.add(uye);
        System.out.println(ad + " üyesi sisteme eklendi.");
    }
    //uyeEkle adlı bir method oluşturdum bu method kullanıldıkça uyeler adlı listeye uye eklenecek

    public void uyeCikar(String ad) {
        Uye uye = null;
        for (Uye u : uyeler) {
            if (u.ad.equals(ad)) {
                uye = u;
                break;
            }
        }

        if (uye != null) {
            uyeler.remove(uye);
            System.out.println(ad + " üyesi sistemden çıkarıldı.");
        } else {
            System.out.println("Üye bulunamadı.");
        }
    }
    //uyeCikar adlı bir method oluşturdum bu method kullanıldıkça uyeler adlı listeden uye silinecek
    // girilen isimle eşleşen bir uye yoksa uye bulunamadı diye dönüt verecek
    public void gorevliEkle(String ad) {
        Gorevli gorevli = new Gorevli(ad);
        gorevliler.add(gorevli);
        System.out.println(ad + " görevlisi işe alındı.");
    }
    //gorevliEkle adlı bir method oluşturdum bu method kullanıldıkça gorevliler adlı listeye görevli eklenecek
    public void gorevliCikar(String ad) {
        Gorevli gorevli = null;
        for (Gorevli g : gorevliler) {
            if (!g.ad.equals(ad)) {
                continue;
            }
            gorevli = g;
            break;
        }

        if (gorevli != null) {
            gorevliler.remove(gorevli);
            System.out.println(ad + " görevlisi işten çıkarıldı.");
        } else {
            System.out.println("Görevli bulunamadı.");
        }
    }//gorevliCikar adlı bir method oluşturdum bu method kullanıldıkça gorevliler adlı listeden gorevli silinecek
    // girilen isimle eşleşen bir uye yoksa uye bulunamadı diye dönüt verecek


    public void kitapOduncVer(String uyeAd, String kitapAd) {
        Uye uye = null;
        Kitap kitap = null;

        // Üye ve kitap kontrolü
        for (Uye u : uyeler) {
            if (u.ad.equals(uyeAd)) {
                uye = u;
                break;
            }
        }

        for (Kitap k : kitaplar) {
            if (k.ad.equals(kitapAd) && !k.oduncAlindi) {
                kitap = k;
                break;
            }
        }

        if (uye != null && kitap != null) {
            uye.oduncKitaplar.add(kitap);
            kitap.oduncAlindi = true;
            oduncKitaplar.put(uye, kitap);
            System.out.println(kitapAd + " kitabı, " + uyeAd + " üyesine ödünç verildi.");
        } else {
            System.out.println("Üye veya kitap ismi sistemde bulunamadı.");
        }
    }

    public void kitapGeriAl(String uyeAd, String kitapAd) {
        Uye uye = null;
        Kitap kitap = null;

        // Üye kontrolü
        for (Uye u : uyeler) {
            if (u.ad.equals(uyeAd)) {
                uye = u;
                break;
            }
        }

        // Kitap kontrolü
        for (Kitap k : kitaplar) {
            if (k.ad.equals(kitapAd)) {
                kitap = k;
                break;
            }
        }

        if (uye != null && kitap != null && uye.oduncKitaplar.contains(kitap)) {
            uye.oduncKitaplar.remove(kitap);
            kitap.oduncAlindi = false;
            oduncKitaplar.remove(uye);
            System.out.println(kitapAd + " kitabı, " + uyeAd + " üyesinden geri alındı.");
        } else {
            System.out.println("Üye veya kitap ismi sistemde bulunamadı.");
        }
    }

    public void oduncKitaplariTakipEt() {
        System.out.println("Şu anda ödünç alınan kitaplar:");
        for (Uye u : oduncKitaplar.keySet()) {
            Kitap kitap = oduncKitaplar.get(u);
            System.out.println(u.ad + " - " + kitap.ad);
        }
    }
}

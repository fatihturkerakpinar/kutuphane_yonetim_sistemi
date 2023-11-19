//FATİH TÜRKER AKPINAR - 1220505014
public class Main {
    public static void main(String[] args) {
        Kutuphane kutuphane = new Kutuphane();

        kutuphane.kitapEkle("Kumarbaz");
        kutuphane.kitapEkle("Cesur Yeni Dünya");
        kutuphane.kitapEkle("Veronika Ölmek İstiyor");
        kutuphane.kitapEkle("Erbain");
        kutuphane.kitapEkle("Nutuk");
        kutuphane.kitapCikar("Erbain");

        kutuphane.uyeEkle("Baran");
        kutuphane.uyeEkle("Berkay");
        kutuphane.uyeEkle("Okan");
        kutuphane.uyeEkle("Fatih");
        kutuphane.uyeEkle("Arda");

        kutuphane.uyeCikar("Arda");

        kutuphane.gorevliEkle("Enes");
        kutuphane.gorevliEkle("Emre");
        kutuphane.gorevliEkle("Görkem");
        kutuphane.gorevliEkle("Resul");
        kutuphane.gorevliEkle("Serdar");

        kutuphane.gorevliCikar("Resul");

        kutuphane.kitapOduncVer("Berkay", "Kumarbaz");
        kutuphane.kitapOduncVer("Baran", "Cesur Yeni Dünya");
        kutuphane.kitapOduncVer("Fatih","Erbain");
        kutuphane.kitapOduncVer("Fatih","Nutuk");
        kutuphane.kitapOduncVer("Okan","Veronika Ölmek İstiyor");

        kutuphane.oduncKitaplariTakipEt();

        kutuphane.kitapGeriAl("Berkay", "Kumarbaz");

        kutuphane.oduncKitaplariTakipEt();
    }
}

import java.awt.*;
import java.awt.event.*;

public class HesapMakinesi extends Frame {
    private TextField sayi1Field;
    private TextField sayi2Field;
    private Label sonucLabel;
    private Choice islemSecim;

    public HesapMakinesi() {
        setTitle("Hesap Makinesi");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        Label sayi1Label = new Label("Sayı 1:");
        sayi1Field = new TextField();

        Label sayi2Label = new Label("Sayı 2:");
        sayi2Field = new TextField();

        Label islemLabel = new Label("İşlem:");
        islemSecim = new Choice();
        islemSecim.add("Topla");
        islemSecim.add("Çıkar");
        islemSecim.add("Çarp");
        islemSecim.add("Böl");

        sonucLabel = new Label("Sonuç:");

        add(sayi1Label);
        add(sayi1Field);
        add(sayi2Label);
        add(sayi2Field);
        add(islemLabel);
        add(islemSecim);
        add(sonucLabel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        islemSecim.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                hesapla();
            }
        });

        setVisible(true);
    }

    public void hesapla() {
        try {
            int sayi1 = Integer.parseInt(sayi1Field.getText());
            int sayi2 = Integer.parseInt(sayi2Field.getText());
            String secilenIslem = islemSecim.getSelectedItem();
            double sonuc = 0;

            switch (secilenIslem) {
                case "Topla":
                    sonuc = sayi1 + sayi2;
                    break;
                case "Çıkar":
                    sonuc = sayi1 - sayi2;
                    break;
                case "Çarp":
                    sonuc = sayi1 * sayi2;
                    break;
                case "Böl":
                    if (sayi2 != 0) {
                        sonuc = (double) sayi1 / sayi2;
                    } else {
                        sonucLabel.setText("Bölme işlemi için ikinci sayı sıfır olamaz!");
                        return;
                    }
                    break;
                default:
                    sonucLabel.setText("Geçersiz işlem seçimi!");
                    return;
            }

            sonucLabel.setText("Sonuç: " + sonuc);
        } catch (NumberFormatException ex) {
            sonucLabel.setText("Hatalı giriş!");
        }
    }

    public static void main(String[] args) {
        HesapMakinesi hesapMakinesi = new HesapMakinesi();
    }
}

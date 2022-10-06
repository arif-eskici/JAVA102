package com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static int screenCenterPoint (String eksen, Dimension size) {
        int point;
        switch (eksen) {
            case "x" :
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y" :
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }

    public static boolean isFieldEmpty (JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static void  showMsg(String str) {
        optionPaneTR();
        String msg;
        String title;
        switch (str) {
            case "fill" :
                msg = "Lütfen tüm alanları doldurun!";
                title = "HATA!";
                break;
            case "done" :
                msg = "İşlem Başarılı";
                title = "Sonuç";
                break;
            case "error" :
                msg = "Bir hata oluştu!";
                title = "HATA!";
                break;

            default :
                msg = str;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void optionPaneTR() {

        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }

    public static boolean confirm (String str) {
        optionPaneTR();
        String msg;
        switch (str) {
            case "sure" :
                msg = "Bu işlemi yapmak istediğinize emin misiniz?";
                break;
            default :
                msg = str;
        }
        return JOptionPane.showConfirmDialog(null, msg, "Son Kararın Mı?", JOptionPane.YES_NO_OPTION) == 0;

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package latihanmf4.erest.Controller;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import latihanmf4.erest.Model.Karyawan;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLPenghitungUpahController implements Initializable {

    //Model
    Karyawan krwn = new Karyawan();

    //Curency
    Locale Indonesia = new Locale("in", "ID");
    NumberFormat Rupiah_Formater = NumberFormat.getCurrencyInstance(Indonesia);

    @FXML
    private TextField txtpegawai;
    @FXML
    private CheckBox staffrank;
    @FXML
    private CheckBox Managarrrank;
    @FXML
    private CheckBox Supervisorrank;
    @FXML
    private TextField txthari;
    @FXML
    private Button hitungtn;
    @FXML
    private Button resetbtn;
    @FXML
    private Label Nama;
    @FXML
    private Label Jabatan;
    @FXML
    private Label GajiPok;
    @FXML
    private Label Masukhari;
    @FXML
    private Label Bonus;
    @FXML
    private Label Gajikot;
    @FXML
    private Label Pajak;
    @FXML
    private Label Gajiber;
    @FXML
    private Button Kembalibtn;
    @FXML
    private Button keluarbtn;
    @FXML
    private Tab inputtab;
    @FXML
    private Tab output;
    @FXML
    private TabPane Penghitung_Upah;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        output.setDisable(true);
    }

    @FXML
    private void hitungklik(ActionEvent event) {
        if (txtpegawai.getText().isEmpty()) {
            Alert alt = new Alert(Alert.AlertType.WARNING, "Tolong Masukan Nama Anda", ButtonType.OK);
            alt.showAndWait();
        } else {
            krwn.setNama(txtpegawai.getText());
            krwn.setHari(Integer.parseInt(txthari.getText()));
            double gaji_pokok = 0, pajak = 0, penghargaan = 0, total_penghargaan = 0;
            if (Managarrrank.isSelected()) {
                krwn.setJabatan(Managarrrank.getText());
                Jabatan.setText(krwn.getJabatan());
                if (krwn.getHari() > 24) {
                    penghargaan = 10;
                } else if (krwn.getHari() > 20) {
                    penghargaan = 5;
                } else if (krwn.getHari() > 17) {
                    penghargaan = 2.5;
                }
                gaji_pokok = 2000000;
                pajak = 0;
            } else if (Supervisorrank.isSelected()) {
                krwn.setJabatan(Supervisorrank.getText());
                Jabatan.setText(krwn.getJabatan());
                if (krwn.getHari() > 24) {
                    penghargaan = 20;
                } else if (krwn.getHari() > 20) {
                    penghargaan = 10;
                } else if (krwn.getHari() > 17) {
                    penghargaan = 5;
                }
                gaji_pokok = 1500000;
                pajak = 0;
            } else {
                krwn.setJabatan(staffrank.getText());
                Jabatan.setText(krwn.getJabatan());
                if (krwn.getHari() > 24) {
                    penghargaan = 40;
                } else if (krwn.getHari() > 20) {
                    penghargaan = 20;
                } else if (krwn.getHari() > 17) {
                    penghargaan = 10;
                }
                gaji_pokok = 800000;
                pajak = 0.1;
            }
            total_penghargaan = gaji_pokok * penghargaan;
            double totalgajikotor = gaji_pokok + total_penghargaan;
            double upahpajak = gaji_pokok * pajak;
            double totalupahpajak = totalgajikotor - upahpajak;
            Nama.setText(krwn.getNama());
            GajiPok.setText(Rupiah_Formater.format(gaji_pokok));
            Masukhari.setText(String.valueOf(krwn.getHari()));
            Bonus.setText(Rupiah_Formater.format(total_penghargaan));
            Gajikot.setText(Rupiah_Formater.format(totalgajikotor));
            Pajak.setText(Rupiah_Formater.format(upahpajak));
            Gajiber.setText(Rupiah_Formater.format(totalupahpajak));
            Penghitung_Upah.getSelectionModel().select(1);
            inputtab.setDisable(true);
            output.setDisable(false);
        }
    }

    @FXML
    private void resetbtn(ActionEvent event) {
        Alert alt = new Alert(Alert.AlertType.CONFIRMATION, "Anda Yakin data ini akan direset?", ButtonType.YES, ButtonType.NO);
        alt.showAndWait();
        if (alt.getResult().equals(ButtonType.YES)) {
            txtpegawai.setText("");
            staffrank.setSelected(false);
            Supervisorrank.setSelected(false);
            Managarrrank.setSelected(false);
            txthari.setText("");
            output.setDisable(true);
        }
    }

    @FXML
    private void Kembaliklik(ActionEvent event) {
        Nama.setText("Erest");
        Jabatan.setText("Erest");
        GajiPok.setText("Erest");
        Masukhari.setText("Erest");
        Bonus.setText("Erest");
        Gajikot.setText("Erest");
        Pajak.setText("Erest");
        Gajiber.setText("Erest");
        Penghitung_Upah.getSelectionModel().select(0);
        txtpegawai.setText("");
        staffrank.setSelected(false);
        Supervisorrank.setSelected(false);
        Managarrrank.setSelected(false);
        txthari.setText("");
        output.setDisable(true);
        inputtab.setDisable(false);
    }

    @FXML
    private void Keluarbtn(ActionEvent event) {
        Alert alt = new Alert(Alert.AlertType.CONFIRMATION, "Anda Yakin untuk keluar dari program?", ButtonType.YES, ButtonType.NO);
        alt.showAndWait();
        if (alt.getResult().equals(ButtonType.YES)) {
            System.exit(0);
        }
    }
}

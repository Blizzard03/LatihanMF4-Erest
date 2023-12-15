/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package latihanmf4.erest.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLPenghitungUpahController implements Initializable {

    @FXML
    private TextField txtpegawai;
    @FXML
    private CheckBox direkturrank;
    @FXML
    private CheckBox managerrank;
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
        
        inputtab.setDisable(true);
        output.setDisable(false);
    }

    @FXML
    private void resetbtn(ActionEvent event) {
    }

    @FXML
    private void Kembaliklik(ActionEvent event) {
    }

    @FXML
    private void Keluarbtn(ActionEvent event) {
    }
    
}

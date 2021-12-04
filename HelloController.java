package com.example.fxkodebrikke;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

class KodeGenerator{
    private int[] kodeArray;
    private Random random = new Random();
    private int nyKodeIndeks = 0;

    public KodeGenerator(int antall){
        kodeArray = new int[antall];
        genererKoder();
    }

    private void genererKoder(){
        for(int i = 0; i < kodeArray.length; i++){
            /*int kode = random.nextInt(1000000);
            if(kode < 100000){ kode += 100000; }
            kodeArray[i] = kode;*/
            kodeArray[i] = 100000 + random.nextInt(900000); //smarter
        }
    }

    public String nyKode(int maksAntall){
        if(nyKodeIndeks < maksAntall) {
            return Integer.toString(kodeArray[nyKodeIndeks++]);
        }
        return "Maks antall er 10!";
    }

    public String formaterBrukteKoder(){
        String ut = "";
        for(int i = 0; i < nyKodeIndeks; i++){
            ut += kodeArray[i] + "\n";
        }
        return ut;
    }
}

public class HelloController {
    public final int MAKS_ANTALL = 10;
    private KodeGenerator kodeGenerator = new KodeGenerator(MAKS_ANTALL);

    @FXML
    private Label lblGamlekode;

    @FXML
    private Label lblNykode;

    @FXML
    void btnGamleKode(ActionEvent event) {
        lblGamlekode.setText(kodeGenerator.formaterBrukteKoder());
    }

    @FXML
    void btnNyKode(ActionEvent event) {
        lblNykode.setText(kodeGenerator.nyKode(MAKS_ANTALL));
    }

}


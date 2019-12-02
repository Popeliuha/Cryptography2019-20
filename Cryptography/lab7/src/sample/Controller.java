package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigInteger;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField vP;
    public TextField vA;
    public TextArea vAOut;
    public TextArea vBOut;

    public void generateKey(ActionEvent actionEvent) {
        BigInteger p = new BigInteger(vP.getText());
        BigInteger a = new BigInteger(vA.getText());
        A A = new A(a,p);
        B B = new B(a,p);
        B.setbX(A.generateX());
        A.setbY(B.generateY());
        vAOut.setText(vAOut.getText()+'\n' + "Generate x : " + A.getX());
        vAOut.setText(vAOut.getText()+'\n' + "Generate X : " + A.getbX());
        vBOut.setText(vBOut.getText()+'\n' + "Generate y : " + B.getY());
        vBOut.setText(vBOut.getText()+'\n' + "Generate B : " + B.getbY());
        A.generateK();
        B.generateK();
        vAOut.setText(vAOut.getText()+'\n' + "Generate key : " + A.getK());
        vBOut.setText(vBOut.getText()+'\n' + "Generate key : " + B.getK());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boolean interrupted = false;
        Random random = new Random();
        while (!interrupted){
           int k = random.nextInt(9999)+1000;
                if(k%2!=0 && k%3!=0 && k%5!=0 && k%7!=0){
                    interrupted = true;
                    vP.setText(k+"");
                }
        }
    }
}

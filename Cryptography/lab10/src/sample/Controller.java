package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField vKey;
    public Text vMessage;
    public Text vInput;
    public Text vOutput;
    File inputFile;
    File outputFile;
    public void open(ActionEvent actionEvent) {
        inputFile = new FileChooser().showOpenDialog(new Stage());
        vInput.setText(inputFile.getName());
    }

    public void encrypt(ActionEvent actionEvent) {
        try {
            checkExistingFile();
            String key = vKey.getText(); // needs to be at least 8 characters for DES
            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile);
            encrypt(key, fis, fos);
            vMessage.setText("Succes encrypt. Result in " + outputFile.getName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
    }

    public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
    }

    public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {

        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE

        if (mode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            doCopy(cis, os);
        } else if (mode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            CipherOutputStream cos = new CipherOutputStream(os, cipher);
            doCopy(is, os);
        }
    }

    public static void doCopy(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = new byte[64];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            os.write(bytes, 0, numBytes);
        }
        os.flush();
        os.close();
        is.close();
    }

    public void decrypt(ActionEvent actionEvent) {
        checkExistingFile();
        String key = vKey.getText(); // needs to be at least 8 characters for DES
        FileInputStream fis2 = null;
        try {
            fis2 = new FileInputStream(inputFile);
            FileOutputStream fos2 = new FileOutputStream(outputFile);
            decrypt(key, fis2, fos2);
            vMessage.setText("Succes decrypt. Result in " + outputFile.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public void openOutput(ActionEvent actionEvent) {
        outputFile = new FileChooser().showOpenDialog(new Stage());
        vOutput.setText(outputFile.getName());
    }
    public void checkExistingFile(){
        if (inputFile == null){
            inputFile = new File("1.txt");
        }
        if (outputFile == null){
            outputFile = new File("2.txt");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

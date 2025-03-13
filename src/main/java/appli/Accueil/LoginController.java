package appli.Accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label yourmail;

    @FXML
    private Label yourmdp;

    @FXML
    private Label titre;

    @FXML
    private Label error;

    @FXML
    private TextField entermail;

    @FXML
    private TextField entermdp;


    @FXML
    protected void onConnexionButtonClick() {

        System.out.println(entermail.getText());
        System.out.println(entermdp.getText());

        if (entermail.getText().equals("pomme@gmail.com") && entermdp.getText().equals("Azerty1234")) {
            System.out.println("Connexion !");
            error.setText("Vous avez réussi à vous connecter");
        }else{
            System.out.println("Connexion refusé");
            error.setText("Erreur: Email ou mot de passe incorrect");
        }
    }


    @FXML
    protected void onInscriptionButtonClick() throws IOException {
        StartApplication.changeScene("Accueil/Signin");
        error.setText("Vous êtes en redirection.");
    }

    @FXML
    protected void onmdpoublieButtonClick() {

        error.setText("Force à toi");
    }


}
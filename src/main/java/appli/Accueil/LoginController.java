package appli.Accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

        error.setText("Vous avez réussi à vous connecter");
    }


    @FXML
    protected void onInscriptionButtonClick() {

        error.setText("Vous êtes en redirection.");
    }

    @FXML
    protected void onmdpoublieButtonClick() {

        error.setText("Force à toi");
    }

}
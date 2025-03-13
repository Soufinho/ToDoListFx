package appli.Accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SigninController  {
    @FXML
    private Label inscription;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label email;
    @FXML
    private Label mdp;
    @FXML
    private Label confirm;
    @FXML
    private PasswordField getmdp;
    @FXML
    private PasswordField getconfirm;
    @FXML
    private TextField getemail;
    @FXML
    private TextField getnom;
    @FXML
    private TextField getprenom;
    @FXML
    private Label erreur;


    @FXML
    protected void onInscriptionButtonClick() {

        System.out.println(getemail.getText());
        System.out.println(getmdp.getText());

        if (getemail.getText().equals("pomme@gmail.com") && getmdp.getText().equals("Azerty1234")) {
            System.out.println("Inscription OK !");
            erreur.setText("Vous avez réussis à vous inscrire");
        }else{
            System.out.println("Inscription refusé.");
            erreur.setText("Erreur: Remplissez bien tout les champs.");
        }
    }

    protected void onBretourButtonClick() {
       System.out.println("Retour réussi");
       erreur.setText("Retour effectué");
    }
}

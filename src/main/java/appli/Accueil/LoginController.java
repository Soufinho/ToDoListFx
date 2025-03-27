package appli.Accueil;

import Repository.UtilisateurRep;
import model.Utilisateur;
import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

public class LoginController {
    private UtilisateurRep utilisateurRepository = new UtilisateurRep();
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
    protected void onConnexionButtonClick() throws IOException {

        System.out.println(entermail.getText());
        System.out.println(entermdp.getText());
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurParEmail(entermail.getText());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (utilisateur == null) {
            System.out.println("Aucun utilisateur trouvé");
            error.setText("Utilisateur non trouvé");
        }else if(utilisateur != null && encoder.matches((CharSequence) entermdp,utilisateur.getMdp() )){
            System.out.println("Connexion reussi");
            error.setText("Vous avez réussi à vous connecter");
            StartApplication.changeScene("Accueil");
            error.setText("Vous êtes en redirection.");
        }else {
            error.setText("Le mot de passe est incorrect");
            System.out.println("Le mot de passe est incorrect");
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
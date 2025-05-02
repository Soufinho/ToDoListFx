package appli.Accueil;

import Repository.UtilisateurRep;
import model.Utilisateur;
import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import session.SessionUtilisateur;
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
        if (utilisateur != null && encoder.matches(entermdp.getText(), utilisateur.getMdp())) {
            System.out.println("Connexion réussie pour : " + utilisateur.getNom());
            SessionUtilisateur.getInstance().sauvegardeSession(utilisateur);
            error.setVisible(false);
            // Redirection possible vers une autre page
        } else {
            System.out.println("Échec de la connexion. Email ou mot de passe incorrect.");
            error.setText("Email ou mot de passe incorrect.");
            error.setVisible(true);
        }
        Utilisateur utilisateurActuel = SessionUtilisateur.getInstance().getUtilisateur();
        if (utilisateurActuel != null) {
            System.out.println("Utilisateur connecté : " + utilisateurActuel.getNom());
            StartApplication.changeScene("Accueil/GestionUser");
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
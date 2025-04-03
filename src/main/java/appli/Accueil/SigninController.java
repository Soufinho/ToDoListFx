package appli.Accueil;

import Repository.UtilisateurRep;
import model.Utilisateur;
import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

public class SigninController  {
    private UtilisateurRep utilisateurRepository = new UtilisateurRep();
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
        System.out.println(getconfirm.getText());
        System.out.println(getnom.getText());
        System.out.println(getprenom.getText());
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurParEmail(getemail.getText());
        System.out.println(utilisateur);
        if(getemail.getText().isEmpty() || getmdp.getText().isEmpty() || getconfirm.getText().isEmpty() || getnom.getText().isEmpty()) {
            System.out.println("Inscription refusé.");
            erreur.setText("Tous les champs doivent être remplis");
        } else if (!getmdp.getText().equals( getconfirm.getText())) {
            System.out.println("Inscription refusé.");
            erreur.setText("Les mots de passes doivent correspondre");
        } else if(utilisateur != null) {
            System.out.println("Inscription refusé.");
            erreur.setText("L'email existe deja dans la base");
        }else{
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashedPassword = encoder.encode(getmdp.getText());
            utilisateur = new Utilisateur(getnom.getText(),getprenom.getText(),getemail.getText(),hashedPassword,"utilisateur");
            utilisateurRepository.ajouterUtilisateur(utilisateur);
        }
    }

    @FXML
    protected void onBretourButtonClick() throws IOException {
        StartApplication.changeScene("Accueil/Login");
        System.out.println("Retour réussi");
       erreur.setText("Retour effectué");
    }
}

package appli.Accueil;

import Repository.UtilisateurRep;
import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Utilisateur;

import java.io.IOException;
import java.lang.classfile.Label;

public class ModificationUserController {

    @FXML
    private TextField modifnom;
    @FXML
    private TextField modifprenom;
    @FXML
    private TextField modifemail;
    @FXML
    private TextField modifrole;

    private Utilisateur utilisateurSel;


    public void initData(Utilisateur utilisateur) {
        this.utilisateurSel = utilisateur;
        modifnom.setText(utilisateur.getNom());
        modifprenom.setText(utilisateur.getPrenom());
        modifemail.setText(utilisateur.getEmail());
        modifrole.setText( utilisateur.getRole());
    }


    public void clickannuler (ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("Accueil/GestionUser");
        System.out.println("Vous êtes en cours de redirection");
    }
}

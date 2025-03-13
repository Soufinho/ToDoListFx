package model;

import javafx.application.Application;
import javafx.stage.Stage;

public class Utilisateur extends Application {
    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    public static void main(String[] args) {

        launch(args);
    }

public Utilisateur(String nom, String prenom, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
}


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

     public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
     }

    public void setEmail(String email) {
        this.email = email;
     }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public void start(Stage primaryStage) {

    }
}

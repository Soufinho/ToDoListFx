package model;

import javafx.application.Application;
import javafx.stage.Stage;

public abstract class Utilisateur extends Application {
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private int id;
    private String role;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    public Utilisateur(String nom, String prenom, String email, String mdp, int id, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.id = id;
        this.role = role;
}

public Utilisateur(String nom, String prenom, String email, String mdp, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
}

public Utilisateur(String mdp, String email) {
        this.mdp = mdp;
        this.email = email;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

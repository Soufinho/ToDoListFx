package session;

import javafx.fxml.FXML;
import model.Utilisateur;


public class SessionUtilisateur {

    @FXML
    protected void handleLogout() {
        SessionUtilisateur.getInstance().deconnecter();
        System.out.println("Utilisateur déconnecté.");
        // Redirection vers la page de connexion
    }


    private static SessionUtilisateur instance;
    private Utilisateur utilisateurConnecte;
    private SessionUtilisateur() { }
    public static SessionUtilisateur getInstance() {
        if (instance == null) {
            instance = new SessionUtilisateur();
        }
        return instance;
    }
    public void sauvegardeSession(Utilisateur utilisateur) {
        if (this.utilisateurConnecte == null) {
            this.utilisateurConnecte = utilisateur;
        }
    }
    public Utilisateur getUtilisateur() {
        return utilisateurConnecte;
    }
    public void deconnecter() {
        utilisateurConnecte = null;
    }
}

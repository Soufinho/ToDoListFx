package Repository;


import javafx.scene.control.TableView;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static database.Database.getConnexion;


public class UtilisateurRep {
    private Connection connexion;

    public UtilisateurRep() {
        this.connexion= getConnexion();
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mot_de_passe, role) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    public Utilisateur getUtilisateurParEmail(String email) {
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new Utilisateur(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ArrayList<Utilisateur> getTousLesUtilisateurs() {
        String sql = "SELECT * FROM utilisateur";
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Utilisateur u = new Utilisateur(
                        rs.getInt("id_utilisateur"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe"),
                        rs.getString("role")
                );
                utilisateurs.add(u);
            }
            return utilisateurs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void supprimerUtilisateurParEmail(String email) {
        String sql = "DELETE FROM utilisateur WHERE email = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                new Utilisateur(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mdp"),
                        rs.getString("role")
                );
                System.out.println("L'utilisateur a été supprimé.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mettreAJourUtilisateur(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, role = ? WHERE email = ?";
        try{
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getRole());
            stmt.setString(4, utilisateur.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

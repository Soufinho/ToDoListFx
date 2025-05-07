package appli.Accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GestionUserController implements Initializable {
    @FXML
    private TableView<Utilisateur> tableauUser;

    @FXML
    private Button deco;

    @FXML
    private Button supp;

    @FXML
    void cliqueTableauEvent(MouseEvent event) throws IOException {
        Utilisateur selection = tableauUser.getSelectionModel().getSelectedItem();
        if (selection != null) {
            supp.setDisable(false);
        }else{
            supp.setDisable(true);
        }

        if (event.getClickCount() == 2) { // Vérifie si c'est un double-clic
            if (selection != null) {
                StartApplication.changeScene("Accueil/ModificationUser");
                ModificationUserController controller = (ModificationUserController)
                        StartApplication. getControllerFromStage();
                controller.initData(selection);
            }
        }

    }

    @FXML
    protected void onDeconnexionButtonClick() throws IOException {
        StartApplication.changeScene("Accueil/Login");
        System.out.println("Vous êtes en cours de redirection");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String [][] colonnes = new String[][]{
                {"Id Utilisateur", "idUser"},
                {"Nom", "nom"},
                {"Prénom", "prenom"},
                {"Email", "mail"},
                {"Rôle", "role"},
        };

        for ( int i = 0 ; i < colonnes.length ; i ++ ){
            //Création de la colonne avec le titre
            TableColumn<Utilisateur,String> maCol = new TableColumn<>(colonnes[i][0]);
            //Ligne permettant la liaison automatique de la cellule avec la propriété
            maCol.setCellValueFactory(
                    new PropertyValueFactory<Utilisateur,String>(colonnes[i][1]));
            //Ajout de la colonne dans notre tableau
            tableauUser.getColumns().add(maCol);
        }
    }
}


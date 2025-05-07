package model;


public  class Utilisateur  {
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private int idUser;
    private String role;


    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", id=" + idUser +
                ", role='" + role + '\'' +
                '}';
    }

    public Utilisateur( int id,String nom, String prenom, String email, String mdp, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.idUser = id;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

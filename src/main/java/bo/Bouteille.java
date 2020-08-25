package bo;

import javax.persistence.*;

@Entity
public class Bouteille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String millesime;
    private boolean isPetillant;
    private int quantite;

    @ManyToOne
    private Couleur couleur;

    @ManyToOne
    private Region region;

    public Bouteille() {
    }

    public Bouteille(String nom, String millesime, boolean isPetillant, int quantite, Couleur couleur, Region region) {
        this.nom = nom;
        this.millesime = millesime;
        this.isPetillant = isPetillant;
        this.quantite = quantite;
        this.couleur = couleur;
        this.region = region;
    }

    public Bouteille(int id, String nom, String millesime, boolean isPetillant, int quantite, Couleur couleur, Region region) {
        this.id = id;
        this.nom = nom;
        this.millesime = millesime;
        this.isPetillant = isPetillant;
        this.quantite = quantite;
        this.couleur = couleur;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getIsPetillant() {
        return isPetillant;
    }

    public void setIsPetillant(boolean isPetillant) {
        this.isPetillant = isPetillant;
    }

    public String getMillesime() {
        return millesime;
    }

    public void setMillesime(String millesime) {
        this.millesime = millesime;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Bouteille{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", isPetillant=" + isPetillant +
                ", millesime='" + millesime + '\'' +
                ", quantite=" + quantite +
                ", region=" + region +
                ", couleur=" + couleur +
                '}';
    }
}

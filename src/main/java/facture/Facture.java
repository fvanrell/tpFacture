package facture;

import java.io.PrintStream;
import java.util.Date;
import java.util.LinkedList;

public class Facture {

    private Client destinataire;
    private Date emission;
    private int numero;
    private LinkedList<LigneFacture> lignesfacture;
    
    public Facture(Client destinataire, Date emission, int numero) {
        this.destinataire = destinataire;
        this.emission = emission;
        this.numero = numero;
        this.lignesfacture = new LinkedList<>();
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Get the value of emission
     *
     * @return the value of emission
     */
    public Date getEmission() {
        return this.emission;
    }

    /**
     * Get the value of destinataire
     *
     * @return the value of destinataire
     */
    public Client getDestinataire() {
        return this.destinataire;
    }


    
    public void ajouteLigne(Article a, int nombre, float remise) {
        LigneFacture ligne = new LigneFacture(nombre,this,a,remise);
        lignesfacture.add(ligne);
   }
    
   public float montantTTC(float tauxTVA) {
        float montant = 0;
        for (LigneFacture l : lignesfacture){
            montant+=l.montantLigne()*(1+tauxTVA);
        }
        return montant;
   }
   
   public void print(PrintStream out, float tva) {
        out.println("Destinataire :" + this.destinataire + "\n Date d'emission" + emission+ "\n Numero de facture :" + numero+ "\n Tva :" + tva + "\n Details de la facture :" +lignesfacture );
   }
   
}

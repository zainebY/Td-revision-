import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Voiture voiture1 = new Voiture(1, "Peugot", 22.0f);
        Voiture voiture2 = new Voiture(2, "BMW", 650.5f);
        Voiture voiture3 = new Voiture(3, "Nessan", 69.4f);

        Client client1 = new Client(111, "Baldi", "Maryem");
        Client client2 = new Client(222, "Yaich", "Zaineb");

        Agence agence = new Agence("Agence De Location ");
        try {
            agence.ajoutVoiture(voiture1);
            agence.ajoutVoiture(voiture2);
            agence.ajoutVoiture(voiture3);
        } catch (VoitureException e) {
            System.out.println("Erreur lors de l'ajout de la voiture : " + e.getMessage());
        }
        try {
            agence.loueClientVoiture(client1, voiture1);
            agence.loueClientVoiture(client1, voiture2);
            agence.loueClientVoiture(client2, voiture3);
        } catch (VoitureException e) {
            System.out.println("Erreur lors de l'ajout de la voiture : " + e.getMessage());
        }
        System.out.println("Liste des clients et de leurs voitures louées :");
        agence.afficheLesClientsEtLeursListesVoitures();
        System.out.println("\nListe des voitures louées par critère marque Ford :");
        Critere critereMarque = new CritereMarque("Toyota");
        List<Voiture> voituresSelonCritere = agence.selectVoitureSelonCritere(critereMarque);
        for (Voiture v : voituresSelonCritere) {
            System.out.println(v.toString());
        }
        System.out.println("\nClients triés par nom :");
        Map<Client, ListVoitures> clientsTriesParNom = agence.triNomCroissant();
        for (Map.Entry<Client, ListVoitures> entry : clientsTriesParNom.entrySet()) {
            System.out.println(entry.getKey().toString());
        }
    }
}
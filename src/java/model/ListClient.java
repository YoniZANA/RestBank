package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListClient {
    private final List<Client> listClient;
    
    public ListClient(){
        this.listClient = new ArrayList<Client>();
        // Ajout d'un premier client
        this.ajouterClientDansListe(new Client(1, "Etienne", "Lopvet"));
    }
    
    /**
     * Ajouter un client dans la listeClient
     * @param client 
     */
    public void ajouterClientDansListe (Client client) {
        this.listClient.add(client);
    }
    
    /**
     * Modification d'un client
     * @param client
     * @throws Exception 
     */
    public void modifierClient (Client client) throws Exception{
        Client savedClient = consulterClient(client.getId());
        savedClient.setNom(client.getNom());
        savedClient.setPrenom(client.getPrenom());
    }
    
    /**
     * Récuperation d'un client
     * @param id
     * @return
     * @throws Exception 
     */
    public Client consulterClient(int id) throws Exception{
        for (Client client: listClient){
            if(client.getId() == id)
                return client;
        }
        throw new Exception("Client not found");
    }
    
    /**
     * Récuperation de tous les clients
     * @return 
     */
    public List<Client> consulterListeClient (){
        return this.listClient;
    }
    
    /**
     * Suppression d'un client
     * @param id
     * @throws Exception 
     */
    public void supprimerClient (int id) throws Exception{
        Client client = consulterClient(id);
        listClient.remove(client);
    } 
    
    
}

package restBankAPI;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import model.Client;
import model.ListClient;


@Path("rest")
public class RestResource {

    ListClient listClient ;
    public RestResource (){
        listClient = ListClientSingleton.getInstance();
    }
    
    /**
     * Récupération de la liste des clients
     * @return 
     */
    @GET
    @Path("clients")
    @Produces("application/xml")
    public List<Client> getListClient() {
       return listClient.consulterListeClient();
    }
    
    /**
     * Ajout d'un client
     * @param client 
     */
    @POST
    @Path("client")
    @Consumes("application/xml")
    public void createClient(Client client) {
        listClient.ajouterClientDansListe(client);
    }
    
    /**
     * Modification d'un client (en fonction de son id)
     * @param client 
     */
    @PUT
    @Path("client")
    @Consumes("application/xml")
    public void modifyClient(Client client) {
        try {
            listClient.modifierClient(client);
        } catch (Exception ex) {
            Logger.getLogger(RestResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Récupération d'un client
     * @param id l'id du client
     * @return 
     */
    @GET
    @Path("client/{id}")
    @Produces("application/xml")
    public Client getClient(@PathParam("id") int id) {
        Client client = null;
        try {
            client = listClient.consulterClient(id);
        } catch (Exception ex) {
            Logger.getLogger(RestResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
    
    /**
     * Suppression d'un client
     * @param id l'id du client à supprimer
     */
    @DELETE
    @Path("client/delete/{id}")
    public void deleteClient(@PathParam("id") int id) {
        try {
            listClient.supprimerClient(id);
        } catch (Exception ex) {
            Logger.getLogger(RestResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
   
    
    
    
    

package restBankAPI;

import model.ListClient;

public class ListClientSingleton {
    
    private ListClientSingleton() {}
    
    private static ListClient INSTANCE = null;
    
    /**
     * Pour récupérer qu'une instance de la listeClient
     * @return renvoit l'instance de la listeClient
     */
    public static ListClient getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ListClient();
        }
        return INSTANCE;
    }
}

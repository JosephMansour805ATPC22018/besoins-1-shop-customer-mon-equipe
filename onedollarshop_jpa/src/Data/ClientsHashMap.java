/*
 * Copyright (C) 2018 mansourjo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Data;

import Entities.Client;
import Entities.ClientJpaController;
import Entities.exceptions.NonexistentEntityException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mansourjo
 */
public class ClientsHashMap implements ClientInterface {

    String contenu = "";
    static HashMap<String, Client> clientsHM;

    static {
        clientsHM = new HashMap<>();

    }

    public ClientsHashMap() {

    }

    @Override
    public String toString() {

        return contenu;
    }

    @Override
    public void createClient(Client client) {

       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onedollarshop_jpaPU");
        ClientJpaController cjc = new ClientJpaController(emf);

        try {
            cjc.create(client);

        } catch (Exception ex) {
            Logger.getLogger(ClientsHashMap.class.getName()).log(Level.SEVERE, null, ex);
        }
         clientsHM.put(client.getId(), client);
    }

    @Override
    public Client findClient(String id) {
        //Si les infos ne sont pas dans le HashMap
        if (!clientsHM.containsKey(id)) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("onedollarshop_jpaPU");
            ClientJpaController cjc = new ClientJpaController(emf);
            Client client = cjc.findClient(id);

            clientsHM.put(client.getId(), client);
        }

        return clientsHM.get(id);
    }

    @Override
    public void removeClient(String id) {
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("onedollarshop_jpaPU");
        ClientJpaController cjc = new ClientJpaController(emf);
        try {
            cjc.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClientsHashMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateClient(Client client) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onedollarshop_jpaPU");
        ClientJpaController cjc = new ClientJpaController(emf);

        try {
            cjc.edit(client);

        } catch (Exception ex) {
            Logger.getLogger(ClientsHashMap.class.getName()).log(Level.SEVERE, null, ex);
        }      
        clientsHM.put(client.getId(), client);

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

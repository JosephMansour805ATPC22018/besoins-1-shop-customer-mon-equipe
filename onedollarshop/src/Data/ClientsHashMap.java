/*
 * Copyright (C) 2018 Lenovo
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

import TP0.Client;
import TP1.boundary.GlobalParam;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ClientsHashMap implements ClientInterface {

    String contenu = "";
    static HashMap<String, Client> clientsHM;

    static {
        clientsHM = new HashMap<>();

    }

    @Override
    public String toString() {

        return contenu;
    }

    @Override
    public void createClient(Client c, String dir) {

        String _id = c.getId();
        clientsHM.put(c.getId(), c);
        Gson gson = new Gson();
        String json = gson.toJson(c);
        //sauvegarder les infos dans un fichier
        File file;
        file = new File(dir + _id + ".json");
        if (file.exists()) {
            contenu = "ID " + _id + " déjà existe";
        } else {
            try {
                file.createNewFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(json);
                    contenu = "Client crée: " + json;
                } catch (IOException e) {
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientsHashMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client findClient(String id) {
        //Si les infos ne sont pas dans le HashMap
        if (!clientsHM.containsKey(id)) {
            String dirFichier = GlobalParam.BASE_DIR + id.substring(0, 3) + "\\" + id.substring(3, 6) + "\\";
            File f = new File(dirFichier + id + ".json");
            if (f.exists() && !f.isDirectory()) {
                BufferedReader br = null;
                FileReader fr = null;
                try {
                    fr = new FileReader(f);
                    br = new BufferedReader(fr);
                    String sCurrentLine;
                    contenu = "";
                    while ((sCurrentLine = br.readLine()) != null) {
                        contenu += sCurrentLine;
                    }
                } catch (IOException e) {
                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                        if (fr != null) {
                            fr.close();
                        }
                    } catch (IOException ex) {
                    }
                }
                Gson gson = new Gson();
                Client client = gson.fromJson(contenu, Client.class);
                String _id = client.getId();
                clientsHM.put(client.getId(), client);
            }

        }
        return clientsHM.get(id);
    }

    @Override
    public void removeClient(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateClient(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

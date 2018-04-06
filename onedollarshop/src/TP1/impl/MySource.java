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
package TP1.impl;

import TP0.Client;
import java.io.IOException;
import TP1.GEvent;
import TP1.Source;
import TP1.boundary.MenuConsulterClient;
import TP1.boundary.MenuCreerClient;
import TP1.boundary.MenuMajClient;
import TP1.boundary.MenuPrincipal;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pfares
 */
public class MySource {

    /**
     * @param args
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        afficher_menu_principal();
    }

    static void afficher_menu_principal() throws IOException, InterruptedException {
        Source<String> source = new Source<>();
        source.addGEventListener((GEvent ev) -> {
            try {
                Acter_Choix(ev.getData().toString());
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(MySource.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Thread t = new Thread(new MenuPrincipal(source));
        t.start();
        t.join();

    }

    //Afficher le menu approprié au choix
    static void Acter_Choix(String choix) throws IOException, InterruptedException {
        Source<String> source = new Source<>();
        String evenement, info = "";
        int separateur = choix.indexOf("::"); //positionnement de :: entre le nom d'evenment et les infos fournis
        if (separateur == -1) {
            evenement = choix;
        } else {
            evenement = choix.substring(0, separateur);
            info = choix.substring(separateur + 2);
        }
        //  System.out.println("evenement:"+evenement+" info:"+info);

        switch (evenement) {
            //mcc(menu créer client) save(sauvegarder les infos du nouveau client)
            case "ev_mcc_save":
                //info contient les info du nouveau client
                int nbf = info.split("\\-", -1).length - 1; //capturer le nombre de -
           
                if (nbf < 2) {
                    System.out.println("Au minimum les colonnes ID, Prenom et Nom doivent etre saisies");
                } else {
                    String[] Infos = info.split("\\-");
                    String ID = Infos[0];
                    String Prenom = Infos[1];
                    String Nom = nbf >= 2 ? Infos[2] : "";
                    String Telephone = nbf >= 3 ? Infos[3] : "";
                    String Rue = nbf >= 4 ? Infos[4] : "";
                    String Ville = nbf >= 5 ? Infos[5] : "";
                    String Etat = nbf >= 6 ? Infos[6] : "";
                    String Code = nbf >= 7 ? Infos[7] : "";
                    String Pays = nbf >= 8 ? Infos[8] : "";
                    String Mail = nbf >= 9 ? Infos[9] : "";

                    Client client1;
                    client1 = new Client.ClientBuilder(ID, Prenom, Nom).ville(Ville).etat(Etat).code(Code).pays(Pays).mail(Mail).build();

                    //Afficher le resultat de la'operation creer client
                    System.out.println(client1);

                }
                //retour au menu créer client
                Acter_Choix("ev_mp_cc");

            //mcoc(menu consulter client) fetch(chercher les infos du client)
            case "ev_mcoc_fetch":
                Client client1=new Client(info);
                client1.readJsonFile();
                System.out.println(client1);
                
                //retour au menu consulter client
                Acter_Choix("ev_mp_coc");

            //mp(menu principal) cc(créer client)
            case "ev_mp_cc":
                source.addGEventListener((GEvent ev) -> {
                    try {
                        Acter_Choix(ev.getData().toString());
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(MySource.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                Thread tc = new Thread(new MenuCreerClient(source));
                tc.start();
                tc.join();
                break;

            //mp(menu principal) mjc(mettre à jour client)
            case "ev_mp_mjc":
                source.addGEventListener((GEvent ev) -> {
                    try {
                        Acter_Choix(ev.getData().toString());
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(MySource.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                Thread tm = new Thread(new MenuMajClient(source));
                tm.start();
                tm.join();
                break;

            //mp(menu principal) coc(consulter client)    
            case "ev_mp_coc":
                source.addGEventListener((GEvent ev) -> {
                    try {
                        Acter_Choix(ev.getData().toString());
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(MySource.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                Thread tco = new Thread(new MenuConsulterClient(source));
                tco.start();
                tco.join();
                break;

            //sortie du système    
            case "ev_ss":
                System.exit(0);

            //retour au menu principal
            default:
                afficher_menu_principal();
        }
    }

}

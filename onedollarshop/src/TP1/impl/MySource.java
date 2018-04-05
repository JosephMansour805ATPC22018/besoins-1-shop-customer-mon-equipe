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

import java.io.IOException;
import TP1.GEvent;
import TP1.Source;
import TP1.boundary.MenuConsulterClient;
import TP1.boundary.MenuCreerClient;
import TP1.boundary.MenuMajClient;
import TP1.boundary.MenuPrincipal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.script.ScriptEngine.FILENAME;

/**
 *
 * @author pfares
 */
public class MySource {
   
    
    

    /**
     * @param args 
     * @throws java.io.IOException
     */
     
    public static void main(String[] args) throws IOException, InterruptedException {
        afficher_menu_principal();
    }
     
    static void afficher_menu_principal()        throws IOException, InterruptedException {
         Source<String> source = new Source<>();
         source.addGEventListener((GEvent ev) -> {
            try {
                Acter_Choix(ev.getData().toString());
            } catch (IOException ex) {
                Logger.getLogger(MySource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MySource.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

           Thread t = new Thread(new MenuPrincipal(source));
        t.start();
        t.join();
        
    }
    
    //Afficher le menu approprié au choix
    static void Acter_Choix(String choix) throws IOException, InterruptedException  {
        Source<String> source = new Source<>();
       String evenement,info="";
       int separateur=choix.indexOf("::"); //positionnement de :: entre le nom d'evenment et les infos fournis
       if (separateur==-1)  evenement=choix;
       else {
           evenement=choix.substring(0,separateur);
           info=choix.substring(separateur+2);
       }
     //  System.out.println("evenement:"+evenement+" info:"+info);
       
        switch(evenement) {
            //mcc(menu créer client) save(sauvegarder les infos du nouveau client)
            case "ev_mcc_save":
                //info contient les info du nouveau client
                String[] Infos = info.split("\\-");
                String ID = Infos[0];
//                String Prenom = Infos[1];
//                String Nom = Infos[2];
//                String Telephone = Infos[3];
//                String Rue = Infos[4];
//                String Ville = Infos[5];
//                String Etat = Infos[6];
//                String Code = Infos[7];
//                String Pays = Infos[8];
//                String Email = Infos[9];
                
                //Specify the file name and path here
                File file = new File("D:\\Java\\" + ID + ".txt");

                /* This logic will make sure that the file 
                 * gets created if it is not present at the
                 * specified location*/
                 if (!file.exists()) {
                    file.createNewFile();
                 }
                 else{
                     System.out.println("ID already found");
                    break;
                 }
                 
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    
                        String content = info;
			bw.write(content);
			
			// no need to close it.
			//bw.close();

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}
                break;
            //mcoc(menu consulter client) fetch(chercher les infos du client)
            case "ev_mcoc_fetch":
                File f = new File("D:\\Java\\" + info + ".txt");
                if(f.exists() && !f.isDirectory()) { 
                    BufferedReader br = null;
                    FileReader fr = null;

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

                }
                else{
                    System.out.println("Id Not found");
                }
                break;
                
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
            default:afficher_menu_principal();
        }
    }
        
    
    
}
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
import java.util.Scanner;
import TP1.GEvent;
import TP1.Source;
import TP1.boundary.CreerClient;
import TP1.boundary.MenuPrincipal;
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
        //mp(menu principal) cc(créer client)
        if (choix =="ev_mp_cc"){ 
        source.addGEventListener((GEvent ev) -> {
            try {
                Acter_Choix(ev.getData().toString());
            } catch (IOException ex) {
                Logger.getLogger(MySource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MySource.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            new CreerClient(source).run();
        }
        
        if (choix=="ev_rmp") afficher_menu_principal();     
        if (choix=="ev_ss") System.exit(0); //sortie du système
    }
    
    
}
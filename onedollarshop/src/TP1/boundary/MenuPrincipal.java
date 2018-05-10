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
package TP1.boundary;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import TP1.GEvent;
import TP1.Source;
import TP0.Client;

/**
 *
 * @author pfares
 */
public class MenuPrincipal implements Runnable {

    Source eventManager;

    public MenuPrincipal(Source<String> s) {
        eventManager = s;
    }

    public int menu() throws IOException {

        int selection;
        //Ceci efface en principe un écran (console) Linux et Windows
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);

        /**
         * ************************************************
         */
        System.out.println("0 - Quitter");
        System.out.println("-------------------------");
        System.out.println("1 - Créer");
        System.out.println("2 - Consulter");
        System.out.println("3 - Mise à jour");
        System.out.println("4 - Supprimer");
        System.out.print("Choisir : ");

        selection = input.nextInt();
        return selection;
    }

    @Override
    public void run() {
        int choix;
        GEvent ev=eventManager.genEvent("ev_rmp");  //aucune réponse connue
        try {
 //   while ((choix = menu()) != 0) { 
    choix = menu(); 
                switch (choix) {
                    case 1:
                        ev = eventManager.genEvent("ev_mp_cc");  //mp(menu principal) cc(créer client)
                        break;
                    case 2:
                        ev = eventManager.genEvent("ev_mp_coc"); //mp(menu principal) mjc(mise a jour client)
                        break;
                    case 3:
                        ev = eventManager.genEvent("ev_mp_mjc"); //mp(menu principal) mjc(mise a jour client)
                        break;
                    case 0:
                        ev = eventManager.genEvent("ev_ss"); //sortir du système
                        break;
                }
                if (ev != null) {
                    eventManager.dispatch(ev);
                }
      //      }
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
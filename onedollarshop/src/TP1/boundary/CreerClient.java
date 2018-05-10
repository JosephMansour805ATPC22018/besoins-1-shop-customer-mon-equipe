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

/**
 *
 * @author pfares
 */
public class CreerClient implements Runnable {

    Source eventManager;

    public CreerClient(Source<String> s) {
        eventManager = s;
    }

    public String client_cols() throws IOException {

        String selection;
        //Ceci efface en principe un écran (console) Linux et Windows
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);

        /**
         * ************************************************
         */
        System.out.println("---Créer un Client--(0 pour revenir --------------------");
        System.out.println("Usage: ID - Prenom - Nom");
        System.out.print("Saisir les info: ");
        selection = input.nextLine();
        return selection;
    }

    @Override
    public void run() {
        String  client_info;
        GEvent ev=eventManager.genEvent("Aucune réponse connue");
        try {
    //        while ((choix = menu()) != 0) {  modifier par joseph
  //  while(true){
    client_info = client_cols(); 
            ev = eventManager.genEvent("ev_rmp"); //retour au menu principal
            eventManager.dispatch(ev);
    //    }
     //       }
        } catch (IOException ex) {
            Logger.getLogger(CreerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
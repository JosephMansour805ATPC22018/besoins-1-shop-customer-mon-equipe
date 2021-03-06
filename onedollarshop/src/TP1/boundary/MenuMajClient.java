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
public class MenuMajClient implements Runnable {

    Source eventManager;

    public MenuMajClient(Source<String> s) {
        eventManager = s;
    }

    public String mjc() throws IOException {

        String selection;
        //Ceci efface en principe un écran (console) Linux et Windows
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);

        /**
         * ************************************************
         */
        System.out.println("---Metter à jour un Client--(0 pour revenir au menu principla) --------------------");
        System.out.println("Saisir l'ID du Client");
        System.out.print("ID: ");
        selection = input.nextLine();
        return selection;
    }

    @Override
    public void run() {
        String  choix;
        GEvent ev=eventManager.genEvent("Aucune réponse connue");
        try {
                choix = mjc(); 
                ev = eventManager.genEvent("ev_rmp"); //retour au menu principal
                eventManager.dispatch(ev);
            } catch (IOException ex) {
            Logger.getLogger(MenuMajClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
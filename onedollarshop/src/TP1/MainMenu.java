/*
 * Copyright (C) 2018 jandj
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
package TP1;

import TP0.Client;
import java.util.Scanner;


/**
 *
 * @author jandj
 */
public class MainMenu {

    public static void main(String[] args){

        //Variables Locales
        Scanner scanner = new Scanner (System.in);
        String selection;
             
        //Afficher la menu 
        while (true){
        System.out.println("(0) Quit");
        System.out.println("----------");
        System.out.println("(1) Creer un Client");
        System.out.println("(2) Trouver Client");
        System.out.println("(3) Supprimer Client");
        System.out.println("(4) Mettre a jour Client");
        selection=scanner.nextLine();
        
       //Lire l'option choisie
        switch (selection) {
            case "1": System.out.println("Tu as choisi de creer un client");
            Client client1= new Client.ClientBuilder("1", "Joseph","Mansour").ville("Beyrouth").build();
            break;
            
            case "2": System.out.println("Tu as choisi de trouver un client");
     
            break;
            
            case "3": System.out.println("Tu as choisi de supprimer un client");
            break;
            
            case "4": System.out.println("Tu as choisi de mettre a jour un client");
            break;
            
            case "0": System.out.println("Sortir de la menu");
            System.exit(0);
            
            
            default:System.out.println("A choisir de 0 a 4");
        };
        
    }
       
}
}
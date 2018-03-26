package TP0;

import  TP0.Client;
public class TestBuilder {
    public static void main(String args[]) {
    Client client1;
    client1= new Client.ClientBuilder("1", "Joseph","Mansour").ville("Beyrouth").build();
    /**
    .phone("1234567")
    .address("Fake address 1234")
    .build();
    */
        System.out.println("Ville: " + client1.getVille());
    }
}

package TP0;

import java.io.IOException;

public class TestBuilder {
    public static void main(String args[]) throws IOException {
    Client client1;
    client1= new Client.ClientBuilder("1", "Joseph","Mansours").ville("g").build();
    /**
    .phone("1234567")
    .address("Fake address 1234")
    .build();
    */
        System.out.println(client1);
    }
}

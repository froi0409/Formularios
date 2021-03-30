/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.editorcodigoindigo.servidor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author froi-pc
 */
public class Canal {
    
    public String repuesta(String entrada, String userOnline) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/FormulariosWeb/AnalizadorCodigoIndigo"))
                    .POST(HttpRequest.BodyPublishers.ofString(entrada))
                    .setHeader("userOnline", userOnline)
                    .build();
            
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            return response.body();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
}

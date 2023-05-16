package com.saucedemo.pages;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.content.ShoppingContent;
import com.google.api.services.content.ShoppingContent.Products.List;
import com.google.api.services.content.ShoppingContentScopes;
import com.google.api.services.content.model.ProductsListResponse;


public class GoogleMerchantProducts {

    private static final String APPLICATION_NAME = "https://merchants.google.com/";
    private static final String MERCHANT_CENTER_ACCOUNT_ID = "108781704";
    private static final String PRODUCTS_FILE_PATH = "GoogleMerchantAPI.json";
    private static final String SERVICE_ACCOUNT_FILE_PATH = "GoogleMerchantProducts.json";


    private static ShoppingContent shoppingContent;

    public static ShoppingContent getShoppingContent() throws IOException, GeneralSecurityException {
        if (shoppingContent == null) {
            GoogleCredential credential = GoogleCredential.fromStream(
                new FileInputStream(SERVICE_ACCOUNT_FILE_PATH))
                .createScoped(Collections.singleton(ShoppingContentScopes.CONTENT));
            
            HttpRequestInitializer requestInitializer = credential;
            shoppingContent = new ShoppingContent.Builder(
            	    GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), requestInitializer)
            	    .setApplicationName(APPLICATION_NAME)
            	    .build();

        }
        return shoppingContent;
    }

    public static void retrieveProductsList() throws IOException, GeneralSecurityException {
    	 BigInteger merchantIdBigInteger = new BigInteger(MERCHANT_CENTER_ACCOUNT_ID);
        List listProducts = getShoppingContent().products().list(merchantIdBigInteger);
        ProductsListResponse response = listProducts.execute();
        
        try (FileWriter file = new FileWriter(PRODUCTS_FILE_PATH)) {
            file.write(response.toPrettyString());
        }
    }
    


    public static void main(String[] args) throws IOException, GeneralSecurityException {
        GoogleMerchantProducts.retrieveProductsList();
    
}
}
package com.saucedemo.pages;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GraphQLApiTest {

    private static final String SHOPIFY_GRAPHQL_ENDPOINT = "https://new-aroma360.myshopify.com/api/2023-01/graphql.json";
    private static final String SHOPIFY_ACCESS_TOKEN = "3161e85cecbd61612e3bb7544f59bdd1";
   // private static final String GRAPHQL_QUERY = "{\r\n  products(first:250) {\r\n    edges {\r\n      node {\r\n        title\r\n      }\r\n    }\r\n  }\r\n}";
  //  private static final String GRAPHQL_QUERY = "{\r\n  products(first:200, query: \"available:true\") {\r\n    nodes {\r\n      title\r\n      handle\r\n      onlineStoreUrl	\r\n    }\r\n  }\r\n}";
  //    private static final String GRAPHQL_QUERY = "{\r\n  products(first:250, query: \"available:true\") {\r\n    edges {\r\n      node {\r\n        title\r\n        handle\r\n        onlineStoreUrl	\r\n      }\r\n    }\r\n  }\r\n}";
  //  private static final String GRAPHQL_QUERY = "{\r\n  products(first:250,query:\"available:true\") {\r\n    \r\n      nodes {\r\n        title\r\n      \r\n    \r\n  }\r\n}}";
  //  private static final String GRAPHQL_QUERY = "{\r\n  products(first: 250, query: \"available:true\") {\r\n    nodes {\r\n      title\r\n      onlineStoreUrl\t\r\n    }\r\n  }\r\n}";
  //  private static final String GRAPHQL_QUERY = "{\r\n  products(first: 250){\r\n    nodes {\r\n      title\r\n      handle\r\n      onlineStoreUrl\t\r\n    \r\n  }\r\n}}";
      private static final String GRAPHQL_QUERY = "{\r\n  products(first: 250){\r\n   edges {\r\n    node {\r\n      title\r\n      handle\r\n      onlineStoreUrl\t\r\n    \r\n }\r\n  }\r\n}}";
    
    public static ObjectMapper mapper;

    public GraphQLApiTest() {
        mapper = new ObjectMapper();
    }

    public static void runTest() throws IOException {
    	ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"query\":\"" + GRAPHQL_QUERY + "\",\"variables\":{}}");
        Request request = new Request.Builder()
                .url(SHOPIFY_GRAPHQL_ENDPOINT)
                .method("POST", body)
                .addHeader("X-Shopify-Storefront-Access-Token", SHOPIFY_ACCESS_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);

        String responseBody = response.body().string();
        System.out.println("responseBody  "+responseBody);
        JsonNode responseJson = mapper.readTree(responseBody);
        System.out.println("responseBody1  "+responseJson);
        JsonNode dataNode = responseJson.get("data");

        // Dump the JSON data with an indent of 2 spaces
        String formattedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataNode);

        try (Writer writer = new OutputStreamWriter(new FileOutputStream("ProductApi.json"), StandardCharsets.UTF_8)) {
            writer.write(formattedJson);
        }
    }

    public static void main(String[] args) throws IOException {
        GraphQLApiTest test = new GraphQLApiTest();
        test.runTest();
    }
}

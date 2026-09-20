package Service.SbbApiService;

import java.io.BufferedReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.stream.Collectors;

import Service.IService;

public class SbbApiService implements IService {
  private final String protoString = "https";
  private URL baseUrl;

  private final String newLine = System.getProperty("line.separator");

  // Constructors
  public SbbApiService() {
    try {
      baseUrl = new URI(protoString + "://data.sbb.ch").toURL();
    } catch (URISyntaxException | MalformedURLException e) {
      System.out.println("API URI Syntax '" + this.getBaseUrl() + "' is invalid:" + newLine + e.getMessage());
      System.exit(1);
    }
  }

  // Class internal Tooling

  private URL buildUrl(String path) {
    try {
      return new URI(baseUrl.toString() + path).toURL();
    } catch (URISyntaxException | MalformedURLException e) {
      System.out.println("Cannot build URI:" + newLine + e);
      System.exit(1);
      return null;
    }
  }

  private <T> T request(URL requestUrl, Class<T> returnType) {
    URLConnection request = null;

    try {
      request = requestUrl.openConnection();
      request.connect();
    } catch (IOException e) {
      System.out.println("Cannot open connection to the SSB API:" + newLine + e);
      System.exit(1);
    }

    InputStreamReader reader = null;

    try {
      reader = new InputStreamReader((InputStream) request.getContent()); 
    } catch (IOException e) {
      System.out.println("Cannot read content of the response:" + newLine + e);
      System.exit(1);
    }

    Gson gson = new Gson();
    return gson.fromJson(reader, returnType);
 }

  // Accessors

  public String getProto() {
    return protoString;
  }

  public URL getBaseUrl() {
    return baseUrl;
  }

  // API Endpoints
  public RailTrafficInformation searchRailTrafficInformation() {
    URL rtiSearchUrl = this.buildUrl("/api/records/1.0/search/?dataset=rail-traffic-information&sort=record_timestamp&pretty_print=true&rows=100");
    return this.request(rtiSearchUrl, RailTrafficInformation.class);
  }
}

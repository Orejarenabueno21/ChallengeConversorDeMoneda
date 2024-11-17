import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public Moneda consultaMoneda(String tipoDeCambio){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e5bc30fea096489d5803efea/latest/" + tipoDeCambio );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("No encontre esa Moneda");
        }
    }
}

// 1 - Pacote
package apiPetStore;
// 2 - Bibliotecas
// - Classe
import entities.StoreEntity;
import org.testng.annotations.Test;
import com.google.gson.Gson;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Store {
    // 3.1 - Atributos
    String jsonBody;
    String ct = "application/json";
    String uri = "https://petstore.swagger.io/v2/";

    // 3.1.2 Intanciar Classes Externas
    Gson gson = new Gson(); // Intancia o objeto de conversão classe para json

    //  Método pedido de animal de estimação
    @Test
    public void testStorePet(){
        // Arrange - Configura
        StoreEntity store = new StoreEntity(); // Istanciar a entidade
        store.id = 10; // entrada e saida (resultado esperado)
        store.petId = 10;
        store.quantity = 10;
        store.shipDate = "2023-10-31T14:25:17.210+0000";
        store.status = "colocado";
        store.complete = true;

        jsonBody = gson.toJson(store); // Converte a entidade no formato json

        // Dados de Saída / Resultado Esperado
       int id = 10;
       int petId = 10;
       int quantity = 10;
       String shipDate = "2023-10-31T14:39:09.671Z";
       String status = "colocado";
       boolean complete = true;

       // Act - Executa
       // Dado - Quando - Então
       // Given - When - Then

       given() // dado
               .contentType(ct) // tipo do conteudo
               .log().all()     // registre tudo na ida
               .body(jsonBody)  //corpo da mensagem que sera enviada
       .when()
               .post(uri + "store/order")
       // Assert - Valida
       .then() // então
               .log().all() // registre tudo na volta
               .statusCode(200) // valida a comunicação
               .body("id", is(10))
               .body("petId", is(10))
               .body("quantity", is(10))
               .body("shipDate", is("2023-10-31T14:25:17.210+0000"))
               .body("status", is("colocado"))
               .body("complete", is(true))
       ; //fim da linha do REST-Assured

    } // fim do método de criação
}

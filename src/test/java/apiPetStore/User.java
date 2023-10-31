// - Pacote
package apiPetStore;
// 2 - Bibliotecas
// 3 - Classe

import com.google.gson.Gson;
import entities.UserEntity;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class User {
    // 3.1 - Atribudos
    String jsonBody;
    String ct = "application/json";
    String uri = "https://petstore.swagger.io/v2/";

    // 3.1.2 Instanciar Classes Externas
    Gson gson = new Gson(); // Instancia o objeto de conversão classe para json

    // 3.2 - Métodos e Funções

    // Método #EXE 01 - Criar Usuário
    @Test
    public void testCreateUser(){
        // Arrange - Configura
        UserEntity user = new UserEntity(); // Instancia a entidade usuário
        user.id = 9999; // entrada e saida (resultado esperado)
        user.username = "Charlie"; // entrada e saida (resultado esperado)
        user.firstName = "Charlie"; // entrada e saida (resultado esperado)
        user.lastName = "Brown"; // entrada e saida (resultado esperado)
        user.email = "charlie@uni9.edu.br"; // entrada e saida (resultado esperado)
        user.password = "123456"; // entrada
        user.phone = "(11)2633-9000"; // entrada e saida (resultado esperado)
        user.userStatusString = 0; // entrada e saida (resultado esperado)


        jsonBody = gson.toJson(user); // Converte a entidade usuario no formato json

        // Dados de Saída / Resultado Esperado
        int code = 200;
        String type = "unknown";
        String message = "9999";

        // Act - Executa

        // Dado - Quando - Então
        // Given - When - Then
        given() // dado
                .contentType(ct) // tipo do conteudo
                .log().all()                       // registre tudo na ida
                .body(jsonBody)                    // corpo da mensagem que será enviada
        .when()  // quando
                .post(uri + "user")
        // Assert - Valida
        .then() // então
                .log().all()        // registre tudo na volta
                .statusCode(200) //valida a comunicação
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(message)) // valida o usuario
        ; // fim da linha do REST-assured

    } // fim do método de criação de usuário
}

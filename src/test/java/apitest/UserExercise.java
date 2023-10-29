// - Pacote
package apitest;
// 2 - Bibliotecas
// 3 - Classe

import com.google.gson.Gson;
import entities.AccountEntity;
import entities.UserEntityExercise;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class UserExercise {
    // 3.1 - Atribudos

    // 3.1.2 Instanciar Classes Externas
    Gson gson = new Gson(); // Instancia o objeto de conversão classe para json

    // 3.2 - Métodos e Funções

    // Método #EXE01 - Criar Usuário
    @Test
    public void testCreateUser(){
        // Arrange - Configura
        UserEntityExercise entity = new UserEntityExercise(); // Instancia a entidade usuário
        entity.id = "100"; // entrada e saida (resultado esperado)
        entity.username = "Charlie"; // entrada e saida (resultado esperado)
        entity.firstName = "Charlie"; // entrada e saida (resultado esperado)
        entity.lastName = "Brown"; // entrada e saida (resultado esperado)
        entity.email = "junior_maza16@uni9.edu.br"; // entrada e saida (resultado esperado)
        entity.password = "123456"; // entrada
        entity.phone = "(11)2633-9000"; // entrada e saida (resultado esperado)
        entity.userStatus = "01"; // entrada e saida (resultado esperado)


        String jsonBody = gson.toJson(entity); // Converte a entidade usuario no formato json

        // Dados de Saída / Resultado Esperado
        int code = 200;
        String type = "unknown";
        String message = "9999";

        // Act - Executa

        // Dado - Quando - Então
        // Given - When - Then
        given() // dado
                .contentType("application/json") // tipo do conteudo
                .log().all()                       // registre tudo na ida
                .body(jsonBody)                    // corpo da mensagem que será enviada
        .when()  // quando
                .post("https://petstore.swagger.io/v2/user")
        // Assert - Valida
        .then() // então
                .log().all()        // registre tudo na volta
                .statusCode(200) //valida a comunicação
                .body("code",is(200))
                .body("type",is("unknown"))
                .body("message", is(entity.id)) // valida o usuario
        ; // fim da linha do REST-assured

    } // fim do método de criação de usuário
}

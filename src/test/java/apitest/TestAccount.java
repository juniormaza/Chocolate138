// 1 - Pacote
package apitest;
// 2 - Bibliotecas
import com.google.gson.Gson;
import entities.AccountEntity;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.ITestContext; // Interface do TestNg para compartilhar variaveis

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


// 3 - Classe
public class TestAccount {
    // 3.1 - Atributos
    String userId; // instanciar Classes Interna
    String ct = "application/json"; // contentType da API
    String jsonBody; // guardar o json que será enviado
    String uri = "https://bookstore.toolsqa.com/Account/v1/"; // Endereço Base
    Response resposta; // guardar o retorno da API
    static String token; // guardar o token - autenticação do usuário

    // 3.1.2 Instanciar Classes Externas
    Gson gson = new Gson(); // Instancia o objeto de conversão de classe para json
    AccountEntity account = new AccountEntity(); // Instancia a entidade usuario

    // 3.2 - Métodos e Funções

    // Método #1 - Criar Usuário
    @Test(priority = 1) // prioridade 01
    public void testCreateUser(ITestContext context){
        // Arrange - Configura
        account.userName = "charlie971"; // entrada e saida(resultado esperado)
        account.password = "P@ss0rd1"; // entrada

         jsonBody = gson.toJson(account); // Converte a entidade usuario no formato json

        // Act - Executa

        // Dado - Quando - Então
        // Given - When - Then
         resposta = (Response) given()     // dado
                .contentType(ct)   // tipo do conteudo
                .log().all()                       // registre tudo na ida
                .body(jsonBody)    // corpo da mensagem que sera enviada
        .when()  // quando
                .post(uri + "User")
        // Assert - Valida
        .then() // então
                .log().all()        // registre tudo na volta
                .statusCode(201) // valida a comunicação
                .body("username", is(account.userName)) // valida o usuario
                .extract()

        ; // fim da linha do REST-assured

        // extrair o userID (identificação do usuário)

         userId = resposta.jsonPath().getString("userID");
         context.setAttribute("userID", userId);
        System.out.println("UserID extraido: " + userId);




    } // fim do método de criação de usuário

    @Test(priority = 2) // Prioridade 02
    public void testGenerateToken(ITestContext context){ // Declarar a Interface de Contexto
        // Configura
        // --> Dados de Entrada são fornecidos pela AccountEntity
        // --> Resultado Esperado é que ele receba um token

        // Executa
       resposta = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "GenerateToken")
        .then()
                .log().all()
                .statusCode(200) // valida a comunicação
                .body("status", is("Success")) // Status = Sucesso
                .body("result", is("User authorized successfully."))


        .extract()
       ; // fim da linha Rest-Assured

        // Extração do Token
        token = resposta.jsonPath().getString("token");
        context.setAttribute("token", token);
        System.out.println("token: " + token);

        // Valida
        Assert.assertTrue(token.length() != 0);

    } // fim do método de geração de token de indentificação de usuário

    @Test(priority = 3)
    public void testAuthorized(){
        // Configura
        // Dados de Entrada
        // --> Fornecidos pela AccounEntity através do método testCreatUser - priority = 1

        // Dados de Saída / Resultados Esperado
        // Status Code = 200
        // Reponse Body = true

        // Executa
        given() // dado
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when() // quando
                .post(uri + "Authorized")
        // Valida
        .then() // então
                .log().all()
                .statusCode(200)
                //.body(true) // ToDo: como validar o retorno do body apenas como true

        ; // fim do Rest-assured

    }

    @Test(priority = 4)
    public void testResearchUserNotAuthorized(){
        // Configura
        // Dados de Entrada
        // UserId foi extraido no método testeCreatUser e esta na mémoria
        // Dados de Saída // Resultado Esperado
        // Status Code = 401, Code = 1200 e Message = User not authorized

        // Executa
        given()                                     // Dado
                .contentType(ct)                    // Formato da mensagem
                .log().all()                        // Exibir tudo que acontece na ida
        .when()                                     // Quando
                .get(uri + "User/" + userId)  // Colsulta o usuário pelo userId
        // Valida
        .then()                                     // Então
                .log().all()                        // Exibir tudo que acontece na volta
                .statusCode(401)                       // Validade se não está autorizado
                .body("code", is("1200")) // validade o código de mansagem "não autorizado"
                .body("message", is("User not authorized!"))
        ;                                                 // Conclui o bloco do Rest-assured
    }
    @Test(priority = 5)
    public void testResearchUser(){
        // Configura
        // Dados de Entrada
        // UserId foi extraido no método testeCreatUser e esta na mémoria
        // Dados de Saída // Resultado Esperado
        // User Name vira da classe Account e o status code deve ser 200

        // Executa
        given()                                     // Dado
                .contentType(ct)                    // Formato da mensagem
                .log().all()                        // Exibir tudo que acontece na ida
                .header("Authorization","Bearer " + token)
        .when()                                     // Quando
                .get(uri + "User/" + userId)  // Colsulta o usuário pelo userId
                // Valida
        .then()                                     // Então
                .log().all()                        // Exibir tudo que acontece na volta
                .statusCode(200)                       // Validade se a conexão teve sucesso
                .body("userId", is(userId))
                .body("username", is (account.userName)) // validade o nome do usuário
        ;                                                 // Conclui o bloco do Rest-assured
    }

    @Test (priority = 6)
    public void testDeleteUser(){
        // Configura
        // Dados de emtrada vem do método de teste de criação do usuário (userId)
        // Resultado esperado é o ocódigo e mensagem de sucesso na exclusão do usuário

        // Executa
        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer " + token)
        .when()
                .delete(uri + "User/" + userId )
                // Valida
        .then()
                .log().all()
                .statusCode(204)
        ;


    }
}

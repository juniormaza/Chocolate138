// - Pacote
package apiPetStore;
// 2 - Bibliotecas
// 3 - Classe

import com.google.gson.Gson;
import entities.PetEntity;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Pet {
    // 3.1 - Atribudos
    String jsonBody;
    String ct = "application/json";
    String uri = "https://petstore.swagger.io/v2/";

    // 3.1.2 Intanciar Classes Externas
    Gson gson = new Gson(); // Instancia o objeto de conversão classe para json

    // Método #EXE - Criar Pet
    @Test
    public void testCreatPet(){
        // Arrange - Configura
        PetEntity pet = new PetEntity();
        pet.id = 12345;
        pet.name = "Ducky";
        pet.status = "available";

        PetEntity.Category category = new PetEntity.Category(1,"Dogs");
        pet.category = category;

        PetEntity.Tag tag = new PetEntity.Tag(1,"Frederico");
        pet.tags = new PetEntity.Tag[]{tag};

        jsonBody = gson.toJson(pet); // converte a entidade no Formato json


        // Act - Executa

        // Dado - Quando - Então
        // Given - When - Then
        given() // dado
                .contentType(ct) // tipo do conteudo
                .log().all()                       // registre tudo na ida
                .body(jsonBody)                    // corpo da mensagem que será enviada
        .when()  // quando
                .post(uri + "pet")
                // Assert - Valida
        .then() // então
                .log().all()        // registre tudo na volta
                .statusCode(200) //valida a comunicação
                .body("id", is(12345))
                .body("name", is("Ducky"))
                .body("status", is("available"))
                .body("category.name", is("Dogs"))
                .body("category.id", is(1))
                .body("tags[0].name",is("Frederico"))
                .extract().response(); // extrair a resposta
        ; // fim da linha do Rest- assured


    } // fim do método de criação do pet

}

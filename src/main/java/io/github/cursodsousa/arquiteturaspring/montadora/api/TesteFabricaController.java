package io.github.cursodsousa.arquiteturaspring.montadora.api; // Define o pacote do controller

import io.github.cursodsousa.arquiteturaspring.montadora.*; // Importa classes do domínio da montadora
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção automática de dependências
import org.springframework.beans.factory.annotation.Qualifier; // Importa a anotação para qualificar beans (não utilizada diretamente aqui)
import org.springframework.web.bind.annotation.PostMapping; // Importa a anotação para mapear requisições POST
import org.springframework.web.bind.annotation.RequestBody; // Importa a anotação para receber o corpo da requisição
import org.springframework.web.bind.annotation.RequestMapping; // Importa a anotação para mapear o endpoint base
import org.springframework.web.bind.annotation.RestController; // Importa a anotação para definir um controller REST

@RestController // Indica que esta classe é um controller REST do Spring
@RequestMapping("/carros") // Define o endpoint base para as requisições deste controller
public class TesteFabricaController { // Declaração da classe do controller

    @Autowired // Injeta automaticamente o bean Motor
    //@Qualifier("motorTurbo") // Comentado: poderia ser usado para especificar o bean
    @Turbo // Usa a anotação personalizada para injetar o motor turbo
    private Motor motor; // Declara o atributo motor que será injetado

    @PostMapping // Mapeia o método para requisições HTTP POST
    public CarroStatus ligarCarro(@RequestBody Chave chave) { // Recebe um objeto Chave do corpo da requisição
        var carro = new HondaHRV(motor); // Cria uma instância de HondaHRV usando o motor injetado
        return carro.darIgnicao(chave); // Retorna o status do carro após tentar dar ignição com a chave recebida
    }
}

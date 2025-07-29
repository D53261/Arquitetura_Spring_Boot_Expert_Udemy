package io.github.cursodsousa.arquiteturaspring;

// Importando as classes necessárias do Spring
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// A anotação @Component indica que esta classe é um componente gerenciado pelo Spring
@Component
public class ExemploValue {

    // A anotação @Value é usada para injetar o valor de uma propriedade do arquivo de configuração
    // Neste caso, ela injeta o valor da propriedade 'app.config.variavel' no campo 'variavel'
    @Value("${app.config.variavel}")
    private String variavel;

    // Método que imprime o valor da variável injetada
    public void imprimir() {
        System.out.println("Valor da variável: " + variavel);
    }
}

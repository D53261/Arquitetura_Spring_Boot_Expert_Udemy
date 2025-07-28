package io.github.cursodsousa.arquiteturaspring.montadora.api; // Define o pacote onde a anotação está localizada

import org.springframework.beans.factory.annotation.Qualifier; // Importa a anotação Qualifier do Spring

import java.lang.annotation.ElementType; // Importa o tipo de elemento para uso na anotação
import java.lang.annotation.Retention; // Importa a política de retenção da anotação
import java.lang.annotation.RetentionPolicy; // Importa as opções de política de retenção
import java.lang.annotation.Target; // Importa o alvo da anotação

@Retention(RetentionPolicy.RUNTIME) // Indica que a anotação estará disponível em tempo de execução
@Target({ElementType.METHOD, ElementType.FIELD}) // Permite uso em métodos e campos
@Qualifier("motorEletrico") // Marca como Qualifier para identificar beans específicos
public @interface Eletrico { // Declaração da anotação personalizada chamada Eletrico
}

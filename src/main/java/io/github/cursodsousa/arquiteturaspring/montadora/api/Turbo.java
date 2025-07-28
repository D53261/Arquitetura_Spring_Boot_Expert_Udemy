package io.github.cursodsousa.arquiteturaspring.montadora.api; // Define o pacote da anotação

import org.springframework.beans.factory.annotation.Qualifier; // Importa Qualifier do Spring para diferenciar beans

import java.lang.annotation.ElementType; // Tipo de elemento para uso na anotação
import java.lang.annotation.Retention; // Política de retenção da anotação
import java.lang.annotation.RetentionPolicy; // Opções de política de retenção
import java.lang.annotation.Target; // Alvo da anotação

@Retention(RetentionPolicy.RUNTIME) // Disponível em tempo de execução
@Target({ElementType.METHOD, ElementType.FIELD}) // Usada em métodos e campos
@Qualifier("motorTurbo") // Identifica beans específicos como "motorTurbo"
public @interface Turbo { // Declaração da anotação personalizada Turbo
} // Pode ser usada para injetar um bean Motor turbo
package io.github.cursodsousa.arquiteturaspring.todos; // Define o pacote do repositório

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository do Spring Data

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> { // Interface que herda métodos CRUD para TodoEntity
    // Não é necessário implementar métodos, o Spring Data gera automaticamente as operações básicas
}
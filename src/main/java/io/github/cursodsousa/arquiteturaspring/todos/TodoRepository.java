package io.github.cursodsousa.arquiteturaspring.todos; // Define o pacote do repositório

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository do Spring Data
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> { // Interface que herda métodos CRUD para TodoEntity
    // Não é necessário implementar métodos, o Spring Data gera automaticamente as operações básicas
    // Você pode adicionar métodos personalizados aqui, se necessário
    public TodoEntity findByDescricao(String descricao); // Método para verificar se existe um TODO com a descrição específica
}
package io.github.cursodsousa.arquiteturaspring;

// Importando as classes necessárias para a entidade Todo e o validador
import io.github.cursodsousa.arquiteturaspring.todos.TodoEntity;
import io.github.cursodsousa.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy(value = false) // A anotação @Lazy indica que o bean será criado apenas quando for realmente necessário, só quando o código dele for acionado
// Isso pode ser útil para evitar a criação de beans que não serão utilizados, economizando recursos
// Por padrão eles são true, mas é uma boa prática deixar explícito ou false para seguir o padrão de aplicação Spring

// Escopo padrão do Spring é Singleton, ou seja, uma única instância é criada e gerenciada pelo container
@Scope("singleton") // pode ser escrito também como // Scope(BeanDefinition.SCOPE_SINGLETON)
// Define o escopo do componente como singleton, o que significa que apenas uma instância será criada
// Outros escopos disponíveis no Spring:
// Prototype // Scope("prototype") // Exemplo de escopo prototype, onde uma nova instância é criada a cada injeção
// Request // Scope("request") // Exemplo de escopo request, onde uma nova instância é criada para cada requisição HTTP
// Session // Scope("session") // Exemplo de escopo session, onde uma nova instância é criada para cada sessão de usuário
// Aplication // Scope("application") // Exemplo de escopo application, onde uma nova instância é criada para toda a aplicação

// A anotação @Component indica que esta classe é um componente gerenciado pelo Spring
@Component
public class BeanGerenciado {

    // A anotação @Autowired permite que o Spring injete automaticamente a dependência do validador
    @Autowired
    private TodoValidator validator;

    // Construtor da classe que também recebe o TodoValidator como parâmetro
    // O Spring irá injetar a instância do TodoValidator aqui
    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    // Método que utiliza o validador para validar uma nova entidade Todo
    public void utilizar() {
        var todo = new TodoEntity(); // Criação de uma nova instância de TodoEntity
        validator.validar(todo); // Chamando o método de validação do validador
    }

    // Método setter para injeção de dependência do TodoValidator
    // O Spring pode usar este método para injetar a dependência
    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}

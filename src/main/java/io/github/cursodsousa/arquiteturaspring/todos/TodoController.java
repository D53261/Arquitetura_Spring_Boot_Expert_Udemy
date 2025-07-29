package io.github.cursodsousa.arquiteturaspring.todos; // Define o pacote do controller

    import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.*; // Importa as anotações do Spring Web
    import org.springframework.web.server.ResponseStatusException;

@RestController // Indica que esta classe é um controller REST
    @RequestMapping("todos") // Define o prefixo dos endpoints como /todos
    public class TodoController { // Declaração da classe do controller

        private TodoService service; // Serviço responsável pela lógica das tarefas

        public TodoController(TodoService todoService) { // Construtor com injeção do serviço
            this.service = todoService;
        }

        @PostMapping // Endpoint para criar uma nova tarefa
        public TodoEntity salvar(@RequestBody TodoEntity novoTodo) { // Recebe a tarefa no corpo da requisição
            try {
                return this.service.salvar(novoTodo); // Chama o serviço para salvar e retorna a tarefa criada
            } catch (IllegalArgumentException e) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage()); // Lança uma exceção de conflito (409) se a validação falhar
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao salvar TODO", e); // Lança uma exceção de erro interno (500) para outros erros
            }
        }

        @PutMapping("{id}") // Endpoint para atualizar o status de uma tarefa existente
        public void atualizarStatus(
                @RequestBody TodoEntity novoTodo, // Recebe os dados da tarefa no corpo
                @PathVariable("id") Integer id) { // Recebe o id da tarefa pela URL
            try {
                novoTodo.setId(id); // Define o id na entidade recebida
                this.service.atualizarStatus(novoTodo); // Chama o serviço para atualizar o status
            } catch (IllegalArgumentException e) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage()); // Lança uma exceção de conflito (409) se a validação falhar
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar TODO", e); // Lança uma exceção de erro interno (500) para outros erros
            }
        }

        @GetMapping("{id}") // Endpoint para buscar uma tarefa pelo id
        public TodoEntity buscar(@PathVariable("id") Integer id) { // Recebe o id pela URL
            return this.service.buscar(id); // Chama o serviço para buscar e retorna a tarefa
        }
    }
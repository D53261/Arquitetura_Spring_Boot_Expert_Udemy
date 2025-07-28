package io.github.cursodsousa.arquiteturaspring.todos; // Define o pacote do controller

    import org.springframework.web.bind.annotation.*; // Importa as anotações do Spring Web

    @RestController // Indica que esta classe é um controller REST
    @RequestMapping("todos") // Define o prefixo dos endpoints como /todos
    public class TodoController { // Declaração da classe do controller

        private TodoService service; // Serviço responsável pela lógica das tarefas

        public TodoController(TodoService todoService) { // Construtor com injeção do serviço
            this.service = todoService;
        }

        @PostMapping // Endpoint para criar uma nova tarefa
        public TodoEntity salvar(@RequestBody TodoEntity novoTodo) { // Recebe a tarefa no corpo da requisição
            return this.service.salvar(novoTodo); // Chama o serviço para salvar e retorna a tarefa criada
        }

        @PutMapping("{id}") // Endpoint para atualizar o status de uma tarefa existente
        public void atualizarStatus(
                @RequestBody TodoEntity novoTodo, // Recebe os dados da tarefa no corpo
                @PathVariable("id") Integer id) { // Recebe o id da tarefa pela URL
            novoTodo.setId(id); // Define o id na entidade recebida
            this.service.atualizarStatus(novoTodo); // Chama o serviço para atualizar o status
        }

        @GetMapping("{id}") // Endpoint para buscar uma tarefa pelo id
        public TodoEntity buscar(@PathVariable("id") Integer id) { // Recebe o id pela URL
            return this.service.buscar(id); // Chama o serviço para buscar e retorna a tarefa
        }
    }
package com.example.todolist.todolist;

import com.example.todolist.todolist.todolist.Todo;
import com.example.todolist.todolist.todolist.prioridade.Prioridade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Sql("/deleteTest.sql")
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	private static final List<Todo> TODOS = new ArrayList<>() {
		{
			add(new Todo(1L,"Todo 1", "Descricao Todo 1", false, Prioridade.BAIXA));
			add(new Todo(2L, "Todo 2", "Descricao Todo 2", false, Prioridade.BAIXA));
			add(new Todo(3L, "Todo 3", "Descricao Todo 3", false, Prioridade.BAIXA));
			add(new Todo(4L, "Todo 4", "Descricao Todo 4", false, Prioridade.BAIXA));
			add(new Todo(5L, "Todo 5", "Descricao Todo 5", false, Prioridade.BAIXA));
		}
	};

	@Test
	void testSaveTodoSuccess() {
		Todo todo = new Todo("Teste", "Teste Descricao", false, Prioridade.MEDIA);
		webTestClient.post().uri("/api/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isNotEmpty()
				.jsonPath("$.[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$.[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$.[0].realizado").isEqualTo(todo.isRealizado())
				.jsonPath("$.[0].prioridade").isEqualTo(todo.getPrioridade().name())
		;
	}

	@Test
	void testSaveTodoFail() {
		Todo todo = new Todo("", "", false, Prioridade.MEDIA);
		webTestClient.post().uri("/api/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Sql("/insertTest.sql")
	@Test
	public void testUpdateTodoSuccess() {
		var todo = new Todo(1L,"Todo 1", "Descricao Todo 1 atualizado", true, Prioridade.BAIXA);

		webTestClient
				.put()
				.uri("/api/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isNotEmpty()
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade().name());
	}

	@Test
	public void testUpdateTodoFailure() {

		webTestClient
				.put()
				.uri("/api/todos")
				.bodyValue(
						new Todo(145L, "", "", false, Prioridade.BAIXA))
				.exchange()
				.expectStatus().is5xxServerError();
	}

	@Sql("/insertTest.sql")
	@Test
	public void testDeleteTodoSuccess() {
		webTestClient
				.delete()
				.uri("/api/todos/" + TODOS.get(0).getId())
				.exchange()
				.expectStatus().isOk();
	}

	@Test
	public void testDeleteTodoFailure() {
		Long idFalse = null;

		webTestClient
				.delete()
				.uri("/api/todos/" + idFalse)
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Sql("/insertTest.sql")
	@Test
	public void testListTodos() throws Exception {
		webTestClient
				.get()
				.uri("/api/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isNotEmpty()
				.jsonPath("$[0].nome").isEqualTo(TODOS.get(0).getNome())
				.jsonPath("$[0].descricao").isEqualTo(TODOS.get(0).getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(TODOS.get(0).isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(TODOS.get(0).getPrioridade().name())
				.jsonPath("$[1].nome").isEqualTo(TODOS.get(1).getNome())
				.jsonPath("$[1].descricao").isEqualTo(TODOS.get(1).getDescricao())
				.jsonPath("$[1].realizado").isEqualTo(TODOS.get(1).isRealizado())
				.jsonPath("$[1].prioridade").isEqualTo(TODOS.get(1).getPrioridade().name())
				.jsonPath("$[2].nome").isEqualTo(TODOS.get(2).getNome())
				.jsonPath("$[2].descricao").isEqualTo(TODOS.get(2).getDescricao())
				.jsonPath("$[2].realizado").isEqualTo(TODOS.get(2).isRealizado())
				.jsonPath("$[2].prioridade").isEqualTo(TODOS.get(2).getPrioridade().name())
				.jsonPath("$[3].nome").isEqualTo(TODOS.get(3).getNome())
				.jsonPath("$[3].descricao").isEqualTo(TODOS.get(3).getDescricao())
				.jsonPath("$[3].realizado").isEqualTo(TODOS.get(3).isRealizado())
				.jsonPath("$[3].prioridade").isEqualTo(TODOS.get(3).getPrioridade().name())
				.jsonPath("$[4].nome").isEqualTo(TODOS.get(4).getNome())
				.jsonPath("$[4].descricao").isEqualTo(TODOS.get(4).getDescricao())
				.jsonPath("$[4].realizado").isEqualTo(TODOS.get(4).isRealizado())
				.jsonPath("$[4].prioridade").isEqualTo(TODOS.get(4).getPrioridade().name());
	}
}

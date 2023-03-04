package br.com.Attornatus.GerenciadorPessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Attornatus.GerenciadorPessoas.dto.ListarEnderecoDto;
import br.com.Attornatus.GerenciadorPessoas.form.CriarEnderecoForm;
import br.com.Attornatus.GerenciadorPessoas.service.EndereçoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EndereçoService service;

	@GetMapping("/listar/{id}")
	public List<ListarEnderecoDto> listarEndereco (@PathVariable Integer id) {
		return service.listar(id);
	}
	
	@GetMapping("/listar/principal/{id}")
	public List<ListarEnderecoDto> listarEnderecoPrincipal(@PathVariable Integer id){
		return service.listarPrincipal(id);
	}
	
	@PostMapping("/criar/{id}")
	public ResponseEntity<ListarEnderecoDto> criarEndereco (@RequestBody @Valid CriarEnderecoForm form,UriComponentsBuilder uriBuilder, @PathVariable Integer id){
		return service.criar(form, id, uriBuilder);
	}
	
	
}

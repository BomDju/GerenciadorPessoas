package br.com.Attornatus.GerenciadorPessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Attornatus.GerenciadorPessoas.dto.ConsultarPessoaDto;
import br.com.Attornatus.GerenciadorPessoas.dto.ListarPessoaDto;
import br.com.Attornatus.GerenciadorPessoas.form.CriarPessoaForm;
import br.com.Attornatus.GerenciadorPessoas.form.EditarPessoaForm;
import br.com.Attornatus.GerenciadorPessoas.service.PessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {
	
	@Autowired
	PessoaService service;

	@GetMapping("/listar")
	public List<ListarPessoaDto> listarPessoas() {
		return service.listarPessoas();
	}
	
	@PostMapping("/criar")
	public ResponseEntity<ListarPessoaDto> criarPessa (@RequestBody @Valid CriarPessoaForm form, UriComponentsBuilder uriBuilder) {
		return service.criar(form,uriBuilder);
	}
	
	@PutMapping("editar/{id}")
	public ResponseEntity<ListarPessoaDto> editarPessoa(@PathVariable Integer id, @RequestBody @Valid EditarPessoaForm form)	 {
		return service.editar(form, id);
	}
	
	@GetMapping("/consultar/{id}")
	public ResponseEntity<ConsultarPessoaDto> listarEnderecoPessoa (@PathVariable Integer id,UriComponentsBuilder uriBuilder) {
		return service.consultarPessoa(id, uriBuilder);
	}
	
	
}

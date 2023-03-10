package br.com.Attornatus.GerenciadorPessoas.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Attornatus.GerenciadorPessoas.dto.ConsultarPessoaDto;
import br.com.Attornatus.GerenciadorPessoas.dto.ListarPessoaDto;
import br.com.Attornatus.GerenciadorPessoas.form.CriarPessoaForm;
import br.com.Attornatus.GerenciadorPessoas.form.EditarPessoaForm;
import br.com.Attornatus.GerenciadorPessoas.model.Endereco;
import br.com.Attornatus.GerenciadorPessoas.model.Pessoa;
import br.com.Attornatus.GerenciadorPessoas.repository.EnderecoRepositry;
import br.com.Attornatus.GerenciadorPessoas.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRespository;

	@Autowired
	private EnderecoRepositry enderecoRepositry;
	
	public Page<ListarPessoaDto> listarPessoas (Pageable pageable){
		Page<Pessoa> pessoas = pessoaRespository.findAll(pageable);
		return pessoas.map(ListarPessoaDto::new);
	}
	
	public ResponseEntity<ListarPessoaDto> criar (CriarPessoaForm form, UriComponentsBuilder uriBuilder) {
		Pessoa p = new Pessoa(form.getNome(), form.getDataNascimento());
		Endereco e =  new Endereco(form.getLogadouro(),form.getCep(),form.getNumero(),form.getCidade(),form.isPrincipal());
		e.setPessoa(p);
		pessoaRespository.save(p);
		enderecoRepositry.save(e);
		
		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(new ListarPessoaDto(p));
	}
	
	public ResponseEntity<ListarPessoaDto> editar(EditarPessoaForm form, Integer id) {
		Pessoa p = pessoaRespository.findById(id).orElseThrow(() -> new EntityNotFoundException("O Id informado não foi econtrado " + id));
		p.setNome(form.getNome());
		p.setDataNascimento(form.getDataNascimento());
		pessoaRespository.save(p);
		return ResponseEntity.ok(new ListarPessoaDto(p));
	}
	
	public ResponseEntity<ConsultarPessoaDto> consultarPessoa(Integer id, UriComponentsBuilder uriBuilder) {
		Pessoa p =  pessoaRespository.findById(id).orElseThrow(() -> new EntityNotFoundException("O Id informado não foi econtrado " + id));
		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(new ConsultarPessoaDto(p));
	}
	
	public ResponseEntity<?> deletarPessoa(Integer id){
		Pessoa p =  pessoaRespository.findById(id).orElseThrow(() -> new EntityNotFoundException("O Id informado não foi econtrado " + id));
		pessoaRespository.delete(p);
		return ResponseEntity.ok().build();
	}
	
	
}

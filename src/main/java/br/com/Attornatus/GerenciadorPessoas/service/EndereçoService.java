package br.com.Attornatus.GerenciadorPessoas.service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.Attornatus.GerenciadorPessoas.dto.ListarEnderecoDto;
import br.com.Attornatus.GerenciadorPessoas.form.CriarEnderecoForm;
import br.com.Attornatus.GerenciadorPessoas.model.Endereco;
import br.com.Attornatus.GerenciadorPessoas.model.Pessoa;
import br.com.Attornatus.GerenciadorPessoas.repository.EnderecoRepositry;
import br.com.Attornatus.GerenciadorPessoas.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EndereçoService {

	@Autowired
	EnderecoRepositry enderecoRepositry;
	
	@Autowired
	PessoaRepository pessoaRepository;

	public Page<ListarEnderecoDto> listar(Integer id, Pageable pageable) {
		Page<Endereco> endereco =  enderecoRepositry.findAllEnderecoByIdPessoa(id, pageable);
		return endereco.map(ListarEnderecoDto::new);
	}

	public ResponseEntity<ListarEnderecoDto> criar(CriarEnderecoForm form, Integer id, UriComponentsBuilder uriBilder){
		Pessoa p = pessoaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("O Id informado não foi econtrado " + id));
		
		Endereco e = new Endereco(form.getLogadouro(),form.getCep(),form.getNumero(),form.getCidade(),form.isPrincipal());
		e.setPessoa(p);
		enderecoRepositry.save(e);
		
		URI uri = uriBilder.path("/endereco/{id}").buildAndExpand(e.getId()).toUri();
		return ResponseEntity.created(uri).body(new ListarEnderecoDto(e));
	}
	
	public List<ListarEnderecoDto> listarPrincipal(Integer id){
		List<Endereco> e = enderecoRepositry.findEnderecoPrincipal(id);
		return e.stream().map(ListarEnderecoDto::new).collect(Collectors.toList());
	}
}

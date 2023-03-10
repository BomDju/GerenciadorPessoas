package br.com.Attornatus.GerenciadorPessoas.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.Attornatus.GerenciadorPessoas.model.Endereco;

@Repository
public interface EnderecoRepositry extends JpaRepository<Endereco, Integer >{


	@Query("SELECT e FROM Endereco e WHERE e.pessoa.id = :id")
	public Page<Endereco> findAllEnderecoByIdPessoa(Integer id, Pageable pageable);
	
	@Query("SELECT e FROM Endereco e WHERE e.pessoa.id = :id AND e.principal = true")
	public List<Endereco> findEnderecoPrincipal(Integer id);

}

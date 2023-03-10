package br.com.Attornatus.GerenciadorPessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class GerenciadorPessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPessoasApplication.class, args);
	}

}

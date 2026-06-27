package br.com.wenderson.cinemanager;

import br.com.wenderson.cinemanager.model.DadosSerie;
import br.com.wenderson.cinemanager.service.ConsumoAPI;
import br.com.wenderson.cinemanager.service.ConvertDados;
import br.com.wenderson.cinemanager.service.IConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemanagerApplication implements CommandLineRunner {


	public static void main(String[] args) {

		SpringApplication.run(CinemanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=96028d70");
		System.out.println(json);
		ConvertDados conversor = new ConvertDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}

}

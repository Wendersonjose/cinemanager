package br.com.wenderson.cinemanager;

import br.com.wenderson.cinemanager.model.DadosEpisodio;
import br.com.wenderson.cinemanager.model.DadosSerie;
import br.com.wenderson.cinemanager.model.DadosTemporada;
import br.com.wenderson.cinemanager.service.ConsumoAPI;
import br.com.wenderson.cinemanager.service.ConvertDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
		json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=96028d70");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);
		List<DadosTemporada> temporadas = new ArrayList<>();


		for (int i = 1; i<= dados.totalTemporadas(); i++){
			json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=96028d70");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);

		}
		temporadas.forEach(System.out::println);
	}

}

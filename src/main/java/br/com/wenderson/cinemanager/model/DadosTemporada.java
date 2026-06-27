package br.com.wenderson.cinemanager.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Season") Integer Numero,
                             @JsonAlias("Episodes") List<DadosEpisodio> episodios) {
}

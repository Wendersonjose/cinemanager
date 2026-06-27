package br.com.wenderson.cinemanager.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}

package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;
import br.com.fiap.bean.Cliente;

public class Teste {

	public static void main(String[] args) {
		// Instanciar um cliente
		Cliente cliente = new Cliente();

		// API de Reflection para recuperar os m�todos
		Method[] metodos = cliente.getClass().getDeclaredMethods();
		for (int i = 0; i < metodos.length; i++) {
			System.out.println(metodos[i].getName());
		}
		
		//Recuperar os atributos
		Field[] atributos = cliente.getClass().getDeclaredFields();
		for (Field item : atributos) {
			System.out.println(item.getName());
			//recuperar a anota��o @Coluna
			Coluna anotacao = item.getAnnotation(Coluna.class);
			System.out.println("Coluna: " + anotacao.nome());
			System.out.println("Obritag�rio: " + anotacao.obrigatorio());
		}
		
		//Exibir o nome da classe
		System.out.println(cliente.getClass().getName());
		
		//Exerc�cio
		//Recuperar a anota��o da classe @Tabela
		Tabela anotacao = cliente.getClass().getAnnotation(Tabela.class);
		System.out.println("SELECT * FROM " + anotacao.nome());
	}

}







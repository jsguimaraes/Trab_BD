package com.example.apresentacao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.negocio.Anotacao;
import com.example.persistencia.AnotacaoDAO;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnotacaoDAO anotacaoDAO = new AnotacaoDAO();

        // Adicionar nova anotação
        Anotacao anotacao1 = new Anotacao(0, "Reunião", LocalDateTime.now(), "Reunião com o time de desenvolvimento", "verde");
        anotacaoDAO.adicionar(anotacao1);
        System.out.println("Anotação adicionada: " + anotacao1.getTitulo());

        // Listar anotações
        ArrayList<Anotacao> anotacoes = anotacaoDAO.listar();
        System.out.println("Lista de Anotações:");
        for (Anotacao anotacao : anotacoes) {
            System.out.println(anotacao.getId() + ": " + anotacao.getTitulo());
        }

        // Alterar anotação
        anotacao1.setDescricao("Reunião de projeto");
        anotacaoDAO.alterar(anotacao1);
        System.out.println("Anotação alterada: " + anotacao1.getTitulo());

        // Copiar anotação
        Anotacao anotacaoCopiada = anotacaoDAO.copiarPorId(anotacao1.getId());
        if (anotacaoCopiada != null) {
            anotacaoCopiada.setId(0); // Novo ID para a cópia
            anotacaoDAO.adicionar(anotacaoCopiada);
            System.out.println("Anotação copiada: " + anotacaoCopiada.getTitulo());
        }

        // Excluir anotação
        anotacaoDAO.deletar(anotacao1.getId());
        System.out.println("Anotação excluída: " + anotacao1.getTitulo());

        // Listar anotações novamente para verificar exclusão
        anotacoes = anotacaoDAO.listar();
        System.out.println("Lista de Anotações após exclusão:");
        for (Anotacao anotacao : anotacoes) {
            System.out.println(anotacao.getId() + ": " + anotacao.getTitulo());
        }
    }
}

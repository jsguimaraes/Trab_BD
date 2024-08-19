package com.example.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.example.negocio.Anotacao;

public class AnotacaoDAO {
    
    public void adicionar(Anotacao anotacao) throws SQLException{
        String sql = "INSERT INTO anotacao (titulo, data_hora, descricao, cor) VALUES (?, ?, ?, ?)";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, anotacao.getTitulo());
        preparedStatement.setTimestamp(2, Timestamp.valueOf(anotacao.getData_hora()));
        preparedStatement.setString(3, anotacao.getDescricao());
        preparedStatement.setString(4, anotacao.getCor());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
    }

    public void deletar(int id) throws SQLException{
        String sql = "DELETE FROM anotacao WHERE id = ?";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
    }

    public void alterar(Anotacao anotacao) throws SQLException{
        String sql = "UPDATE anotacao SET titulo = ?, data_hora = ?, descricao = ?, cor = ? WHERE id = ?";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, anotacao.getTitulo());
        preparedStatement.setTimestamp(2, Timestamp.valueOf(anotacao.getData_hora()));
        preparedStatement.setString(3, anotacao.getDescricao());
        preparedStatement.setString(4, anotacao.getCor());
        preparedStatement.setInt(5, anotacao.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
    }

    public Anotacao copiarPorId(int id) throws SQLException{
        String sql = "SELECT * FROM anotacao WHERE id = ?";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){       
            return new Anotacao(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getTimestamp("data_hora").toLocalDateTime(),
                rs.getString("descricao"),
                rs.getString("cor")
            );
        }
        preparedStatement.close();
        conexao.close();
        return null;
    }

    public ArrayList<Anotacao> listar() throws SQLException{
        ArrayList<Anotacao> vetAnotacao = new ArrayList<>();
        String sql = "select * from anotacao order by data_hora desc";
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql); 
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            vetAnotacao.add(new Anotacao(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getTimestamp("data_hora").toLocalDateTime(),
                rs.getString("descricao"),
                rs.getString("cor")
            ));
        }
        preparedStatement.close();
        conexao.close();
        return vetAnotacao;
    }

}

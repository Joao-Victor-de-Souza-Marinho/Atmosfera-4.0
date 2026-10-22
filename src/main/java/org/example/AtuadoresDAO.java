package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtuadoresDAO {

    public void criar(Atuadores atuadores){
        String sql = "INSERT INTO atuadores(nome_atuador,status_atual,ultimo_comando,id_dispositivo_fk) values(?,?,?,?)";
        try(Connection conn = Conexao.abrir();
            PreparedStatement stmt = conn.prepareStatement(sql);){

            stmt.setString(1, atuadores.getNomeAtuador());
            stmt.setBoolean(2, atuadores.getStatusAtual());
            stmt.setObject(3,atuadores.getUltimoComando());
            stmt.setInt(4,atuadores.getIdDispositivos());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Atuadores> listar(){
        List<Atuadores> lista = new ArrayList<>();
        String sql = "SELECT * FROM ATUADORES";
        try(Connection conn = Conexao.abrir();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()){
                Atuadores atuadores = new Atuadores(resultado.getInt("id_atuadores"),
                              resultado.getString("nome_atuador"),
                              resultado.getBoolean("status_atual"),
                              resultado.getTimestamp("ultimo_comando").toLocalDateTime(),
                              resultado.getInt("id_dispositivo_fk"));
                lista.add(atuadores);
            }
            return lista;


        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Atuadores listarPorId(Integer id){
        String sql = "SELECT * FROM atuadores WHERE id_atuadores = ?";
        try(Connection conn = Conexao.abrir();
            PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1,id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()){
               return new Atuadores(resultado.getInt("id_atuadores"),
                       resultado.getString("nome_atuador"),
                       resultado.getBoolean("status_atual"),
                       resultado.getTimestamp("ultimo_comando").toLocalDateTime(),
                       resultado.getInt("id_dispositivo_fk"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void atualizar(Atuadores atuadores, Integer id){
        String sql = "UPDATE atuadores SET nome_atuador = ?, status_atual = ?,ultimo_comando = ?, id_dispositivo_fk = ? WHERE id_atuadores = ? ";
        try(Connection conn = Conexao.abrir();
            PreparedStatement stmt = conn.prepareStatement(sql);){

            stmt.setString(1, atuadores.getNomeAtuador());
            stmt.setBoolean(2,atuadores.getStatusAtual());
            stmt.setObject(3,atuadores.getUltimoComando());
            stmt.setInt(4,atuadores.getIdDispositivos());
            stmt.setInt(5,id);
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void excluir(Integer id){
        String sql = "DELETE FROM atuadores WHERE id_atuadores = ?";
        try (Connection conn = Conexao.abrir();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }


    }





}

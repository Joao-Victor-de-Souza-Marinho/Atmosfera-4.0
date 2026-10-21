package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;
public class DispositivosDAO {

    public void cadastrar(Dispositivos dispositivos) {
        String sql = "INSERT INTO dispositivos(nome_dispositivo,localizacao,tipo_dispositivo,gateway_pai_fk) values (?, ?, ?,?)";
        try (
                Connection conn = Conexao.abrir();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, dispositivos.getNomeDispositivo());
            stmt.setString(2, dispositivos.getLocalizacao());
            stmt.setString(3, dispositivos.getTipoDispositivo());
            stmt.setInt(4,dispositivos.getGatewayPai());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Dispositivos> listar() {
        List<Dispositivos> dispositivos = new ArrayList<>();
        String sql = "SELECT * FROM DISPOSITIVOS";

        try (Connection conn = Conexao.abrir();
             PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            ResultSet resultado = stmt.executeQuery();


            while (resultado.next()) {
                int gateway = resultado.getInt("gateway_pai_fk");
                Integer gatewayPai;

                if (resultado.wasNull()){
                    gatewayPai = null;
                }else{
                    gatewayPai = gateway;
                }

                Dispositivos dispositivo = new Dispositivos(
                        resultado.getInt("id_dispositivos"),
                        resultado.getString("nome_dispositivo"),
                        resultado.getString("tipo_dispositivo"),
                        resultado.getString("localizacao"),

                        gatewayPai
                );
                dispositivos.add(dispositivo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dispositivos;
    }

    public Dispositivos listarPorId(Integer id){
        String sql = "SELECT * FROM dispositivos WHERE id_dispositivos = ?";
        try(Connection conn = Conexao.abrir();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1,id);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()){
                int gateway = resultado.getInt("gateway_pai_fk");
                Integer gatewayPai;

                if (resultado.wasNull()){
                    gatewayPai = null;
                }else{
                    gatewayPai = gateway;
                }
                Dispositivos dispositivos = new Dispositivos(resultado.getInt("id_dispositivos"),
                        resultado.getString("nome_dispositivo"),
                        resultado.getString("tipo_dispositivo"),
                        resultado.getString("localizacao"),
                        gatewayPai);
                return dispositivos;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizar(Dispositivos dispositivos,Integer id){
        String sql = "UPDATE dispositivos SET nome_dispositivo = ?, tipo_dispositivo = ?, localizacao = ?, gateway_pai_fk = ? WHERE id_dispositivos = ?";

        try(Connection conn = Conexao.abrir();
            PreparedStatement stmt = conn.prepareStatement(sql)){

                stmt.setString(1, dispositivos.getNomeDispositivo());
                stmt.setString(2, dispositivos.getTipoDispositivo());
                stmt.setString(3, dispositivos.getLocalizacao());
                if (dispositivos.getGatewayPai() != null) {
                    stmt.setInt(4, dispositivos.getGatewayPai());
                }else{
                    stmt.setNull(4,Types.INTEGER);
                }
                stmt.setInt(5, id);
                stmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void excluir(Integer id){
        String sql = "DELETE FROM dispositivos where id_dispositivos = ?";
        try(Connection conn = Conexao.abrir();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}
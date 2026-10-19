package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DispositivosDAO {

    public void cadastrar(Dispositivos dispositivos) {
        String sql = "INSERT INTO dispositivos(nome_dispositivo,localizacao,tipo_dispositivo) values (?, ?, ?)";
        try (
                Connection conn = Conexao.abrir();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, dispositivos.getNomeDispositivo());
            stmt.setString(2, dispositivos.getLocalizacao());
            stmt.setString(3, dispositivos.getTipoDispositivo());
            stmt.executeUpdate(sql);
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
                        resultado.getString("localizacao"),
                        resultado.getString("tipo_dispositivo"),
                        gatewayPai
                );
                dispositivos.add(dispositivo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dispositivos;
    }


}

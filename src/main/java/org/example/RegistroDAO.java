package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO {


    public void cadastrar(Registro registro) {

        String sql = """
                INSERT INTO registro (
                    temperatura,
                    umidade,
                    pressao,
                    altitude,
                    luminosidade,
                    velocidade_vento,
                    direcao_vento,
                    intensidade_wifi,
                    id_dispositivo_fk,
                    time_stamp,
                    data_hora
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = Conexao.abrir(); PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setDouble(1, registro.temperatura());
            stmt.setDouble(2, registro.umidade());
            stmt.setDouble(3, registro.pressao());
            stmt.setDouble(4, registro.altitude());
            stmt.setDouble(5, registro.luminosidade());
            stmt.setDouble(6, registro.velocidadeDoVento());
            stmt.setInt(7, registro.direcaoDoVento());
            stmt.setInt(8, registro.intensidadeWifi());
            stmt.setInt(9, registro.idDispositivo());


            stmt.setTimestamp(10, registro.timestamp());
            stmt.setObject(11, registro.dataHora());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Registro> listar() {

        String sql = "SELECT * FROM registro";

        List<Registro> registros = new ArrayList<>();

        try (Connection conn = Conexao.abrir(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Registro registro = new Registro(

                        resultado.getInt("id_registro"),

                        resultado.getDouble("temperatura"), resultado.getDouble("umidade"), resultado.getDouble("pressao"), resultado.getDouble("altitude"), resultado.getDouble("luminosidade"), resultado.getDouble("velocidade_vento"),

                        resultado.getInt("direcao_vento"), resultado.getInt("intensidade_wifi"), resultado.getInt("id_dispositivo_fk"),

                        resultado.getTimestamp("time_stamp"),

                        resultado.getTimestamp("data_hora").toLocalDateTime());

                registros.add(registro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }


    public Registro listarPorId(Integer id) {

        String sql = "SELECT * FROM registro WHERE id_registro = ?";

        try (Connection conn = Conexao.abrir(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet resultado = stmt.executeQuery()) {

                if (resultado.next()) {

                    return new Registro(

                            resultado.getInt("id_registro"),

                            resultado.getDouble("temperatura"), resultado.getDouble("umidade"), resultado.getDouble("pressao"), resultado.getDouble("altitude"), resultado.getDouble("luminosidade"), resultado.getDouble("velocidade_vento"),

                            resultado.getInt("direcao_vento"), resultado.getInt("intensidade_wifi"), resultado.getInt("id_dispositivo_fk"),

                            resultado.getTimestamp("time_stamp"),

                            resultado.getTimestamp("data_hora").toLocalDateTime());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void atualizar(Integer id, Registro registro) {

        String sql = """
                UPDATE registro
                SET temperatura = ?,
                    umidade = ?,
                    pressao = ?,
                    altitude = ?,
                    luminosidade = ?,
                    velocidade_vento = ?,
                    direcao_vento = ?,
                    intensidade_wifi = ?,
                    id_dispositivo_fk = ?
                WHERE id_registro = ?
                """;

        try (Connection conn = Conexao.abrir(); PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setDouble(1, registro.temperatura());
            stmt.setDouble(2, registro.umidade());
            stmt.setDouble(3, registro.pressao());
            stmt.setDouble(4, registro.altitude());
            stmt.setDouble(5, registro.luminosidade());
            stmt.setDouble(6, registro.velocidadeDoVento());

            stmt.setInt(7, registro.direcaoDoVento());
            stmt.setInt(8, registro.intensidadeWifi());
            stmt.setInt(9, registro.idDispositivo());

            stmt.setInt(10, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void excluir(Integer id) {

        String sql = "DELETE FROM registro WHERE id_registro = ?";

        try (Connection conn = Conexao.abrir(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package org.example;

public class Main {
    static void main() {

    DispositivosDAO dao = new DispositivosDAO();

    for (Dispositivos dispositivos: dao.listar()){
        System.out.println(dispositivos.getId());
        System.out.println(dispositivos.getNomeDispositivo());
        System.out.println(dispositivos.getTipoDispositivo());
        System.out.println(dispositivos.getGatewayPai());
    }
   dao.listarPorId(2);
        System.out.println(dao.listarPorId(2));


        System.out.println(dao.listarPorId(2).getNomeDispositivo());



    }
}

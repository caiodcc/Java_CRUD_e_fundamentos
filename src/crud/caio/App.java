package crud.caio;

import crud.caio.dao.ClienteMapDAO;
import crud.caio.dao.IClienteDAO;

import javax.swing.*;

public class App {

    
    private static IClienteDAO iClienteDAO;
    public static void Main(String args[]){
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(
                null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair.",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);


    }
}

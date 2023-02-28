import crud.caio.dao.ClienteMapDAO;
import crud.caio.dao.IClienteDAO;
import crud.caio.domain.Cliente;
import javax.swing.*;

public class App {
    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(
                null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair.",
                "Um CRUD Java", JOptionPane.INFORMATION_MESSAGE);
        
        while (!isOpcaoValida(opcao)) {
             if ("".equals(opcao)){
                 sair();
        }
            opcao = JOptionPane.showInputDialog(null, "Opcão Inválida: Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Um CRUD Java", JOptionPane.INFORMATION_MESSAGE);
    }
        while (isOpcaoValida(opcao)) {

            if (isOpcaoSair(opcao)){
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por vírgula, conforme o exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (ìsConsultar(opcao)){
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF",
                        JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);

            }
            opcao = JOptionPane.showInputDialog(null, "Opcão Inválida: Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Um CRUD Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null){

            JOptionPane.showMessageDialog(null, "Cliente encontrado" + cliente.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente inexistente", "Sucesso", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static boolean ìsConsultar(String opcao) {
        if ("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados){
        String[] dadosSeparados = dados.split(",");

        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);

        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado anteriormente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até mais!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    }



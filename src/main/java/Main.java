import Admin.AdminDAO;
import Admin.AdminInterface;
import Cliente.ClienteDAO;
import Cliente.ClienteInterface;
import Loja.LojaDAO;
import Loja.LojaInterface;
import Database.DatabaseJSON;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AdminInterface InterfaceAdm = new AdminInterface();
        ClienteInterface InterfaceCliente = new ClienteInterface();
        LojaInterface InterfaceLoja = new LojaInterface();

        DatabaseJSON.inicializarJSON();

        // InterfaceAdm.criarAdmTeste();
        // Rode esse pedaço código comentado apenas se não tiver criados adms no sistema
        // Basta rodas uma vez e os adms serão armazenados no bd

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                menu();

                System.out.print("Escolha uma opção (1-4): ");
                if (scanner.hasNextInt()) {
                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            InterfaceAdm.loginAdmin();
                            break;
                        case 2:
                            InterfaceLoja.loginCadastroLoja();
                            break;
                        case 3:
                            InterfaceCliente.loginCadastroCliente();
                            break;
                        case 4:
                            System.out.println("Encerrando o sistema...");
                            scanner.close();
                            return;  // Encerra o programa corretamente
                        case 5:
                            InterfaceAdm.loginAdmin();
                        default:
                            System.out.println("Opção inválida! Digite um número entre 1 e 4.");
                    }
                } else {
                    System.out.println("Entrada inválida! Digite um número entre 1 e 4.");
                    scanner.next(); // Consumir entrada inválida
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close(); // Garante que o scanner será fechado
        }
    }

    public static void menu() {
        System.out.println("\n==== Fazer Cadastro/Login como ====");
        System.out.println("1 - Admin");
        System.out.println("2 - Loja");
        System.out.println("3 - Cliente");
        System.out.println("4 - Sair do Sistema");
    }
}
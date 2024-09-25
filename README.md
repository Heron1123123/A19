import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    private String codigo;
    private String descricao;
    private double preco;

    public Produto(String codigo, String descricao, double preco) {
        this.codigo = codigo.toUpperCase();
        this.descricao = descricao.toUpperCase();
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("Código: %s, Descrição: %s, Preço: %.2f", codigo, descricao, preco);
    }
}

public class Cardapio {
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Remover produto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner);
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    removerProduto(scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.print("Digite o código do produto (6 caracteres): ");
        String codigo = scanner.nextLine();
        System.out.print("Digite a descrição do produto (3 a 60 caracteres): ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        produtos.add(new Produto(codigo, descricao, preco));
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de produtos:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    private static void removerProduto(Scanner scanner) {
        System.out.print("Digite o código do produto a ser removido: ");
        String codigo = scanner.nextLine();
        Produto produtoARemover = null;
        for (Produto produto : produtos) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                produtoARemover = produto;
                break;
            }
        }
        if (produtoARemover != null) {
            produtos.remove(produtoARemover);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}

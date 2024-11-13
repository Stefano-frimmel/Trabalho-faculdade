import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Link {
    private String titulo;
    private String url;
    private String categoria;

    public Link(String titulo, String url, String categoria) {
        this.titulo = titulo;
        this.url = url;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return titulo + "," + url + "," + categoria;
    }

    public static Link fromString(String linha) {
        String[] partes = linha.split(",");
        return new Link(partes[0], partes[1], partes[2]);
    }
}

class LinkManager {
    private static final String FILE_NAME = "links.txt";
    private List<Link> links = new ArrayList<>();

    public LinkManager() {
        carregarLinks();
    }

    private void carregarLinks() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                links.add(Link.fromString(linha));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os links: " + e.getMessage());
        }
    }

    public void salvarLinks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Link link : links) {
                bw.write(link.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os links: " + e.getMessage());
        }
    }

    public void adicionarLink(Link link) {
        links.add(link);
        salvarLinks();
    }

    public List<Link> listarLinks() {
        return new ArrayList<>(links);
    }

    public List<Link> listarLinksPorCategoria(String categoria) {
        List<Link> resultado = new ArrayList<>();
        for (Link link : links) {
            if (link.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(link);
            }
        }
        return resultado;
    }

    public void editarLink(String titulo, Link novoLink) {
        for (int i = 0; i < links.size(); i++) {
            if (links.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                links.set(i, novoLink);
                salvarLinks();
                return;
            }
        }
        System.out.println("Link não encontrado.");
    }

    public void excluirLink(String titulo) {
        links.removeIf(link -> link.getTitulo().equalsIgnoreCase(titulo));
        salvarLinks();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkManager manager = new LinkManager();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Links Úteis:");
            System.out.println("1. Adicionar Link");
            System.out.println("2. Listar Links");
            System.out.println("3. Listar Links por Categoria");
            System.out.println("4. Editar Link");
            System.out.println("5. Excluir Link");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("URL: ");
                    String url = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    manager.adicionarLink(new Link(titulo, url, categoria));
                    break;
                case 2:
                    System.out.println("Lista de Links:");
                    for (Link link : manager.listarLinks()) {
                        System.out.println(link.getTitulo() + " - " + link.getUrl() + " (" + link.getCategoria() + ")");
                    }
                    break;
                case 3:
                    System.out.print("Categoria: ");
                    categoria = scanner.nextLine();
                    System.out.println("Links na categoria " + categoria + ":");
                    for (Link link : manager.listarLinksPorCategoria(categoria)) {
                        System.out.println(link.getTitulo() + " - " + link.getUrl());
                    }
                    break;
                case 4:
                    System.out.print("Título do link a editar: ");
                    titulo = scanner.nextLine();
                    System.out.print("Novo Título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Nova URL: ");
                    url = scanner.nextLine();
                    System.out.print("Nova Categoria: ");
                    categoria = scanner.nextLine();
                    manager.editarLink(titulo, new Link(novoTitulo, url, categoria));
                    break;
                case 5:
                    System.out.print("Título do link a excluir: ");
                    titulo = scanner.nextLine();
                    manager.excluirLink(titulo);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}

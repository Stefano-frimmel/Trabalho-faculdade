Explicação do Código
Este código é um sistema de gerenciamento de links úteis que permite ao usuário armazenar, listar, editar e excluir links categorizados. Ele utiliza um arquivo de texto (links.txt) para persistir os dados, e o código é dividido em três classes: Link, LinkManager, e Main.

Classe Link
Esta classe representa um link individual com título, URL e categoria.

Declaração de variáveis: titulo, url, e categoria representam os dados essenciais do link.
Construtor Link: Inicializa um link com título, URL, e categoria fornecidos pelo usuário.
Getters e Setters: Métodos para acessar e modificar cada campo da classe Link.
Método toString: Converte o objeto Link em uma string formatada, para ser salva no arquivo.
Método fromString: Converte uma string do arquivo em um objeto Link para facilitar a leitura dos dados no formato correto.
Classe LinkManager
A classe LinkManager é responsável pela gestão dos links, incluindo operações CRUD (Criar, Ler, Atualizar e Excluir).

Constante FILE_NAME: Define o nome do arquivo de texto onde os links serão salvos.
Lista links: Armazena objetos Link que representam os links disponíveis.
Construtor LinkManager: Carrega os links do arquivo no momento em que o programa inicia.
Método carregarLinks: Lê o arquivo links.txt, cria objetos Link a partir das linhas do arquivo e os armazena na lista links.
Se o arquivo não existir, uma mensagem é exibida.
Método salvarLinks: Escreve os dados de cada link no arquivo links.txt.
Método adicionarLink: Adiciona um novo link à lista e salva a lista atualizada no arquivo.
Método listarLinks: Retorna todos os links salvos.
Método listarLinksPorCategoria: Filtra os links por categoria e retorna uma lista de links que pertencem a uma categoria específica.
Método editarLink: Procura um link pelo título e, se encontrado, atualiza-o com novos valores e salva as alterações no arquivo.
Método excluirLink: Remove um link com o título especificado e salva a lista atualizada no arquivo.
Classe Main
Esta é a classe principal que apresenta o menu e permite ao usuário interagir com o sistema.

Instanciação de LinkManager: Cria um objeto LinkManager para gerenciar os links.
Menu e Scanner: Um loop do-while exibe um menu com opções para adicionar, listar, editar, excluir links, ou sair.
Operações CRUD:
Opção 1 - Adicionar Link: Solicita ao usuário o título, URL e categoria do link, e o adiciona à lista.
Opção 2 - Listar Links: Exibe todos os links na lista.
Opção 3 - Listar Links por Categoria: Solicita a categoria e exibe os links dessa categoria.
Opção 4 - Editar Link: Solicita o título do link a ser editado e novos valores de título, URL e categoria.
Opção 5 - Excluir Link: Solicita o título do link a ser removido.
Opção 6 - Sair: Encerra o programa.
Fechamento do Scanner: Libera o recurso após o término do programa.
Defesa do Código para o README.md
Este sistema de gerenciamento de links úteis é uma aplicação prática para armazenamento e organização de links, categorizados por assunto, que podem ser salvos e acessados rapidamente. Ele demonstra boas práticas de programação em Java, incluindo o uso de classes para modelagem de dados, operações de leitura e escrita em arquivos, e organização em métodos bem definidos.

Principais vantagens e características:

Persistência de Dados: O uso de um arquivo de texto permite que os links sejam armazenados de forma permanente, facilitando a recuperação dos dados ao reabrir o programa.
Facilidade de Navegação: A classe Main apresenta um menu de navegação intuitivo que guia o usuário em todas as operações.
Isolamento de Funções: A classe LinkManager concentra as operações de CRUD, facilitando a manutenção e expansão do código.
Leitura e Escrita em Arquivo: O código demonstra o uso de BufferedReader e BufferedWriter para manipular arquivos de forma eficiente e segura.
Este projeto é ideal para quem busca aprender e aplicar conceitos de persistência de dados, manipulação de arquivos, e operações CRUD em Java. Ele pode ser facilmente expandido para adicionar funcionalidades, como ordenação de links, busca avançada, ou suporte para múltiplos usuários.

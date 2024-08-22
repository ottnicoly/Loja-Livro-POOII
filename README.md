Exercício 1: Modelagem de uma Relação 1 para N
Contexto: Uma loja de livros online deseja gerenciar seus livros e autores. Cada autor pode ter vários livros associados a ele, mas cada livro só pode ter um autor.

Tarefas:

Modele as classes Autor e Livro, respeitando a relação 1 para N (um autor pode ter vários livros).
Implemente o padrão DAO para as classes AutorDAO e LivroDAO, utilizando a API JDBC para realizar as operações de CRUD no banco de dados.
Crie uma classe ConexaoBD que utiliza o padrão Singleton para gerenciar a conexão com o banco de dados.
Implemente métodos nas classes DAO para:
Inserir, atualizar, excluir e listar autores.
Inserir, atualizar, excluir e listar livros.
Listar todos os livros de um autor específico.
 

Entidades:

Autor

ID_Autor (PK): Identificador único do autor.
Nome: Nome do autor.
Nacionalidade: Nacionalidade do autor.
Livro

ID_Livro (PK): Identificador único do livro.
Título: Título do livro.
Ano_Publicação: Ano de publicação do livro.
ID_Autor (FK): Chave estrangeira que referencia o autor do livro.
Relacionamento:

Um autor pode ter vários livros (1):
Um autor pode escrever vários livros, mas cada livro é escrito por um único autor.
A tabela Livro possui uma chave estrangeira ID_Autor que referencia a tabela Autor.

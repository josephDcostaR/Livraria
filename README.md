## Projeto Livraria Online

Este projeto foi desenvolvido com o intuito de praticar conceitos de programação orientada a objetos em Java 21. A ideia é simular o funcionamento de uma loja virtual de livros, permitindo o gerenciamento de um catálogo de livros e a interação com um carrinho de compras.


## Estrutura do Projeto:
- **Livraria**
  - **Model**
    - Livro
    - LivroFisico
    - Ebook
  - **Controller**
    - CarrinhoDeCompras
    - LojaLivros
- App

```md
## Funções

### 📌 CarrinhoDeCompras:
- **Exibir Carrinho** → Lista todos os livros adicionados ao carrinho.
- **Exibir Preço Total da Compra** → Calcula e mostra o valor total dos livros, somando frete se aplicável.
- **Finalizar Compra** → Finaliza o pedido, confirma a compra e esvazia o carrinho.
- **Retornar à Loja** → Volta ao menu principal da loja para continuar navegando ou comprando.

### 📌 LojaLivros:
- **Listar Catálogo de Livros** → Exibe os livros disponíveis no catálogo.
- **Pesquisar Livro no Catálogo** → Pesquisa um livro específico dentro do catálogo.
- **Filtrar Preços** → Pesquisa os livros dentro de um intervalo de preço no catálogo.
- **Adicionar Livro ao Carrinho** → Adiciona um livro selecionado ao carrinho.
- **Remover Livro do Carrinho** → Remove um livro selecionado do carrinho.
- **Cadastrar Novo Livro** → Permite adicionar um novo livro ao catálogo.
- **Ir para o Carrinho** → Acessa a interface do carrinho de compras.
- **Sair** → Fecha o sistema.
```

## 🚀 Como Executar
1. Certifique-se de ter o **Java** instalado em seu computador.
2. Clone este repositório:
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
3. Navegue atá a pasta do projeto
    ```sh
    cd lista-de-tarefas
    ```
4. Compile o código
    ```sh
    javac App.java
    ```
5. Execute o programa:
    ```sh
    java App
    ```

## 📝 Notas
- O programa exibe um menu interativo para o usuário.
- Para limpar o console, utilizamos um método que detecta o sistema operacional e executa os comandos apropriados.

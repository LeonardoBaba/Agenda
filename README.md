# Agenda
Agenda para salvar contatos salvando nome, telefone e endereço. Projeto desenvolvido em java

Pré-requisitos
Eclipse
SQL Server 2019 configurado para caeitar conexões TCP/IP
Microsoft SQL Server Management Studio
Driver JDBC SQL SERVER - pode ser encontrado dentro da pasta SUPORTE

Faça download de todos os arquivos

Para a criação do bando de dados:

  1 Abra o Microsoft SQL Server Management Studio
  
  2 Faça seu login
  
  3 Clique com botão direito em "Databases"
  
  4 Clique em "Import Data-tier Application..."
  
  5 Abrirá uma janela de introdução, clique em "Next" para proseguir
 
  6 Em "Import Settings" indique o local onde o arquivo "AgendaLeonardo.bacpac", clique em "Next" para proseguir
  
  7 Em "Database Settings" é possivel alterar o nome da Database(Caso mude terá que alterar o nome da database no arquivo AgendaDao.java dentro do Eclipse)
  
  8 No "Sumary" basta clicar em "Finish" e aguardar
  
  9 No "Results" deve aparecer "Operation Complete", confirmando que a criação do banco foi realizada com sucesso.
  
Para a importação do projeto no Eclipse
  Abra o Eclipse
  Abra o projeto "Agenda" em "File > Open Projects from File System..."
  Abrirá uma janela para a importação do projeto, clique no botão "Directory", está na linha do "import source:", procure no explorador do windows o arquivo baixado com nome de "Agenda". Selecione o arquivo e clique em "Selecionar pasta"
  Para finalizar clique em "Finish"
  
Caso não tenha o driver de conexão JDBC

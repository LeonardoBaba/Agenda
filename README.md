# Agenda
Agenda para salvar contatos salvando nome, telefone e endereço. Projeto desenvolvido em java

Pré-requisitos

Eclipse - com java.swing e windowbuilder

SQL Server 2019 configurado para caeitar conexões TCP/IP

Microsoft SQL Server Management Studio

Driver JDBC SQL SERVER - pode ser encontrado dentro da pasta SUPORTE

Faça download de todos os arquivos

<br>
<br>
<br>

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
  

<br>
<br>
<br>

Para a importação do projeto no Eclipse
  
  1 Abra o Eclipse
  
  2 Abra o projeto "Agenda" em "File > Open Projects from File System..."
  
  3 Abrirá uma janela para a importação do projeto, clique no botão "Directory", está na linha do "import source:", procure no explorador do windows o arquivo baixado com nome de "Agenda". Selecione o arquivo e clique em "Selecionar pasta"
  
  4 Para finalizar clique em "Finish"
  

<br>
<br>
<br>




Caso não tenha o driver de conexão JDBC

  1 Abra o Eclipse
  
  2 Dentro da guia "Package Explorer" clique com o botão direito no projeto e procure por "Build Path > Add External Archives..."
  
  3 Ao abrir o explorador de aruivos do windows procure pela pasta "SUPORTE > SQLJDBC_9.2 > enu > mssql-jdbc-9.2.1.jre.15.jar" selecione o arquivo "mssql-jdbc-9.2.1.jre.15.jar" e clique em "ABRIR"


<br>
<br>
<br>



Altere os dados de conexão ao banco e dados

  1 Abra o Eclipse
  
  2 Siga este caminho para abrir o arquivo a ser editado "Agenda > src > dao > ConexaoBD.java"

  3 Na linha 11 do arquivo "ConexaoBD.java" altere para o endereço e porta do servidor. Exemplo "jdbc:sqlserver://<server>:<port>;". Onde se encontra "<server>" subistitua pelo endereço do servidor, e na "<port>" susbstitua pela porta em uso. Exemplo para localhost e porta padrao "jdbc:sqlserver://localhost:1433;". Caso não saiba a porta do servidor pode-se achar esta informação no "Sql Server Configure Manager", esta no pacote de instalação do  SQl Server Management Studio, na barra lateral procure por "Configuração de rede do SQL Server", selecione o servidor que será utilizado. Clique com o botão direito em "TCP/IP", siga para as propriedades, procure pela guia "Endereços IP"
  
  4 Na linha 12 do arquivo "ConexaoBD.java" está o nome da dataBase, se o banco de dados foi criado a partir do arquivo "AgendaLeonardo.bacpac" e sem alterações no nome, não é preciso fazer alterações.
  
  5 Na linha 13 do arquivo "ConexaoBD.java" altere para seu usuario de acesso ao Banco de dados. Exemplo "user=<user>", onde está "<user>" substitua pelo seu usuario.
  
  6 Na linha 16 do arquivo "ConexaoBD.java" altere para sua senha de acesso ao Banco de dados. Exemplo "password=<password>", onde está "<password>" substitua pelo sua senha.
 
  7 Salve o arquivo

  
  
<br>
<br>
<br>
  
Para executar a aplicação

  1 Estar com todos os requisitos acima

  2 Abra o Eclipse

  3 Procure pela guia "Package Explorer" nela ficam os projetos. Clique no projeto com o botão direito "Run as > 1 Java Application"
  
  4 Uma janela irá aparecer, esta será a janela da aplicação.

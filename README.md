# Exercício11

Exercícios para manipulação de Keystores

Alunos: 
* Gabriel Garcia Salvador   
* Sidnei Lanser


# Instruções
**Questão 1:**

Dentro da pasta **"furb-dsg-exercicio11\keystore-reader\src"** encontra-se o script **"Main.java"** para retirar as informações da keystore **ks.jks** localizada dentro da pasta **"furb-dsg-exercicio11\assets\keystores"**

Após executar o script,  "informações-keystore.txt" é gerado na raíz do projeto com as informações da keystore.

**Questão 2:**

Dentro da Pasta **"\furb-dsg-exercicio11\questão2\src"** pode se encontrar dois scripts, **"AESFoto.java" "AESKey.java"**, o script **AESFoto**, utiliza do arquivo binário encontrado em **"\furb-dsg-exercicio11\assets\chavebin"** para cifrar a foto **imagemparacifrar.png** localizada na pasta **\furb-dsg-exercicio11\assets** gerando o resultado da cifragem na pasta raíz dentro do arquivo **questão1.aes**.

Executando o script **AESKey** é cifrado o mesmo arquivo binário contendo a chave em **"\furb-dsg-exercicio11\assets\chavebin"** utilizando a chave pública extraída da keystore **ks.jks**, a chave cifrada então é criada dentro da pasta raíz no arquivo **"key.aes"**.

OBS: A chavebin é usada pura para cifrar a foto, porém, a chave pública do certificado, é resumida usando SHA-1 para se encaixar dentro do tamanho de 16 bytes usados pelo algoritmo AES para então cifrar a chave.

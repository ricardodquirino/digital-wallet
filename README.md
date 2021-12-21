# Digital-wallet

Este projeto se trata de uma carteira digital que seu principal objetivo
é armazenar as transações realizadas pelos clientes.

###O que precisa para rodar:
* java 11
* lombok
* maven
* Docker 20.10.10
* Docker-Compose 1.21.2

####Baixar codigo fonte:
```
    $ git clone https://github.com/ricardodquirino/digital-wallet.git
```
####Subir o banco local:
* Executar o comando abaixo na raiz do projeto
```
    $  docker-compose up postgres-wallet
```
####Criar banco local:
* Após subir o servidor, deve ser criado um banco de dados dbWallet  
![WhatsApp Image 2021-12-21 at 06 26 29](https://user-images.githubusercontent.com/90811094/146905878-38a9f02b-213a-4eb7-b506-0b221e6d54de.jpeg)

* Após subir a aplicação basta acessar o link para ter acesso ao swagger  

http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

#### Diagrama relacional das tabelas:

![WhatsApp Image 2021-12-20 at 21 33 39](https://user-images.githubusercontent.com/90811094/146858829-ec912f4e-f4a8-435a-b98d-b5db4dcbee0f.jpeg)


#### Arquitetura de intregração dos microsserviços:
![WhatsApp Image 2021-12-20 at 21 42 33](https://user-images.githubusercontent.com/90811094/146858855-440d18f1-5a9a-47c4-bf38-4c1ffa86541d.jpeg)


#### Swagger:
![WhatsApp Image 2021-12-20 at 21 47 32](https://user-images.githubusercontent.com/90811094/146858862-a37e1d21-a0b0-490c-9db2-35a4d008d00e.jpeg)


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
* Após subir a aplicação basta acessar o link para ter acesso ao swagger  
![WhatsApp Image 2021-12-20 at 21 47 32](https://user-images.githubusercontent.com/90811094/146858737-adb69d2f-4ad5-4797-883e-d73013f64300.jpeg)

http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

#### Diagrama relacional das tabelas:
https://drive.google.com/file/d/1zk6qWY4bErgD_F6Dj1XB7FMQheGpUh8b/view?usp=sharing

#### Arquitetura de intregração dos microsserviços:
![](src/main/resources/img/WhatsApp Image 2021-12-20 at 21.42.33.jpeg)

#### Swagger:
![](src/main/resources/img/WhatsApp Image 2021-12-20 at 21.47.32.jpeg)

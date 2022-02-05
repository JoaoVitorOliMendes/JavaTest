# Teste CD2
> Implementar para empresa de transporte de cargas SigaBem o endpoint para o cálculo do preço do frete.

<i> * Necessário [Java 8+](https://www.oracle.com/java/technologies/downloads/), [MySql](https://mariadb.org/download/) e [Git](https://git-scm.com/downloads) </i>

App feito em
<h3>Java SpringBoot</h3>
    - Spring Data
    - OpenFeign
    - Swagger
    - Gson
    - Lombok
    
## Instalação

```sh
git clone https://github.com/JoaoVitorOliMendes/JavaTest.git
cd JavaTest
```

## Iniciar App

```sh
mvn spring-boot:run     *Configurar BD antes

ou

docker-compose up
```
Exemplo de requisicao POST:
```sh
  	{
  		"cepDestino": {
    		"cep": "08090-284"
  		},
  		"cepOrigem": {
    		"cep": "31070020"
  		},
  		"nomeDestinatario": "Joao Vitor de Oliveira Mendes",
  		"peso": 10.5
	}
```

Para acessar swagger-ui:
http://localhost:8080/swagger-ui.html

Caso estiver testando a aplicacao localmente:
  - Criar Banco de dados MySql JavaTest
  - Mudar Application.properties para a configuracao do banco de dados

Caso Docker
  - docker-compose up

## Meta

JoaoVitor de Oliveira Mendes – [LinkedIn](https://www.linkedin.com/in/jo%C3%A3o-vitor-de-oliveira-mendes-6874b11b3/) – joaovitordeoliveiramendes@tutanota.com

[My Profile](https://github.com/JoaoVitorOliMendes)

[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/yourname/yourproject/wiki

language: java //linguegem
deploy:
 provider: heroku //host
 api-key: 
  secute: $HEROKU_API_KEY //variavel do heroku
 app: buscacepds //nome do projeto no github
before_install:
- chmod +x mvnw //permissão para o travis instalar o maven e sua dependencias quando for fazer deploy no travis
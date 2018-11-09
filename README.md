# Walrus
[![Build Status](https://travis-ci.com/fabiendubois/Walrus.svg?branch=develop)](https://travis-ci.com/fabiendubois/Walrus)  

Spécifications de l'application : https://github.com/poutsjr/mentimaster-doc/blob/master/src/main/asciidoc/index.adoc

## API
- [x] GET `/quiz/:id` -> récupérer un quiz
- [ ] PUT `/quiz/:id` -> modifier un quiz
- [ ] POST `/quiz/:id/_join` -> lancer un quiz (incrémenter nb utilisateur)
- [ ] POST `/quiz/:id/users` -> ajouter un utilisateur à un quiz
- [x] GET `/quiz/:id/questions` -> récupérer les questions et les réponses associées
- [x] POST `/choices/:id/answers` -> répondre à une question

## Docker
Mise en place du Docker MariaDB
- Se déplacer dans le dossier docker.
- Executer la commande `docker-compose up -d`.
- Vérifier le bon fonctionnement du docker avec : `docker ps -a`.
- Connexion au container : `docker exec -it <ID CONTAINER> bash`.
- *Dans le container :* `mysql -p` pour se connecter à la base.

Afin de faciliter l'utilisation de la base de données vous pouvez utiliser SQL Electron : https://sqlectron.github.io
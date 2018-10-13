# Walrus
Application de questions / réponses.

## API

### Question :
- [x] Ajouter une question.
- [x] Supprimer une question.
- [ ] Modifier une question.
- [x] Récupérer une question.
- [x] Récupérer toute les questions.

### Choix :
- [x] Ajouter un choix.
- [x] Supprimer un choix.
- [ ] Modifier un choix.
- [x] Récupérer un choix.
- [x] Récupérer tout les choix.
- [ ] Récupérer tout les choix d'une question.

### Réponse :
- [x] Ajouter une réponse.
- [ ] Supprimer une réponse.
- [ ] Modifier une réponse.
- [x] Récupérer une réponse.
- [x] Récupérer toute les réponses.
- [ ] Récupérer toute les réponses d'une question.
- [ ] Récupérer toute les réponses d'un choix.

## Docker
Mise en place du Docker MariaDB
- Se déplacer dans le dossier docker.
- Executer la commande `docker-compose up -d`.
- Vérifier le bon fonctionnement du docker avec : `docker ps -a`.
- Connexion au container : `docker exec -it <ID CONTAINER> bash`.
- *Dans le container :* `mysql -p` pour se connecter à la base.

Afin de faciliter l'utilisation de la base de données vous pouvez utiliser SQL Electron : https://sqlectron.github.io
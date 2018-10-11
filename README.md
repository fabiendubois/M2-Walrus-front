# M2_JEE

## Docker Maria DB
Mise en place du Docker
- Se déplacer dans le dossier docker
- Executer la commande `docker-compose up -d`
- Vérifier le bon fonctionnement du docker avec : `docker ps -a`
- Connexion au container : `docker exec -it <ID CONTAINER> bash`
- *Dans le container :* `mysql -p` pour se connecter à la base

Afin de faciliter l'utilisation de la base de données vous pouvez utiliser SQL Electron : https://sqlectron.github.io
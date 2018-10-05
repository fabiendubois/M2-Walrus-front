# M2_JEE



## Docker Maria DB
Mise en place du Docker

Se déplacer dans le dossier 'docker' et faire la commande 'docker-compose up -d'
Vérification du fonctionnement : docker ps -a
Connexion au container : docker exec -it <ID CONTAINER> bash
Dans le container : mysql -p pour se connecter
Copier/coller le contenu sql
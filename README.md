# Mission Ares Backend

## Principes/Architectures

Le backend de mission ares permet de entraliser les traitement et d'intéragir avec les fronts (unreal et admin js) et
différents équipements (drone, arduino...)

## Fonctionnalités

Le backend de mission ares permet :

- d'obtenir un état du jeu
- de lancer le jeu et gérer le compte à rebours
- de mettre à disposition des messages d'aide
- de positionner une alarme
- de lancer le drone

## Schema d'architecture

## Swagger

Un swagger permet de voir l'ensemble de ressources et verbes disponibles sur le server

En local, utiliser http://localhost:8090/swagger-ui/index.html

## Hurl

Il est également possible d'interagir avec le server au moyen launcher.sh dans le repertoire d'integration

Exemple depuis la racine du projet :

```$>Launcher.sh
0. Afficher etat du jeu
1. Gestion du temps
2. Gestion des messages d'aide
>0
{
  "compteARebours":2334,
  "timestampFinDuJeu":1670507188,
  "messageAide":null,
  "electriciteGenerale":"OFF",
  "derniereAlarme":1860,
  "scenario1": {
    "porte1":"FERME"
  },
  "scenario2":{
    "porte1":"FERME"
  }
}
```

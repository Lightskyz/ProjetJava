La Disparition
=============
Projet Java - ISEP
=============
Sujet
=============

Il s’agit d’un petit jeu graphique vu du dessus pour deux joueu(r/euse)s avec contrôle au clavier. Chacun des joueu(r/euse)s peut :
  • se déplacer dans les quatre directions
  • tirer avec un pistolet à impulsion électrique
  • provoquer l’extinction des lumières (avec la barre espace)

  3.1 Contexte de l’histoire
-
Une personne décide d’effacer son profil d’un réseau social, mais la procé- dure de désactivation du compte se révèle incomplète, et la société est hors de juridiction de la CNIL. Elle décide de prendre les choses en main et d’infiltrer le réseau interne de l’entreprise pour effacer elle-même ses données personnelles nominatives, armée d’un pistolet à impulsions électriques (PIE). Elle doit pour cela atteindre l’ordinateur connecté au réseau interne et s’y maintenir consciente pendant 5 secondes consécutives. Ce personnage sera dénommé ci-après I pour infiltrant.
Une personne est de garde pour protégé le système d’information de la corporation en charge du réseau social. Elle doit capturer tout intrus (en l’occurrence le personnage I). Pour cela, elle doit se maintenir au contact de son adversaire pendant 5 secondes consécutives. Elle dispose elle aussi d’un PIE. Ce personnage sera dénommé ci-après G pour garde.
En début de partie, l’éclairage global est allumé et les personnages sont donc visibles. Une particularité de ce jeu est qu’il est possible d’éteindre cet éclairage global et de rendre alors les personnages invisibles.

  3.2 Éclairage global
-  
La particularité de l’action sur la lumière est qu’elle est commune aux deux joueu(r/euse)s : les deux joueu(r/euse)s ont accès à la même barre espace pour éteindre les lumières sur tout le niveau de jeu. Si la barre d’espace est appuyée par l’un et/*ou* l’autre, alors l’éclairage général est éteint.

  3.3 Bornes d’éclairage de secours
-  
Il y a aussi des bornes d’éclairage de secours qui éclairent localement (cases adjacentes) même lorsque l’éclairage général est éteint. Il est possible de détruire ces bornes en leur tirant dessus.

  3.4 Pistolet à impulsions électriques
-  
Chaque joueu(r/euse) dispose d’un pistolet à impulsions électriques dis- posant d’un certain nombre de charges (8) avant que la batterie ne soit épuisée. Ce pistolet a une portée de 4 cases dans la direction de déplace- ment du personnage, le pistolet touche seulement la première cible dans la limite de sa portée. Les cibles possibles sont :
  • l’autre personnage, qui est alors immobilisé pour 4 secondes
  • une borne d’éclairage de secours, qui est alors définitivement détruite (et devient un passage normal pour le reste de la partie).
Lorsqu’un PIE est utilisé, il émet des étincelles qui révèlent la position du joueur si l’éclairage était éteint.

3.5 Conditions de fin de jeu
-
Le jeu se termine lorsque l’une des conditions suivante survient :
		  • le personnage I atteint l’ordinateur et s’y maintient 5 secondes
		  • le personnage G reste 5 secondes consécutives au contact du personnage G.

3.6 Cahier des charges de base
-
Le jeu doit implémenter les règles ci-dessus pour : 
		 • un niveau de jeu prédéfini donné en annexe 
		 • d’autres niveaux de jeu.

3.7 Options
-
Si l’implémentation des spécifications ci-dessus, sous réserve de livrables de qualité, est suffisante pour avoir une bonne note, il est possible de faire mieux/plus en suivant les pistes d’améliorations suivantes.
Attention toutefois à ne pas lâcher la proie pour l’ombre ! Il ne serait pas payant de négliger la qualité des livrables pour implémenter les options.

		3.7.1 Personnages / équipements
  
En plus des personnages proposés, vous pouvez en ajouter d’autres avec différentes caractéristiques (meilleur en corps-à-corps ou plus rapide ?). De même pour l’équipement proposé, vous pouvez ajouter des variantes avec différentes caractéristiques (portée et nombre de charges d’un PIE) et/ou d’autres équipements (lampe torche, qu’on pourrait déposer/lancer ou non).

		3.7.2 GUI
  
Le jeux peut proposer une ambiance musicale et des bruitages pour accom- pagner les différentes actions. Les personnages peuvent aussi être animés.

		3.7.3 Réseau
  
Le jeux pourrait être joué à partir de deux ordinateurs en réseau, sous réserve de préserver le comportement de la barre espace commune, et que chacun ait bien la même visibilité ou non suivant que l’éclairage global soit allumé ou éteint.

		3.7.4 Intelligence Artificielle
  
Vous pouvez ajouter des robots qui remplaceraient/aideraient l’un ou l’autre des personnages.

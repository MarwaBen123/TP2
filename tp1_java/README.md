Les étapes suivantes résument l’ensemble du travail réalisé :
1) Mise en place de la classe Hero 
La classe Hero hérite de DynamicThings et doit être unique.
Un système de singleton a donc été installé :
constructeur privé, attribut static instance,méthode getInstance() qui renvoie toujours la même instance.
Un petit test (TestHero) permet de vérifier que plusieurs appels à getInstance() renvoient bien le même objet.
2) Déplacements et collisions
Le héros se déplace grâce à la méthode :
moveIfPossible(dx, dy, dungeon)
Cette méthode : déplace temporairement la hitbox,teste la collision avec les murs (SolidThings),valide ou annule le mouvement selon le cas.
Un programme de test (TestAvancerHero) permet de déplacer le héros pas à pas vers un mur et de vérifier, à chaque étape, qu’il avance correctement et s’arrête au contact du mur.
L’affichage console du donjon confirme le bon fonctionnement.
3) Ajout de la renderList dans le donjon
Pour préparer l’affichage graphique, une nouvelle liste a été ajoutée : renderList. renderList contient les objets à afficher.
Une méthode respawnListOfThings() reconstruit cette liste en relisant le tableau map.
Chaque case du donjon génère un objet :
Things si la case est vide,
SolidThings si la case contient un mur.
La liste est reconstruite automatiquement dans le constructeur du Dungeon.
Un getter permet de la récupérer pour l’affichage.
4) TileManager et gestion des tuiles
Le TileManager a été modifié afin de gérer une spritesheet :
chargement de l’image via ImageIO.read(...),
découpage en petites tuiles régulières,stockage dans un tableau 2D,mise en place d’une méthode getTile(row, col).
Une gestion d’erreur par try/catch a été ajoutée pour éviter les plantages lors du chargement de l’image.
5) Mise en place de l’interface graphique
Une interface graphique simple a été créée avec Swing.
MainInterface crée la fenêtre (JFrame), initialise le donjon, le TileManager et le héros, ajoute le panneau d’affichage.
GameRender hérite de JPanel, dessine les tuiles du donjon en parcourant renderList, dessine également le héros (rectangle rouge temporaire).
Le lancement de MainInterface ouvre une fenêtre affichant : la grille du donjon sous forme de tuiles, un carré rouge à la position du héros.

Résultats obtenus:
<img width="567" height="737" alt="image" src="https://github.com/user-attachments/assets/92eb66fc-a527-492c-b5f0-d05ee741efc2" />
<img width="448" height="225" alt="image" src="https://github.com/user-attachments/assets/a63e0f79-fa34-4efb-8abb-4a868ee332e2" />
<img width="500" height="515" alt="image" src="https://github.com/user-attachments/assets/67cc6bf1-af71-4638-9daa-83ed7f2cb9fa" />

Affichage console correct du donjon et des déplacements.
Collision fonctionnelle.
Fenêtre graphique affichant un premier rendu complet du donjon.
Conclusion du TP2
À la fin de ce TP :
Les classes de base du moteur de jeu sont opérationnelles.
Le héros est géré correctement (singleton + déplacements + collisions).
Le TileManager découpe la spritesheet et fournit les tuiles.
Le donjon s'affiche maintenant dans une fenêtre graphique.
Tout est prêt pour la suite (TP3) où l’affichage sera amélioré et animé.

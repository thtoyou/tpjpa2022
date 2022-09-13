# Template de projet pour le TP JPA 2021 UniR

La première phase à été de mettre au point le schéma UML à utiliser. 
J'ai décidé de rester simple avec seulement 3 classes et 1 interface: 
ConcreteUser, Prof et Appointment d'une part et User d'autre part. 

ConreteUser et prof héritent de User. Les relations entre ConcreteUser et Appointment sont 1-* de telle sorte que 
seul 1 concreteUser et 1 Prof est présent à chaque Appointment. 
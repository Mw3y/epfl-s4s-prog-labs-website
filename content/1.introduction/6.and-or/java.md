---
title: 'Or, and et else'
description: 'Utilisez les opérateurs logiques pour combiner des conditions.'

code:
  default: |
    import java.util.Scanner;

    class Main {
        public static void main(String[] args) {
            // ne faites pas attention à ces deux lignes
            // elles servent à initialiser les variables
            // (voir le cours)
            Scanner scanner = new Scanner(System.in);
            int heures = scanner.nextInt();
            int minutes = scanner.nextInt();
            
            // complétez le code
        }
    }
  corrected: |
    import java.util.Scanner;

    class Main {
        public static void main(String[] args) {
            // ne faites pas attention à ces deux lignes
            // elles servent à initialiser les variables
            // (voir le cours)
            Scanner scanner = new Scanner(System.in);
            int heures = scanner.nextInt();
            int minutes = scanner.nextInt();
            
            if (heures == 8 && minutes == 15) {
                System.out.println("Good morning EPFL");
            } else {
                System.out.println("EPFL");
            }
        }
    }

tests:
  - input: |
      8
      15
    expectedOutput: |-
      Good morning EPFL
  - input: |
      8
      16
    expectedOutput: |-
      EPFL
---

### Objectif

Dans certains cas, on peut vouloir exécuter un morceau de code si une condition est vérifiée et un morceau différent si elle ne l’est pas. Ceci est fait au moyen du branchement conditionnel `else` .

De même, on veut souvent vérifier si des combinaisons de conditions sont vraies (par exemple une condition A **ou** une condition B est vraie, ou alors les deux en même temps).

### Consigne

Vous disposez de deux variables contenant des nombres :

- une variable `heures`
- une variable `minutes`

Vérifiez si la variable `heures` contient `8` et la variable `minutes` contient `15` alors affichez `Good morning EPFL` sinon affichez simplement `EPFL`.

### Cours

Ici, vous aurez besoin de combiner `if` et `else` comme suit :

```java
if (condition1) {
	System.out.println("La première condition est vraie.")
} else if (condition2) {
	System.out.println("La seconde condition est vraie.")
} else {
	System.out.println("Aucune des deux conditions n'est vraie.")
}
```

Dans la quasi-totalité des langages de programmation que vous rencontrerez, il existe ce que l’on appelle des _opérateurs logiques._ Ce sont des opérateurs destinés à combiner ou modifier vos conditions et permettre plus de flexibilité.

**Opérateur OU : si au moins une des N propositions est vraie**

**Opérateur ET : si toutes les N propositions sont vraies**

Par exemple :

```java
// and ("et" logique)
if (condition1 && condition2) {
	System.out.println("La condition1 ET la condition2 sont vraies");
}

// or ("ou" logique)
if (condition1 || condition2) {
	System.out.println("La condition1 est vraie OU la condition2 est vraie OU les deux.");
}

// not (négation logique)
if (!condition1) {
	System.out.println("La condition1 est fausse.");
}
```

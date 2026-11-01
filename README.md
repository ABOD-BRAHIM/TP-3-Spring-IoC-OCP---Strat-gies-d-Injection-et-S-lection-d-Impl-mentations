## 6. Configuration avancée de Spring et injection des dépendances

### 6.1. Configuration principale – AppConfig

La classe `AppConfig` active le balayage automatique des composants avec `@ComponentScan`, importe les propriétés externes et intègre d'autres classes de configuration avec `@Import`.
![Capture d'écran 2026-11-01 155103.png](screnshot/Capture%20d%27%C3%A9cran%202026-11-01%20155103.png)
### 6.2. Déclaration d'un bean – DaoAliasConfig

La classe `DaoAliasConfig` définit un bean Spring nommé `daoAlias` à l'aide de `@Bean`. Ce bean instancie et retourne une implémentation spécifique de type `DaoApi`.

![Capture d'écran 2026-11-01 155131.png](screnshot/Capture%20d%27%C3%A9cran%202026-11-01%20155131.png)
### 6.3. Sélection dynamique du DAO – DynamicDaoConfig

La classe `DynamicDaoConfig` utilise `@Primary` et une structure conditionnelle basée sur les propriétés de configuration pour sélectionner dynamiquement l'implémentation DAO à charger.

### 6.4. Injection de plusieurs DAO – MetierMultiple

La classe `MetierMultiple` implémente l'interface `IMetier` en injectant une collection et une correspondance de beans DAO (`Map`) afin d'agréger leurs calculs.
![Capture d'écran 2026-11-01 155216.png](screnshot/Capture%20d%27%C3%A9cran%202026-11-01%20155216.png)
### 6.5. Initialisation du contexte Spring – App

La classe principale `App` initialise le contexte Spring, active un profil spécifique de manière programmatique, charge la configuration et exécute le traitement métier.

![Capture d'écran 2026-11-01 155228.png](screnshot/Capture%20d%27%C3%A9cran%202026-11-01%20155228.png)
### 6.6. Test unitaire – OcpSelectionTest

La classe de test `OcpSelectionTest` vérifie le bon fonctionnement du conteneur Spring et valide le résultat attendu du calcul métier par défaut.

![Capture d'écran 2026-11-01 155239.png](screnshot/Capture%20d%27%C3%A9cran%202026-11-01%20155239.png)
package com.example;

import com.example.config.AppConfig;
import com.example.metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Crée le conteneur sans démarrage immédiat
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        // Active le profil AVANT le démarrage du conteneur
        context.getEnvironment().setActiveProfiles("prod");

        // Enregistre la configuration et démarre le conteneur
        context.register(AppConfig.class);
        context.refresh();

        // Affiche la source de configuration résolue
        String daoTarget = context.getEnvironment()
                .getProperty("DAO_TARGET",
                        context.getEnvironment().getProperty("dao.target", "dao"));
        System.out.println("[CONFIG] DAO cible résolue : " + daoTarget
                + " (env DAO_TARGET > app.properties > défaut)");

        // Récupère le bean métier
        IMetier metier = context.getBean(IMetier.class);

        // Exécute le calcul
        double resultat = metier.calacul();
        System.out.println("Résultat final : " + resultat);

        // Ferme le conteneur
        context.close();
    }
}

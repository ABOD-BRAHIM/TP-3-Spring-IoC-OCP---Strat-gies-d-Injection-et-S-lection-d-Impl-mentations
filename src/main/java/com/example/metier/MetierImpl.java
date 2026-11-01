package com.example.metier;

import com.example.dao.IDao;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier {
    private final IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }


    @PostConstruct
    public void init() {
        System.out.println("[TRACE] Implémentation DAO injectée : " + dao.getClass().getSimpleName());
    }

    @Override
    public double calacul() {
        double valeur = dao.getValu();
        return valeur * 2.0;
    }
}

package com.zy.instagramstalker.service;

import com.zy.instagramstalker.model.InstagramUser;
import com.zy.instagramstalker.persistence.SaveStrategy;

public class Persister {
    private SaveStrategy persistant;

    public Persister(SaveStrategy saver) {
        this.persistant = saver;
    }
    public void save(InstagramUser user){
        persistant.save(user);
    }
    public InstagramUser getUser(){
        return persistant.getUser();
    }
}

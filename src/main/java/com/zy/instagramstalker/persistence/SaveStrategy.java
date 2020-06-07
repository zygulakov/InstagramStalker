package com.zy.instagramstalker.persistence;

import com.zy.instagramstalker.model.InstagramUser;

public interface SaveStrategy {
    void save(InstagramUser user);
    InstagramUser getUser();

}

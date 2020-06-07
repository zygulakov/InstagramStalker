package com.zy.instagramstalker;

import com.zy.instagramstalker.model.InstagramUser;
import com.zy.instagramstalker.persistence.TextSaver;
import com.zy.instagramstalker.service.Persister;

public class Stalker {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.exit(0);
        }
        String target = args[0];
        String file = args[1];
        int timer = Integer.parseInt(args[2]) * 1000;

        Parser parser = new Parser(target);
        Persister persister = new Persister(new TextSaver(file));
        while (true) {
            String result = parser.parse();
            InstagramUser user = parser.convertToModel(result);
            persister.save(user);
            Thread.sleep(timer);
        }

    }
}

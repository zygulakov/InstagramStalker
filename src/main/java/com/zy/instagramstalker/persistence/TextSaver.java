package com.zy.instagramstalker.persistence;

import com.zy.instagramstalker.model.InstagramUser;

import javax.swing.*;
import java.io.*;
import java.util.Date;

//saves Object as a text like log
//need file where to save  and InstagramUser object to get data
public class TextSaver implements SaveStrategy {
    private File file;

    public TextSaver(String file) {
        try{
            this.file = new File(file);
            if(!this.file.exists())
                this.file.createNewFile();
        }catch (Exception e){
            System.out.println("wrong destination to save");
        }
    }

    public void save(InstagramUser user) {
        try{
            String text = "Followers: "+user.getFollower()+" Followings: "+user.getFollowing()
                    +" Posts: "+user.getPost()+" User: "+user.getUserName()+" Date: "+new Date().toString();
            PrintWriter writer = new PrintWriter(new FileOutputStream(file,true),true);
            writer.append(text);
            writer.append("\n");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("couldnt save");
        }
    }

    public InstagramUser getUser() {
        return null;
    }
}

package com.zy.instagramstalker;

import com.zy.instagramstalker.model.InstagramUser;
import com.zy.instagramstalker.service.Persister;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;

//accepts target username and fetching info
//also can parse data as String to model object (InstagramUser)
public class Parser {
    private String target;

    public Parser(String target) {
        this.target = target;
    }

    //parsing html by jsoup and getting part where data are located
    //returns raw String ex:
    // [number] Followers, [number] Following, [number] Posts - See Instagram photos and videos from [@username]
    public String parse() throws Exception {
        URL url = new URL("https://www.instagram.com/" + target + "/");
        String regex = "[content~=Followers]";
        Document doc = Jsoup.parse(url, 10000);
        Elements el = doc.getElementsByTag("meta");
        Elements e = el.select(regex);
        String s = e.attr("content");
        return s;

    }

    //converts raw data produced drom parse method to InstagramUser object by splitting
    public InstagramUser convertToModel(String rawData) {
        ///[number] Followers, [number] Following, [number] Posts - See Instagram photos and videos from [@username]
        InstagramUser user = new InstagramUser();
        String str = rawData.split("-")[0]; // getting part where is data;
        //[number] Followers, [number] Following, [number] Posts
        //  0          1         2          3         4      5
        int followers = Integer.parseInt(str.split(" ")[0].replace(",","")); // getting number of Followers
        int followings = Integer.parseInt(str.split(" ")[2].replace(",","")); // getting number of Following
        int posts = Integer.parseInt(str.split(" ")[4].replace(",","")); // getting number of Posts
        user.setFollower(followers);
        user.setFollowing(followings);
        user.setPost(posts);
        user.setUserName(target);
        return user;
    }
}

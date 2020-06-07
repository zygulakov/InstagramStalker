import com.zy.instagramstalker.Parser;
import com.zy.instagramstalker.model.InstagramUser;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {
    Parser parser = new Parser("mock");
    private final String data1 = "2,213 Followers, 222 Following, 1 Posts - See Instagram photos and videos from @username";
    private final String data2 = "213 Followers, 2,222 Following, 1 Posts - See Instagram photos and videos from @username";
    private final String data3 = "213 Followers, 222 Following, 1,111 Posts - See Instagram photos and videos from @username";

    InstagramUser user = new InstagramUser();

    @Test
    public void parseTest(){
        user.setFollower(2213);
        user.setFollowing(222);
        user.setPost(1);
        Assert.assertEquals(user,parser.convertToModel(data1));

        user.setFollower(213);
        user.setFollowing(2222);
        user.setPost(1);
        Assert.assertEquals(user,parser.convertToModel(data2));

        user.setFollower(213);
        user.setFollowing(222);
        user.setPost(1111);
        Assert.assertEquals(user,parser.convertToModel(data3));
    }

}

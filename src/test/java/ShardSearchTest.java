import org.junit.Test;
import org.openstreetmap.atlas.streaming.resource.File;

import static org.junit.Assert.assertEquals;

public class ShardSearchTest
{
    @Test public void ShardSearchTest()
    {
        File out = new File("temp/searchShard.atlas");
        if (out.exists()){
            out.delete();
        }

        final String[] ids = {"24187910000001","405584527000000"};
        ShardSearch.ShardSearch(new File(ShardSearchTest.class.getResource("shards").getPath()), out, ids);

        assertEquals("",true,out.exists());
    }
}
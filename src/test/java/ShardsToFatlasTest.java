import org.junit.Test;
import org.openstreetmap.atlas.streaming.resource.File;

import static org.junit.Assert.*;

public class ShardsToFatlasTest
{
    @Test public void deshard()
    {
        File out = new File("temp/deshard.atlas");
        if (out.exists()){
            out.delete();
        }

        ShardsToFatlas.ShardsToFatlas(new File(ShardsToFatlasTest.class.getResource("shards").getPath()), out);

        assertEquals("",true,out.exists());
    }
}
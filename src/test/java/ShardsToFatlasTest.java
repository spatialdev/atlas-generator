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

        ShardsToFatlas.ShardsToFatlas(out, new File(ShardsToFatlasTest.class.getResource("shards").getPath()));

        assertEquals("",true,out.exists());
    }

    @Test public void deshard_list()
    {
        File out = new File("temp/deshard.atlas");
        if (out.exists()){
            out.delete();
        }

        ShardsToFatlas.ShardsToFatlas(out, new File(ShardsToFatlasTest.class.getResource("shards/ASM_6-1-33.atlas").getPath()),
                new File(ShardsToFatlasTest.class.getResource("shards/ASM_6-1-34.atlas").getPath()));

        assertEquals("",true,out.exists());
    }
}
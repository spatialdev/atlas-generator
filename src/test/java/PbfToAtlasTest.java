import org.junit.Test;
import org.openstreetmap.atlas.streaming.resource.File;

import static org.junit.Assert.*;

public class PbfToAtlasTest
{

    @Test public void save()
    {
        File out = new File("temp/pt_test_export.atlas");
        if (out.exists()){
            out.delete();
        }

        new PbfToAtlas(new File(PbfToAtlasTest.class.getResource("pt_test_export.pbf").getPath())).save(out);

        assertEquals("",true,out.exists());
    }
}
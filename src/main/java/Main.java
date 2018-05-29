import org.openstreetmap.atlas.streaming.resource.File;

import java.io.IOError;

public class Main {
    public static void main(String[] args)
    {
        File pbf = new File(args[1]);
        if (!pbf.exists() || pbf.isDirectory()){
            throw new IOError(new Throwable("expected a file path as input"));
        }

        File out = new File(args[0]);
        if (out.isDirectory()){
            throw new IOError(new Throwable("expected file path for output, got directory"));
        }

        PbfToAtlas atlas = new PbfToAtlas(pbf,args[2]);
        atlas.save(out);
    }
}


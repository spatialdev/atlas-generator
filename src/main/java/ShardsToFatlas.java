import org.openstreetmap.atlas.geography.atlas.Atlas;
import org.openstreetmap.atlas.geography.atlas.AtlasResourceLoader;
import org.openstreetmap.atlas.geography.atlas.packed.PackedAtlas;
import org.openstreetmap.atlas.geography.atlas.packed.PackedAtlasCloner;
import org.openstreetmap.atlas.streaming.resource.File;

import java.io.IOError;

public class ShardsToFatlas
{
    public static void main(String[] args)
    {
        File shards = new File(args[1]);
        if (!shards.exists() || !shards.isDirectory()){
            throw new IOError(new Throwable("expected a directory path as input"));
        }

        File out = new File(args[0]);
        if (out.isDirectory()){
            throw new IOError(new Throwable("expected file path for output, got directory"));
        }

        ShardsToFatlas(shards, out);
        System.out.println("done");
    }

    //Creates a single .atlas file from the directory of .atlas files at the given path.
    public static void ShardsToFatlas(File shardDir, File out){
        System.out.println("Loading shards...");
        final Atlas atlas = new AtlasResourceLoader().load(shardDir);
        System.out.println("Packing atlas...");
        final PackedAtlas pAtlas = new PackedAtlasCloner().cloneFrom(atlas);
        System.out.println("Saving atlas...");
        pAtlas.save(out);
    }
}
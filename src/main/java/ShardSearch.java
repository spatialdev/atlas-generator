import org.openstreetmap.atlas.geography.atlas.command.AtlasReader;
import org.openstreetmap.atlas.streaming.resource.File;

import java.io.IOError;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShardSearch
{
    public static void main(String[] args)
    {
        final File shards = new File(args[1]);
        if (!shards.exists() || !shards.isDirectory()){
            throw new IOError(new Throwable("expected a directory path as input"));
        }

        final File out = new File(args[0]);
        if (out.isDirectory()){
            throw new IOError(new Throwable("expected file path for output, got directory"));
        }

        final String[] ids = args[2].split(",");
        ShardSearch(shards, out, ids);
        System.out.println("done");
    }

    public static void ShardSearch(final File input, final File output, final String[] ids){
        final List<String> idList = new ArrayList<>();
        for (final String id : ids){
            final String osmId = id.substring(0,id.length()-6);
            final String section = id.substring(id.length()-6);
            idList.add(String.format("OSM_N_%1$s_%2$s", osmId, section));
            idList.add(String.format("OSM_W_%1$s_%2$s", osmId, section));
            idList.add(String.format("OSM_R_%1$s_%2$s", osmId, section));
        }

        final PrintStream originalOut = System.out;
        final captureOutputStream captureStream = new captureOutputStream(originalOut);
        System.setOut(captureStream);

        new AtlasReader("find", String.format("-input=%1$s", input.getPath()), String.format("-id=%1$s", String.join(",", idList)))
                .runWithoutQuitting("find", String.format("-input=%1$s", input.getPath()), String.format("-id=%1$s", String.join(",", idList)));

        System.setOut(originalOut);

        final List<String> shards = new ArrayList<>();
        final Matcher matchShard = Pattern.compile("--> \\[.*:(.*\\.atlas)").matcher(captureStream.log);
        while (matchShard.find()){
            final String shard =input+"/"+matchShard.group(1);
            if (!shards.contains(shard))
            {
                shards.add(shard);
            }
        }
        ShardsToFatlas.ShardsToFatlas(output, shards.stream().map(File::new).toArray(File[]::new));
    }
}

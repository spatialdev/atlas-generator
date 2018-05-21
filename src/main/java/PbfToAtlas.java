import org.openstreetmap.atlas.streaming.resource.File;
import org.openstreetmap.atlas.geography.atlas.pbf.OsmPbfLoader;

public class PbfToAtlas
{
    private final OsmPbfLoader atlas;

    public PbfToAtlas(File pbf) {
        this.atlas = new OsmPbfLoader(pbf);
    }

    public void save(File out){
        this.atlas.saveAtlas(out);
    }
}

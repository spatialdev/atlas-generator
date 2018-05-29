import org.openstreetmap.atlas.geography.MultiPolygon;
import org.openstreetmap.atlas.geography.atlas.pbf.AtlasLoadingOption;
import org.openstreetmap.atlas.geography.boundary.CountryBoundaryMap;
import org.openstreetmap.atlas.streaming.resource.File;
import org.openstreetmap.atlas.geography.atlas.pbf.OsmPbfLoader;

import java.util.Collections;

public class PbfToAtlas
{
    private final OsmPbfLoader atlas;
    private final static MultiPolygon polygon = MultiPolygon.MAXIMUM;

    public PbfToAtlas(File pbf, String iso) {

        final CountryBoundaryMap map = CountryBoundaryMap.fromBoundaryMap(Collections.singletonMap(iso, this.polygon));
        final AtlasLoadingOption option = AtlasLoadingOption.createOptionWithAllEnabled(map);
        this.atlas = new OsmPbfLoader(pbf, this.polygon, option);
    }

    public void save(File out){
        this.atlas.saveAtlas(out);
    }
}

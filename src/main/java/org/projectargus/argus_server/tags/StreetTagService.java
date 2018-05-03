package org.projectargus.argus_server.tags;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.projectargus.argus_server.tags.pictures.TagPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetTagService {
    
    private StreetTagRepository tagRepository;
    
    private GeoDataRepository geoDataRepository;
    
    private TagPictureRepository pictureRepository;

    @Autowired
    public StreetTagService(StreetTagRepository tagRepository,
                            GeoDataRepository geoDataRepository,
                            TagPictureRepository pictureRepository) {
        this.tagRepository = tagRepository;
        this.geoDataRepository = geoDataRepository;
        this.pictureRepository = pictureRepository;
    }

    public ArrayNode getPrivateTags(Long id) {
        List<StreetTag> privateTags = tagRepository.findByPrivacy(Privacy.PRIVATE);
        return packTagDetailsIntoJson(privateTags);
    }

    private ArrayNode packTagDetailsIntoJson(List<StreetTag> privateTags) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode result = mapper.createArrayNode();
        for (StreetTag tag:privateTags) {
            ObjectNode geoData = mapper.createObjectNode();
            geoData.put("altitude", tag.getGeoData().getAltitude());
            geoData.put("bearing", tag.getGeoData().getBearing());
            geoData.put("latitude", tag.getGeoData().getLatitude());
            geoData.put("longitude", tag.getGeoData().getLongitude());
            geoData.put("target-latitude", tag.getGeoData().getTargetLatitude());
            geoData.put("target-longitude", tag.getGeoData().getTargetLongitude());
            geoData.put("zoom", tag.getGeoData().getZoom());
            result.add(geoData);

            ObjectNode pictureData = mapper.createObjectNode();
            pictureData.put("picture-data", tag.getPicture().getTagData());
            result.add(pictureData);
        }
        return result;
    }
}

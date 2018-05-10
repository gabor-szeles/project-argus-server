package org.projectargus.argus_server.tags;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.projectargus.argus_server.tags.pictures.TagPicture;
import org.projectargus.argus_server.tags.pictures.TagPictureRepository;
import org.projectargus.argus_server.users.User;
import org.projectargus.argus_server.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetTagService {
    
    private StreetTagRepository tagRepository;
    
    private GeoDataRepository geoDataRepository;
    
    private TagPictureRepository pictureRepository;

    private UserRepository userRepository;

    @Autowired
    public StreetTagService(StreetTagRepository tagRepository,
                            GeoDataRepository geoDataRepository,
                            TagPictureRepository pictureRepository,
                            UserRepository userRepository) {
        this.tagRepository = tagRepository;
        this.geoDataRepository = geoDataRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
    }

    public ObjectNode getPrivateTags(Long id) {
        List<StreetTag> privateTags = tagRepository.findAllByIdAndPrivacy(id, Privacy.PRIVATE);
        return packTagDetailsIntoJson(privateTags);
    }

    private ObjectNode packTagDetailsIntoJson(List<StreetTag> privateTags) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = mapper.createObjectNode();

        if(privateTags.isEmpty()) {
            result.put("found", false);
        } else {
            result.put("found", true);
            for (StreetTag tag:privateTags) {
                ObjectNode geoData = mapper.createObjectNode();
                geoData.put("altitude", tag.getGeoData().getAltitude());
                geoData.put("bearing", tag.getGeoData().getBearing());
                geoData.put("latitude", tag.getGeoData().getLatitude());
                geoData.put("longitude", tag.getGeoData().getLongitude());
                geoData.put("target-latitude", tag.getGeoData().getTargetLatitude());
                geoData.put("target-longitude", tag.getGeoData().getTargetLongitude());
                geoData.put("zoom", tag.getGeoData().getZoom());
                result.put("geo-data", geoData);

                ObjectNode pictureData = mapper.createObjectNode();
                pictureData.put("picture-data", tag.getPicture().getTagData());
                result.put("tag-picture", pictureData);
            }
        }
        return result;
    }

    public void savePic(StreetTagDto streetTagDto) {
        User admin = userRepository.findByUserName(streetTagDto.getUserName());
        GeoData testGeoData = geoDataRepository.findOne(1L);
        TagPicture newPic = new TagPicture(streetTagDto.getImageData().getBytes());
        StreetTag testTag = new StreetTag(newPic, admin, testGeoData, Privacy.PRIVATE);
        pictureRepository.save(newPic);
        tagRepository.save(testTag);
    }
}

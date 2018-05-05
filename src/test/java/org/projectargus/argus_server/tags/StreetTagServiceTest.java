package org.projectargus.argus_server.tags;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.projectargus.argus_server.tags.pictures.TagPicture;
import org.projectargus.argus_server.tags.pictures.TagPictureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StreetTagServiceTest {

    private static StreetTagService testService;

    private static StreetTagRepository mockTagRepository;
    private static GeoDataRepository mockGeoDataRepository;
    private static TagPictureRepository mockPictureRepository;

    private static GeoData dummyGeoData;
    private static TagPicture mockPicture;
    private static StreetTag mockTag;

    @BeforeAll
    public static void setUp() {
        mockGeoDataRepository = mock(GeoDataRepository.class);
        mockPictureRepository = mock(TagPictureRepository.class);
        mockTagRepository = mock(StreetTagRepository.class);

        testService = new StreetTagService(mockTagRepository, mockGeoDataRepository, mockPictureRepository);
        mockTag = mock(StreetTag.class);
        mockPicture = mock(TagPicture.class);
        dummyGeoData = new GeoData(mockTag, BigDecimal.ONE, BigDecimal.ONE,
                                    BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE,
                                        1f, 1f, 1f);
    }

    @Test
    public void testGetPrivateTagsWorksCorrectly() {
        List<StreetTag> testList = Arrays.asList(mockTag);
        when(mockPicture.getTagData()).thenReturn(new byte[]{});
        when(mockTag.getGeoData()).thenReturn(dummyGeoData);
        when(mockTag.getPicture()).thenReturn(mockPicture);
        when(mockTagRepository.findAllByIdAndPrivacy(any(Long.class), any(Privacy.class))).thenReturn(testList);
        ObjectNode testResult = testService.getPrivateTags(1L);
        assertEquals(7, testResult.get("geo-data").size());
    }

    @Test
    public void testGetPrivateTagsReturnsWarningWHenListIsEmpty() {
        List<StreetTag> testList = new ArrayList<>();
        when(mockTagRepository.findAllByIdAndPrivacy(any(Long.class), any(Privacy.class))).thenReturn(testList);
        ObjectNode testResult = testService.getPrivateTags(1L);
        assertEquals(false, testResult.get("found").asBoolean());
    }


}
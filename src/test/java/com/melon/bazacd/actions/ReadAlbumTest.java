package com.melon.bazacd.actions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.melon.bazacd.model.Album;
import com.melon.bazacd.testutils.TestDbFileProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class ReadAlbumTest {

    private ReadAlbum readAlbum;

    @BeforeEach
    void init() {
        this.readAlbum = new ReadAlbum();
    }

    @Test
    void read_should_returnCorrectAlbumList_when_properFileAndHeadingSizeGiven() {
        // given
        File chosenDb = TestDbFileProvider.getCorrectDb();
        int headingSize = 3;

        int expectedSize = 3;

        // when
        List<Album> result = this.readAlbum.readAlbumsDbToList(chosenDb, headingSize);

        // then
        assertThat(result).hasSize(expectedSize);
        assertThat(result.get(0).getBand()).isEqualTo("Moonspell");

    }
    @Test
    void read_shouldNot_returnCorrectAlbumList_when_properFileAndWrongHeadingSizeGiven(){
        //given
        File chosenDb = TestDbFileProvider.getCorrectDb();
        int headingSize = 4;

        // when
        List<Album> result = this.readAlbum.readAlbumsDbToList(chosenDb, headingSize);

        //then
        assertThat(result.get(0).getBand()).doesNotContain("Moonspell");
    }


}
package io.github.peterkaivo.muzmuz.dataservice;

import io.github.peterkaivo.muzmuz.common.types.MediaType;
import io.github.peterkaivo.muzmuz.dataservice.model.DAudio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AudioDataServiceTest {

    @Autowired
    private AudioDataService audioDataService;

    @Test
    public void testRead() {
        DAudio dAudio = audioDataService.findById(2L).orElse(null);
        assertNotNull(dAudio);
        assertEquals(MediaType.AUDIO, dAudio.getType());
        assertEquals("Minuetto dei Ciechi", dAudio.getName());
        assertEquals("14_String_Quintet_in_C_Major.mp3", dAudio.getFileName());
        assertEquals("3rd movement from Op. 30 Musica notturna delle strade di Madrid", dAudio.getDescription());
        assertEquals("It's really a film music", dAudio.getComments());
        assertEquals("9:24", dAudio.getLength());
    }

    @Test
    public void testReadAll() {
        List<DAudio> allAudios = (List<DAudio>) audioDataService.findAll();
        assertNotNull(allAudios);
        assertEquals(2, allAudios.size());
    }

    @Test
    public void testCRUD() {
        DAudio dAudio1 = new DAudio(null, "Schindler's List Theme", "theme_song.mp3",
                "Theme song from the movie by Itzhak Perlman", "Directed by Steven Spielberg", "3:31");
        DAudio dAudio2 = audioDataService.save(dAudio1);

        DAudio dAudio3 = audioDataService.findById(dAudio2.getId()).orElse(null);
        assertNotNull(dAudio3);
        assertEquals(MediaType.AUDIO, dAudio3.getType());
        assertEquals("Schindler's List Theme", dAudio3.getName());
        assertEquals("theme_song.mp3", dAudio3.getFileName());
        assertEquals("Theme song from the movie by Itzhak Perlman", dAudio3.getDescription());
        assertEquals("Directed by Steven Spielberg", dAudio3.getComments());
        assertEquals("3:31", dAudio3.getLength());

        dAudio3.setFileName("theme_song_by_itzhak_perlman.mp3");
        dAudio3.setDescription("Theme song from the movie by John Williams");
        audioDataService.save(dAudio3);

        DAudio dAudio4 = audioDataService.findById(dAudio2.getId()).orElse(null);
        assertNotNull(dAudio4);
        assertEquals("theme_song_by_itzhak_perlman.mp3", dAudio4.getFileName());
        assertEquals("Theme song from the movie by John Williams", dAudio4.getDescription());

        audioDataService.deleteById(dAudio4.getId());

        DAudio dAudio5 = audioDataService.findById(dAudio2.getId()).orElse(null);
        assertNull(dAudio5);
    }
}

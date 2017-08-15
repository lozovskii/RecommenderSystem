package com.recommendSystem;

import com.recommendSystem.config.AppConfig;
import com.recommendSystem.constant.ConstantsConservative;
import com.recommendSystem.model.Song;
import com.recommendSystem.model.Track;
import com.recommendSystem.model.User;
import com.recommendSystem.service.SongService;
import com.recommendSystem.service.TrackService;
import com.recommendSystem.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class MainTest {

    @Autowired
    private SongService songService;
    @Autowired
    private UserService userService;
    @Autowired
    private TrackService trackService;

    @Test
    public void shouldAddToDBListSongFromXML(){
        String path = "For_Recommendations.xml";
        List<Song> songs = songService.getListSongParseXML(path);
        long trackN = 1;
        for(Song song: songs){
            User user = new User(song.getImei());

            if(!userService.isExist(user)){
                userService.addUser(user);
                songService.addSong(song);
            }else{
                System.out.println("User is exist!");
                songService.addSong(song);
            }

            User userForTrack = userService.fetchUser(user.getImei());
            Track track = new Track(userForTrack.getId(), trackN, song.getSongDate(), song.getSongNameArtist(), song.getSongName());
            if(track.getTrackN() == 1) {

                double r = trackService.getR()
                trackService.mainFormulaForGiveAMarkMu(ConstantsConservative.ETA_ZERO, track.getTrackRewardN(), r);//
            }
            if(trackService.isExist(track)){
                trackN++;
                System.out.println("Считаем новое значение N!");
            }else{
                trackService.addTrack(track);
            }
        }
    }

    @Test
    public void shouldCheckIsExistUser(){
        String path = "For_Recommendations.xml";
        List<Song> songs = songService.getListSongParseXML(path);
        for(Song song: songs) {
            User user = new User(song.getImei());
            boolean exist = userService.isExist(user);
            System.out.println(exist);
        }
    }

    @Test
    public void shouldFetchUser(){
        User user1 = userService.fetchUser(1);
        System.out.println();
        System.out.println(user1.getImei());
    }

    @Test
    public void shouldToString(){
        User user = new User();
        user.setImei(12345);

        System.out.println(user);
    }

    @Test
    public void souldFetchSongFromDB(){
        try {
            Song song = songService.fetchSong(3);

            System.out.println(song);

            assertThat(song.getSongDate() != null, is(notNullValue()));
        }catch (NullPointerException e){
            System.err.println("Song with this ID is not exist!\nTry another ID.");
        }
    }

    @Test
    public void shouldUpdateSong(){
        String changeNameSong = "oneSongTest";
        Song songBeforeUpdate = songService.fetchSong(1);
        songBeforeUpdate.setSongName(changeNameSong);
        songService.updateSong(songBeforeUpdate);

        Song songAfterUpdate = songService.fetchSong(1);

        assertThat(songAfterUpdate.getSongName(),is(equalTo(changeNameSong)));
    }

    @Test
    @Ignore
    public void shouldPrintDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String realDate = dateFormat.format(date);
        System.out.println(realDate);
    }


    @Test
    @Ignore
    public void shouldWriteToListFromXML(){
        String path = "For_Recommendations.xml";
        List<Song> songs = songService.getListSongParseXML(path);
        System.out.println(songs.size());
        for (Song song: songs) {
            System.out.println(song);
        }
    }
}
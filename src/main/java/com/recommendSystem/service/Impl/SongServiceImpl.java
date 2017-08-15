package com.recommendSystem.service.Impl;

import com.recommendSystem.model.Song;
import com.recommendSystem.repository.SongRepository;
import com.recommendSystem.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    public void addSong(Song song){
        songRepository.addSong(song);
    }

    public Song fetchSong(long id) {
        return songRepository.fetchSong(id);
    }

    @Override
    public List<Song> getListSongParseXML(String path) {
        List<Song> listSong = new ArrayList<>();
        Song song = null;

        boolean nImei = false;
        boolean nSong_date = false;
        boolean nSong_name_artist = false;
        boolean nSong_name = false;
        boolean nSong_name_album = false;
        boolean nSong_name_genre = false;
        boolean nSong_name_author = false;
        boolean nSong_duration = false;
        boolean nSong_status = false;

        try{
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(path));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase("song")) {
                            System.out.println("Start Element : song");
                            song = new Song();
                        }else if (qName.equalsIgnoreCase("imei")) {
                            nImei = true;
                        }else if (qName.equalsIgnoreCase("song_date")) {
                            nSong_date = true;
                        }else if (qName.equalsIgnoreCase("song_name_artist")) {
                            nSong_name_artist = true;
                        }else if (qName.equalsIgnoreCase("song_name")) {
                            nSong_name = true;
                        }else if (qName.equalsIgnoreCase("song_name_album")) {
                            nSong_name_album = true;
                        }else if (qName.equalsIgnoreCase("song_name_genre")) {
                            nSong_name_genre = true;
                        }else if (qName.equalsIgnoreCase("song_name_author")) {
                            nSong_name_author = true;
                        }else if (qName.equalsIgnoreCase("song_duration")) {
                            nSong_duration = true;
                        }else if (qName.equalsIgnoreCase("song_status")) {
                            nSong_status = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                    if (nImei) {
                        song.setImei(Long.valueOf(characters.getData()));
                        nImei = false;
                    }else if (nSong_date) {
                        song.setSongDate(characters.getData());
                        nSong_date = false;
                    }else if (nSong_name_artist) {
                        song.setSongNameArtist(characters.getData());
                        nSong_name_artist = false;
                    }else if (nSong_name) {
                        song.setSongName(characters.getData());
                        nSong_name = false;
                    }else if (nSong_name_album) {
                        song.setSongNameAlbum(characters.getData());
                        nSong_name_album = false;
                    }else if (nSong_name_genre) {
                        song.setSongNameGenre(characters.getData());
                        nSong_name_genre = false;
                    }else if (nSong_name_author) {
                        song.setSongNameAuthor(characters.getData());
                        nSong_name_author = false;
                    }else if (nSong_duration) {
                        song.setSongDuration(Integer.valueOf(characters.getData()));
                        nSong_duration = false;
                    }else if (nSong_status) {
                        song.setSongStatus(Integer.valueOf(characters.getData()));
                        nSong_status = false;
                    }
                        break;
                    case XMLStreamConstants.END_ELEMENT:

                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase("song")) {
                            System.out.println("End Element : song");
                            System.out.println();
                            listSong.add(song);
                        }
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return listSong;
    }

    @Override
    public void updateSong(Song song) {
        songRepository.updateSong(song);
    }

}
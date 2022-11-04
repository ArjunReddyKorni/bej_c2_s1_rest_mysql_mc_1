package com.challenge.restapi.service;

import com.challenge.restapi.domain.Track;
import com.challenge.restapi.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrackServiceImpl implements TrackService{

    TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public List<Track> getByTrackId(int trackId) {
        return trackRepository.findByTrackId(trackId);
    }

    @Override
    public List<Track> getByTrackArtist(String trackArtist) {
        return trackRepository.findByTrackArtist(trackArtist);
    }


      @Override
    public Track updateTrack(Track track, int trackId) {
        Optional<Track> opTrack = trackRepository.findById(trackId);


        if(opTrack.isEmpty()){
            return null;
        }
        Track exsistingTrack = opTrack.get();

        if(track.getTrackArtist()!=null){
            exsistingTrack.setTrackArtist(track.getTrackArtist());
        }
        if(track.getTrackName()!=null){
            exsistingTrack.setTrackName(track.getTrackName());
        }
        if(track.getTrackRating()!=null){
            exsistingTrack.setTrackRating(track.getTrackRating());
        }
        return trackRepository.save(exsistingTrack);
    }

    @Override
    public boolean deleteTrack(int trackId) {
         trackRepository.deleteById(trackId);
        return true;
    }
}

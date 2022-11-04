package com.challenge.restapi.service;

import com.challenge.restapi.domain.Track;

import java.util.List;

public interface TrackService {

    Track saveTrack(Track track);
    List<Track> getAllTracks();
    List<Track> getByTrackId(int trackId);
    List<Track> getByTrackArtist(String trackArtist);
    Track updateTrack(Track track,int trackId);
    boolean deleteTrack(int trackId);

}

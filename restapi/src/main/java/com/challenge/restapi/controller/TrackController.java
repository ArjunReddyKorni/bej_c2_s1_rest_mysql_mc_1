package com.challenge.restapi.controller;

import com.challenge.restapi.domain.Track;
import com.challenge.restapi.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TrackData/v1/")
public class TrackController {

    TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackService.saveTrack(track),HttpStatus.CREATED);
    }


    @GetMapping("/tracks")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @GetMapping("/track/{trackId}")
    public ResponseEntity<?> getByTrackId(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.getByTrackId(trackId),HttpStatus.OK);
    }

    @GetMapping("/trackA/{trackArtist}")
    public ResponseEntity<?> getByTrackArtist(@PathVariable String trackArtist){
        return new ResponseEntity<>(trackService.getByTrackArtist(trackArtist),HttpStatus.OK);
    }

    @DeleteMapping("/track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.deleteTrack(trackId),HttpStatus.OK);
    }

    @PutMapping("/track/{trackId}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track,@PathVariable int trackId){
        return new ResponseEntity<>(trackService.updateTrack(track,trackId),HttpStatus.OK);
    }


}

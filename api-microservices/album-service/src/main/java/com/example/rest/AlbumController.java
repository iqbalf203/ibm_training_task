package com.example.rest;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.AlbumNotFoundException;
import com.example.model.ResponseAlbumModel;
import com.example.model.AlbumEntity;
import com.example.service.AlbumService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/albums")
public class AlbumController {

	private final AlbumService albumService;
	
	private Environment environment;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("service is runing on port: "+environment.getProperty("local.server.port"));
	}

	@PostMapping
	public ResponseEntity<AlbumEntity> createAlbum(@RequestBody AlbumEntity album) {
		return ResponseEntity.status(HttpStatus.CREATED).body(albumService.createAlbum(album));
	}

	@GetMapping
	public ResponseEntity<List<AlbumEntity>> getAlbums() {
		return ResponseEntity.ok(albumService.listAlbums());
	}

	@GetMapping("/{albumId}")
	public ResponseEntity<?> findAlbumById(@PathVariable("albumId") String albumId) throws AlbumNotFoundException {
		AlbumEntity album = albumService.getAlbumById(albumId);
		

		if (album == null) {
			throw new AlbumNotFoundException("album with " + albumId + " not found");
		} else {
			ResponseAlbumModel tempAlbum = new ResponseAlbumModel(album.getAlbumId(), album.getName(), album.getUserId(), album.getDescription());
			return ResponseEntity.status(HttpStatus.OK).body(tempAlbum);
		}
	}
	@PutMapping("/{albumId}")
	public ResponseEntity<?> updateAlbum(@PathVariable("albumId") String albumId,@RequestBody ResponseAlbumModel album) {
		AlbumEntity tempAlbum = albumService.getAlbumById(albumId);
		try {
			tempAlbum.setName(album.getName());
			tempAlbum.setDescription(album.getDescription());
			albumService.updateAlbum(tempAlbum);
			}
			catch(Exception e){
				return ResponseEntity.status(HttpStatus.OK).body("No Album Id with #" +albumId+ " Found");
			}
		album.setAlbumId(tempAlbum.getAlbumId());
		album.setUserId(tempAlbum.getUserId());
		return ResponseEntity.status(HttpStatus.OK).body(album);
	}
	
	@DeleteMapping("/{albumId}")
	public ResponseEntity<?> deleteAlbum(@PathVariable("albumId") String albumId) {
		AlbumEntity tempAlbum = albumService.getAlbumById(albumId);
		try {
		albumService.deleteAlbum(tempAlbum);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.OK).body("Album Id:#" +albumId+ " Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Album Id:#" +albumId+ " Removed");
}
}


package com.example.service;

import java.util.List;		
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.model.AlbumEntity;

import com.example.repo.AlbumRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {

	private final AlbumRepository albumRepository;

	@Override
	public AlbumEntity createAlbum(AlbumEntity album) {
		// TODO Auto-generated method stub
		album.setAlbumId(UUID.randomUUID().toString());
		album.setUserId(UUID.randomUUID().toString());
		return albumRepository.createAlbum(album);
	}

	@Override
	public List<AlbumEntity> listAlbums() {
		// TODO Auto-generated method stub
		return albumRepository.listAlbums();
	}

	@Override
	public AlbumEntity getAlbumById(String albumId) {
		// TODO Auto-generated method stub
		AlbumEntity album = albumRepository.getAlbumById(Long.parseLong(albumId));
		return album;
	
	}

	@Override
	public AlbumEntity updateAlbum(AlbumEntity album) {
		albumRepository.updateAlbum(album);
		return null;
	}

	@Override
	public void deleteAlbum(AlbumEntity album) {
		albumRepository.deleteAlbum(album);
		
	}

}

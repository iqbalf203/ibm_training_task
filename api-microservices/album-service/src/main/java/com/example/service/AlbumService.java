package com.example.service;

import java.util.List;			

import com.example.model.AlbumEntity;

public interface AlbumService {
	
	AlbumEntity createAlbum(AlbumEntity album);

	List<AlbumEntity> listAlbums();

	AlbumEntity getAlbumById(String albumId);
	
	AlbumEntity updateAlbum(AlbumEntity album);
	
	void deleteAlbum(AlbumEntity album);
	
}

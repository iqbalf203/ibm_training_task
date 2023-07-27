package com.example.repo;		


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.AlbumEntity;

@Repository
@EnableTransactionManagement
public class AlbumRepository {
	
	private final EntityManager entityManager;

	public AlbumRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	@Transactional
	public AlbumEntity createAlbum(AlbumEntity album) {
		entityManager.persist(album);
		return album;
	}
	@Transactional
	public List<AlbumEntity> listAlbums(){
		TypedQuery<AlbumEntity> query=entityManager.createQuery("FROM AlbumEntity A",AlbumEntity.class);
		return query.getResultList();
	}
	@Transactional
	public AlbumEntity getAlbumById(long albumId) {
		
		return entityManager.find(AlbumEntity.class, albumId);
	}
	
	@Transactional
	public AlbumEntity updateAlbum(AlbumEntity album) {
		// TODO Auto-generated method stub
		return entityManager.merge(album);
	}

	@Transactional
	public void deleteAlbum(AlbumEntity album) {
		album = entityManager.merge(album);
		entityManager.remove(album);
		
	}

}



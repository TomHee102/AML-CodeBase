package com.aml.database.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aml.database.DataTransferObject.MediaDto;
import com.aml.database.Entity.Branch;
import com.aml.database.Entity.Media;
import com.aml.database.Exception.ResourceNotFoundException;
import com.aml.database.Mapper.MediaMapper;
import com.aml.database.Repository.BranchRepo;
import com.aml.database.Repository.MediaRepo;
import com.aml.database.Service.MediaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MediaServiceImpl implements MediaService {

        private final EntityManager em;

        private MediaRepo mediaRepo;
        private BranchRepo branchRepo;
        @Override
        public List<MediaDto> getAllBySimpleQuery(
                        String title,
                        String author) {
                CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
                CriteriaQuery<Media> criteriaQuery = criteriaBuilder.createQuery(Media.class);

                Root<Media> root = criteriaQuery.from(Media.class);
                Predicate titlePredicate = criteriaBuilder
                                .like(root.get("title"), "%" + title + "%");
                Predicate authorPredicate = criteriaBuilder
                                .like(root.get("author"), "%" + author + "%");

                Predicate orPredicate = criteriaBuilder.or(
                                titlePredicate,
                                authorPredicate);
                criteriaQuery.where(orPredicate);

                TypedQuery<Media> query = em.createQuery(criteriaQuery);
                return query.getResultList().stream().map((media) -> MediaMapper.mapToMediaDto(media))
                                .collect(Collectors.toList());
        }

        @Override
        public MediaDto createMedia(MediaDto mediaDto) {
                Branch branch = branchRepo.findById(mediaDto.getBranchId()).orElseThrow(
                                () -> new ResourceNotFoundException(
                                                "Branch not found with id : " + mediaDto.getBranchId()));
                Media media = MediaMapper.mapToMedia(mediaDto, branch);
                Media savedMedia = mediaRepo.save(media);
                return MediaMapper.mapToMediaDto(savedMedia);
        }

        @Override
        public MediaDto getMediaById(Integer mediaId) {
                Media media = mediaRepo.findById(mediaId)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "Media not found with id : " + mediaId));

                return MediaMapper.mapToMediaDto(media);
        }

        @Override
        public List<MediaDto> getAllMedia() {
                List<Media> allMedia = mediaRepo.findAll();
                return allMedia.stream().map((media) -> MediaMapper.mapToMediaDto(media)).collect(Collectors.toList());
        }

}
// return media
/*
 * @Override
 * public MediaDto returnMedia(int mediaId, int userId){
 * Media media = mediaRepo.findById(mediaId).orElseThrow(() -> new
 * ResourceNotFoundException("Media not found with id : " + mediaId));
 * media.setQuantity(media.getQuantity()+1);
 * if(media.getQuantity()>0){
 * media.setAvaliable(true);
 * }
 * Media updateMedia=mediaRepo.save(media);
 * return MediaMapper.mapToMediaDto(updateMedia);
 * }
 */

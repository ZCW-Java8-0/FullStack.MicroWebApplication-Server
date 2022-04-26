package com.nyce.tube.web.rest;

import com.nyce.tube.domain.Videos;
import com.nyce.tube.repository.VideosRepository;
import com.nyce.tube.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.nyce.tube.domain.Videos}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class VideosResource {

    private final Logger log = LoggerFactory.getLogger(VideosResource.class);

    private static final String ENTITY_NAME = "videos";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VideosRepository videosRepository;

    public VideosResource(VideosRepository videosRepository) {
        this.videosRepository = videosRepository;
    }

    /**
     * {@code POST  /videos} : Create a new videos.
     *
     * @param videos the videos to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new videos, or with status {@code 400 (Bad Request)} if the videos has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/videos")
    public ResponseEntity<Videos> createVideos(@Valid @RequestBody Videos videos) throws URISyntaxException {
        log.debug("REST request to save Videos : {}", videos);
        if (videos.getId() != null) {
            throw new BadRequestAlertException("A new videos cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Videos result = videosRepository.save(videos);
        return ResponseEntity
            .created(new URI("/api/videos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /videos/:id} : Updates an existing videos.
     *
     * @param id the id of the videos to save.
     * @param videos the videos to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated videos,
     * or with status {@code 400 (Bad Request)} if the videos is not valid,
     * or with status {@code 500 (Internal Server Error)} if the videos couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/videos/{id}")
    public ResponseEntity<Videos> updateVideos(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody Videos videos
    ) throws URISyntaxException {
        log.debug("REST request to update Videos : {}, {}", id, videos);
        if (videos.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, videos.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!videosRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Videos result = videosRepository.save(videos);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, videos.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /videos/:id} : Partial updates given fields of an existing videos, field will ignore if it is null
     *
     * @param id the id of the videos to save.
     * @param videos the videos to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated videos,
     * or with status {@code 400 (Bad Request)} if the videos is not valid,
     * or with status {@code 404 (Not Found)} if the videos is not found,
     * or with status {@code 500 (Internal Server Error)} if the videos couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/videos/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Videos> partialUpdateVideos(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody Videos videos
    ) throws URISyntaxException {
        log.debug("REST request to partial update Videos partially : {}, {}", id, videos);
        if (videos.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, videos.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!videosRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Videos> result = videosRepository
            .findById(videos.getId())
            .map(existingVideos -> {
                if (videos.getName() != null) {
                    existingVideos.setName(videos.getName());
                }
                if (videos.getDate() != null) {
                    existingVideos.setDate(videos.getDate());
                }
                if (videos.getVideo() != null) {
                    existingVideos.setVideo(videos.getVideo());
                }
                if (videos.getVideoContentType() != null) {
                    existingVideos.setVideoContentType(videos.getVideoContentType());
                }

                return existingVideos;
            })
            .map(videosRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, videos.getId().toString())
        );
    }

    /**
     * {@code GET  /videos} : get all the videos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of videos in body.
     */
    @GetMapping("/videos")
    public List<Videos> getAllVideos() {
        log.debug("REST request to get all Videos");
        return videosRepository.findAll();
    }

    /**
     * {@code GET  /videos/:id} : get the "id" videos.
     *
     * @param id the id of the videos to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the videos, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/videos/{id}")
    public ResponseEntity<Videos> getVideos(@PathVariable Long id) {
        log.debug("REST request to get Videos : {}", id);
        Optional<Videos> videos = videosRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(videos);
    }

    /**
     * {@code DELETE  /videos/:id} : delete the "id" videos.
     *
     * @param id the id of the videos to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/videos/{id}")
    public ResponseEntity<Void> deleteVideos(@PathVariable Long id) {
        log.debug("REST request to delete Videos : {}", id);
        videosRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}

import React, { useState, useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { openFile, byteSize, Translate, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IVideos } from 'app/shared/model/videos.model';
import { getEntities } from './videos.reducer';

// import React, { Component } from 'react';
// import VideoPlayer from 'react-video-js-player';

export const Videos = (props: RouteComponentProps<{ url: string }>) => {
  const dispatch = useAppDispatch();

  const videosList = useAppSelector(state => state.videos.entities);
  const loading = useAppSelector(state => state.videos.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  const { match } = props;

// class VideoApp extends Component {
//     player = {}
//     state = {
//         video: {
//             src: "/video.mp4",
//             poster: "/1.png"
//         }
//     }
//
//     onPlayerReady(player){
//         this.player = player;
//     }
//
//     render() {
//         return (
//             <div>
//                 <VideoPlayer
//                     controls={true}
//                     src={this.state.video.src}
//                     poster={this.state.video.poster}
//                     width="720"
//                     height="420"
//                     onReady={this.onPlayerReady.bind(this)}
//                 />
//             </div>
//         );
//     }
// }
// export default VideoApp;

  return (
    <div>
      <h2 id="videos-heading" data-cy="VideosHeading">
        Videos
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} /> Refresh List
          </Button>
          <Link to="/videos/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create new Videos
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {videosList && videosList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date</th>
                <th>Video</th>
                <th />
              </tr>
            </thead>
            <tbody>
              {videosList.map((videos, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/videos/${videos.id}`} color="link" size="sm">
                      {videos.id}
                    </Button>
                  </td>
                  <td>{videos.name}</td>
                  <td>{videos.date ? <TextFormat type="date" value={videos.date} format={APP_DATE_FORMAT} /> : null}</td>
                  <td>
                    {videos.video ? (
                      <div>
                        {videos.videoContentType ? <a onClick={openFile(videos.videoContentType, videos.video)}>Open &nbsp;</a> : null}
                        <span>
                          {videos.videoContentType}, {byteSize(videos.video)}
                        </span>
                      </div>
                    ) : null}
                  </td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/videos/${videos.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                      </Button>
                      <Button tag={Link} to={`/videos/${videos.id}/edit`} color="primary" size="sm" data-cy="entityEditButton">
                        <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                      </Button>
                      <Button tag={Link} to={`/videos/${videos.id}/delete`} color="danger" size="sm" data-cy="entityDeleteButton">
                        <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && <div className="alert alert-warning">No Videos found</div>
        )}
      </div>
    </div>
  );
};

export default Videos;

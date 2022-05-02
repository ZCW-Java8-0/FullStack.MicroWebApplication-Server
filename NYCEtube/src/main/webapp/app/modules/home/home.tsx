import './home.scss';

import React, { Component } from 'react';
import ReactPlayer from 'react';
import { Link } from 'react-router-dom';

import { Row, Col, Alert } from 'reactstrap';

import { useAppSelector } from 'app/config/store';
import VideoApp from '../home/videoapp';
import { VideoPlayer } from 'react-video-js-player';
import VideoJS from '../home/videojs';

export const Home = () => {
  const account = useAppSelector(state => state.authentication.account);


  return (
    <Row>
      <Col md="3" className="pad">
        <span className="hipster rounded" />
      </Col>
      <div>
        <VideoJS/>
        <VideoApp/>
      </div>
      <Col md="9">
        <p></p>
        <p></p>
        <h2>Welcome, NYCEtube!</h2>
        <p className="lead">NYCE to see you ^_^</p>
        {account?.login ? (
          <div>
            <Alert color="success">You are logged in as user {account.login}.</Alert>
          </div>
        ) : (
          <div>
            <Alert color="warning">
              If you want to
              <span>&nbsp;</span>
              <Link to="/login" className="alert-link">
                {' '}
                sign in
              </Link>
              , you can try the default accounts:
              <br />- Administrator (login=&quot;admin&quot; and password=&quot;admin&quot;)
              <br />- User (login=&quot;user&quot; and password=&quot;user&quot;).
            </Alert>

            <Alert color="warning">
              You do not have an account yet?&nbsp;
              <Link to="/account/register" className="alert-link">
                Register a new account
              </Link>
            </Alert>
          </div>
        )}

      </Col>
    </Row>
  );
};

export default Home;

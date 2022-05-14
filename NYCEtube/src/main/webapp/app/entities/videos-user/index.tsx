import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Videos from './videos-user';
import VideosDetail from './videos-user-detail';
import VideosUpdate from './videos-user-update';
import VideosDeleteDialog from './videos-user-delete-dialog';



const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={VideosUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={VideosUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={VideosDetail} />
      <ErrorBoundaryRoute path={match.url} component={Videos} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={VideosDeleteDialog} />
  </>
);

export default Routes;

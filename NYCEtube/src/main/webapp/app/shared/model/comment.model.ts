import dayjs from 'dayjs';
import { IUser } from 'app/shared/model/user.model';
import { IVideos } from 'app/shared/model/videos.model';

export interface IComment {
  id?: number;
  date?: string | null;
  text?: string | null;
  user?: IUser | null;
  videos?: IVideos | null;
}

export const defaultValue: Readonly<IComment> = {};

import dayjs from 'dayjs';
import { IComment } from 'app/shared/model/comment.model';

export interface IVideos {
  id?: number;
  name?: string;
  date?: string | null;
  videoContentType?: string | null;
  video?: string | null;
  comments?: IComment[] | null;
}

export const defaultValue: Readonly<IVideos> = {};

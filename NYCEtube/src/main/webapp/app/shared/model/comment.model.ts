import dayjs from 'dayjs';
import { IVideos } from 'app/shared/model/videos.model';

export interface IComment {
  id?: number;
  date?: string | null;
  text?: string | null;
  videos?: IVideos | null;
}

export const defaultValue: Readonly<IComment> = {};

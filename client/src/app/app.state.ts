import { User } from './models/user.model';
import { Category } from './models/category.model';

export interface AppState {
  readonly user: User;
  readonly categories: Category[];
}
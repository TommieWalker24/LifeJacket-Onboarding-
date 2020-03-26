import { Action } from '@ngrx/store';
import { Category } from '../models/category.model';

export const SET_CATEGORY = '[CATEGORY] Set';

export class SetCurrentCategory implements Action {
  readonly type = SET_CATEGORY;
  constructor(public payload: Category) { }
}

export type Actions = SetCurrentCategory;
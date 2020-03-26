import { Action } from '@ngrx/store';
import { Category } from '../models/category.model';

export const ADD_CATEGORY = '[CATEGORY] Add';
export const REMOVE_CATEGORY = '[CATEGORY] Remove';
export const SET_CATEGORIES = '[CATEGORY] Set';

export class AddCategory implements Action {
  readonly type = ADD_CATEGORY;
  constructor(public payload: Category) { }
}

export class SetCategories implements Action {
  readonly type = SET_CATEGORIES;
  constructor(public payload: Category[]) { }
}

export class RemoveCategory implements Action {
  readonly type = REMOVE_CATEGORY;
  constructor(public payload: number) { }
}

export type Actions = AddCategory | RemoveCategory | SetCategories;
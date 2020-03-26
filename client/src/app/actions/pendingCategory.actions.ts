import { Action } from '@ngrx/store';

export const SET_CATEGORY = '[CATEGORY] Set';

export class SetPendingCategory implements Action {
  readonly type = SET_CATEGORY;
  constructor(public payload) { }
}

export type Actions = SetPendingCategory;
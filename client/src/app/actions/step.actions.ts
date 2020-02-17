import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';
import { Step } from '../models/steps.models';

export const ADD_STEP = '[STEP] Add';
export const REMOVE_STEP = '[STEP] Remove';

export class AddStep implements Action {
  readonly type = ADD_STEP;
  constructor(public payload: Step) { }
}

export class RemoveStep implements Action {
  readonly type = REMOVE_STEP;
  constructor(public payload: number) { }
}

export type Actions = AddStep | RemoveStep;
import { Action } from '@ngrx/store';
import { Step } from './../models/steps.models';
import * as StepActions from '../actions/step.actions'

const initialState = [
  {
    name: "Step1",
    complete: true,
    pending: false,
    description: "steeeep 11"
  },
  {
    name: "Step2",
    complete: true,
    pending: false,
    description: "steeeep 22"
  },
  {
    name: "Step3",
    complete: false,
    pending: true,
    description: "steeeep 33"
  },
  {
    name: "Step4",
    complete: false,
    pending: false,
    description: "steeeep 44"
  },
  {
    name: "Step5",
    complete: false,
    pending: false,
    description: "steeeep 55"
  }]

export function reducer(state: Step[] = initialState, action: StepActions.Actions) {
  switch (action.type) {
    case StepActions.ADD_STEP:
      return [...state, action.payload];
    case StepActions.REMOVE_STEP:
      return [...state, action.payload];
    default:
      return state;
  }
}
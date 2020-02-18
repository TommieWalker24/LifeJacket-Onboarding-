import { Step } from './../models/steps.models';
import * as StepActions from '../actions/step.actions'

const initialState = [
  {
    title: "Step1",
    complete: true,
    pending: false,
    content: "steeeep 11"
  },
  {
    title: "Step2",
    complete: true,
    pending: false,
    content: "steeeep 22"
  },
  {
    title: "Step3",
    complete: false,
    pending: true,
    content: "steeeep 33"
  },
  {
    title: "Step4",
    complete: false,
    pending: false,
    content: "steeeep 44"
  },
  {
    title: "Step5",
    complete: false,
    pending: false,
    content: "steeeep 55"
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
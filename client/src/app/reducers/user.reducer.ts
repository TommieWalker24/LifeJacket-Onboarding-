import { Action, INITIAL_REDUCERS } from '@ngrx/store'
import { User } from './../models/user.model'
import * as UserActions from './../actions/user.actions'

const intialState = [{ name: "brayden", url: "google.com" }]

export function reducer(state: User[] = intialState, action: UserActions.Actions) {

  switch (action.type) {
    case UserActions.ADD_USER:
      return [...state, action.payload];
    case UserActions.REMOVE_USER:
      return [...state, action.payload];
    default:
      return state;
  }
}
import { User } from './../models/user.model'
import * as UserActions from './../actions/user.actions'

export function reducer(state: User[] = [], action: UserActions.Actions) {
  switch (action.type) {
    case UserActions.ADD_USER:
      return [...state, action.payload];
    case UserActions.REMOVE_USER:
      return [...state, action.payload];
    default:
      return state;
  }
}
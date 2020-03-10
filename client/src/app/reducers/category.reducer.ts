import * as CategoryActions from '../actions/category.actions';
import { Category } from '../models/category.model';

export function categoryReducer(state: Category[], action: CategoryActions.Actions) {
  switch (action.type) {
    case CategoryActions.ADD_CATEGORY:
      return [...state, action.payload];
    case CategoryActions.SET_CATEGORIES:
      return [action.payload];
    case CategoryActions.REMOVE_CATEGORY:
      return [...state, action.payload];
    default:
      return state;
  }
}
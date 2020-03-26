import * as CurrentCategoryActions from '../actions/currentCategory.actions';
import { Category } from '../models/category.model';

export function currentCategoryReducer(state: Category, action: CurrentCategoryActions.Actions) {
  switch (action.type) {
    case CurrentCategoryActions.SET_CATEGORY:
      return action.payload;
    default:
      return state;
  }
}
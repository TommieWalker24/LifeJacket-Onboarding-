import * as CategoryActions from '../actions/category.actions';
import { Category } from '../models/category.model';

export function categoryReducer(state: Category[], action: CategoryActions.Actions) {
  switch (action.type) {
    case CategoryActions.ADD_CATEGORY:
      return [...state, action.payload];
    case CategoryActions.SET_CATEGORIES:
<<<<<<< HEAD
      return action.payload;
=======
      return [action.payload];
>>>>>>> Finished a lot of the requests to the server and replaced the assets from the nav with the document view
    case CategoryActions.REMOVE_CATEGORY:
      return [...state, action.payload];
    default:
      return state;
  }
}

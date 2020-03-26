import * as PendingCategoryActions from '../actions/pendingCategory.actions';

export function pendingCategoryReducer(state: {}, action: PendingCategoryActions.Actions) {
  switch (action.type) {
    case PendingCategoryActions.SET_CATEGORY:
      return action.payload;
    default:
      return state;
  }
}

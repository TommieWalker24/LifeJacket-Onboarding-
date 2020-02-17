import { User } from './models/user.model';
import { Step } from './models/steps.models';

export interface AppState {
  readonly user: User[];
  readonly steps: Step[];
}
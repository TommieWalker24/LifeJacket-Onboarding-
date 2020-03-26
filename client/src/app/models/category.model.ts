import { Step } from './step.model';

export class Category {
  category: string;
  categoryId: number;
  seqNum: number;
  steps: Step[];
  role: string;
}
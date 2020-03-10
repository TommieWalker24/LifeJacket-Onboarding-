import * as CategoryActions from '../actions/category.actions';
import { Category } from '../models/category.model';

const initialState: Category[] = [
  {
    name: 'category1',
    steps: [
      {
        title: 'category 1 step 1',
        content: '<p><em>This is some text that will be html and it\'s gonna have a video.</em></p><p><em>sdfghfgd</em></p><p><em>dfghdfgj</em></p><p><em>fghjk</em></p><p><em>hg</em><strong><em>kghjkl</em></strong></p><p><strong><em>ghjk</em></strong></p><p><strong><em>f</em></strong></p><p><strong>srg</strong></p><p><br></p><p><s>rt</s></p><p><br></p><p><br></p>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 2',
        content: '<p>malicious content</p><script>console.log(\'attack!\')</script>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 3',
        content: 'category 1 step 3 content',
        pending: false,
        complete: true
      }
    ]
  },
  {
    name: 'category2',
    steps: [
      {
        title: 'category 2 step 1',
        content: 'category 2 step 1 content',
        pending: false,
        complete: true
      },
      {
        title: 'category 2 step 2',
        content: 'category 2 step 2 content',
        pending: true,
        complete: false
      },
      {
        title: 'category 2 step 3',
        content: 'category 2 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
  {
    name: 'category3',
    steps: [
      {
        title: 'category 3 step 1',
        content: 'category 3 step 1 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 2',
        content: 'category 3 step 2 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 3',
        content: 'category 3 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
  {
    name: 'category 1',
    steps: [
      {
        title: 'category 1 step 1',
        content: '<p><em>This is some text that will be html and it\'s gonna have a video.</em></p><p><em>sdfghfgd</em></p><p><em>dfghdfgj</em></p><p><em>fghjk</em></p><p><em>hg</em><strong><em>kghjkl</em></strong></p><p><strong><em>ghjk</em></strong></p><p><strong><em>f</em></strong></p><p><strong>srg</strong></p><p><br></p><p><s>rt</s></p><p><br></p><p><br></p>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 2',
        content: '<p>malicious content</p><script>console.log(\'attack!\')</script>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 3',
        content: 'category 1 step 3 content',
        pending: false,
        complete: true
      }
    ]
  },
  {
    name: 'category 2',
    steps: [
      {
        title: 'category 2 step 1',
        content: 'category 2 step 1 content',
        pending: false,
        complete: true
      },
      {
        title: 'category 2 step 2',
        content: 'category 2 step 2 content',
        pending: true,
        complete: false
      },
      {
        title: 'category 2 step 3',
        content: 'category 2 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
  {
    name: 'category 3',
    steps: [
      {
        title: 'category 3 step 1',
        content: 'category 3 step 1 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 2',
        content: 'category 3 step 2 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 3',
        content: 'category 3 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
  {
    name: 'category 1',
    steps: [
      {
        title: 'category 1 step 1',
        content: '<p><em>This is some text that will be html and it\'s gonna have a video.</em></p><p><em>sdfghfgd</em></p><p><em>dfghdfgj</em></p><p><em>fghjk</em></p><p><em>hg</em><strong><em>kghjkl</em></strong></p><p><strong><em>ghjk</em></strong></p><p><strong><em>f</em></strong></p><p><strong>srg</strong></p><p><br></p><p><s>rt</s></p><p><br></p><p><br></p>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 2',
        content: '<p>malicious content</p><script>console.log(\'attack!\')</script>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 3',
        content: 'category 1 step 3 content',
        pending: false,
        complete: true
      }
    ]
  },
  {
    name: 'category 2',
    steps: [
      {
        title: 'category 2 step 1',
        content: 'category 2 step 1 content',
        pending: false,
        complete: true
      },
      {
        title: 'category 2 step 2',
        content: 'category 2 step 2 content',
        pending: true,
        complete: false
      },
      {
        title: 'category 2 step 3',
        content: 'category 2 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
  {
    name: 'category 3',
    steps: [
      {
        title: 'category 3 step 1',
        content: 'category 3 step 1 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 2',
        content: 'category 3 step 2 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 3',
        content: 'category 3 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
  {
    name: 'category 1',
    steps: [
      {
        title: 'category 1 step 1',
        content: '<p><em>This is some text that will be html and it\'s gonna have a video.</em></p><p><em>sdfghfgd</em></p><p><em>dfghdfgj</em></p><p><em>fghjk</em></p><p><em>hg</em><strong><em>kghjkl</em></strong></p><p><strong><em>ghjk</em></strong></p><p><strong><em>f</em></strong></p><p><strong>srg</strong></p><p><br></p><p><s>rt</s></p><p><br></p><p><br></p>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 2',
        content: '<p>malicious content</p><script>console.log(\'attack!\')</script>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 3',
        content: 'category 1 step 3 content',
        pending: false,
        complete: true
      }
    ]
  },
  {
    name: 'category 2',
    steps: [
      {
        title: 'category 2 step 1',
        content: 'category 2 step 1 content',
        pending: false,
        complete: true
      },
      {
        title: 'category 2 step 2',
        content: 'category 2 step 2 content',
        pending: true,
        complete: false
      },
      {
        title: 'category 2 step 3',
        content: 'category 2 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
  {
    name: 'category 3',
    steps: [
      {
        title: 'category 3 step 1',
        content: 'category 3 step 1 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 2',
        content: 'category 3 step 2 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 3',
        content: 'category 3 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
  {
    name: 'category 1',
    steps: [
      {
        title: 'category 1 step 1',
        content: '<p><em>This is some text that will be html and it\'s gonna have a video.</em></p><p><em>sdfghfgd</em></p><p><em>dfghdfgj</em></p><p><em>fghjk</em></p><p><em>hg</em><strong><em>kghjkl</em></strong></p><p><strong><em>ghjk</em></strong></p><p><strong><em>f</em></strong></p><p><strong>srg</strong></p><p><br></p><p><s>rt</s></p><p><br></p><p><br></p>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 2',
        content: '<p>malicious content</p><script>console.log(\'attack!\')</script>',
        pending: false,
        complete: true
      },
      {
        title: 'category 1 step 3',
        content: 'category 1 step 3 content',
        pending: false,
        complete: true
      }
    ]
  },
  {
    name: 'category 2',
    steps: [
      {
        title: 'category 2 step 1',
        content: 'category 2 step 1 content',
        pending: false,
        complete: true
      },
      {
        title: 'category 2 step 2',
        content: 'category 2 step 2 content',
        pending: true,
        complete: false
      },
      {
        title: 'category 2 step 3',
        content: 'category 2 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
  {
    name: 'category 3',
    steps: [
      {
        title: 'category 3 step 1',
        content: 'category 3 step 1 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 2',
        content: 'category 3 step 2 content',
        pending: false,
        complete: false
      },
      {
        title: 'category 3 step 3',
        content: 'category 3 step 3 content',
        pending: false,
        complete: false
      }
    ]
  },
];

export function categoryReducer(state: Category[] = initialState, action: CategoryActions.Actions) {
  switch (action.type) {
    case CategoryActions.ADD_CATEGORY:
      return [...state, action.payload];
    case CategoryActions.REMOVE_CATEGORY:
      return [...state, action.payload];
    default:
      return state;
  }
}
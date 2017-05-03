import { DisplayDataPage } from './app.po';

describe('display-data App', function() {
  let page: DisplayDataPage;

  beforeEach(() => {
    page = new DisplayDataPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

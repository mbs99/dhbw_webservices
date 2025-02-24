import {bootstrapApplication, createApplication} from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import {createCustomElement} from '@angular/elements';
import {HelloComponent} from './app/hello/hello.component';

(async () => {

  const app = await createApplication({
    providers: [
      /* your global providers here */
    ],
  });

  const helloElement = createCustomElement(HelloComponent, {
    injector: app.injector,
  });

  customElements.define('my-hello', helloElement);

})();

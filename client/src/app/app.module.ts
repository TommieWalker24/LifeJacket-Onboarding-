import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SocialLoginModule, AuthServiceConfig } from 'angularx-social-login';
import { GoogleLoginProvider } from 'angularx-social-login';
import { StoreModule } from '@ngrx/store';
import { QuillModule } from 'ngx-quill';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { HeadNavComponent } from './head-nav/head-nav.component';
import { LocationComponent } from './location/location.component';
import { UserStepComponent } from './user-step/user-step.component';

import { userReducer } from './reducers/user.reducer';
import { categoryReducer } from './reducers/category.reducer';
import { pendingCategoryReducer } from './reducers/pendingCategory.reducer';
import { currentCategoryReducer } from './reducers/currentCategory.reducer';


let config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider('407098193167-2eqdkj4feadcksra7d2bmfshfa61156o.apps.googleusercontent.com')
  }
]);
export function provideConfig() {
  return config;
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserComponent,
    AdminComponent,
    HeadNavComponent,
    LocationComponent,
    UserStepComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    SocialLoginModule.initialize(config),
    StoreModule.forRoot({
      user: userReducer,
      categories: categoryReducer,
      pendingCategory: pendingCategoryReducer,
      currentCategoryReducer: currentCategoryReducer
    }),
    QuillModule.forRoot(),
    ReactiveFormsModule,
<<<<<<< HEAD
=======
    NgbModule
>>>>>>> WIP on admin page. saving for backup. Added the tabs for the admin nav and started to flush out the functionality
  ],
  providers: [
    {
      provide: AuthServiceConfig,
      useFactory: provideConfig,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

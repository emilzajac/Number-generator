import { BrowserModule } from '@angular/platform-browser';
import { NgModule }      from '@angular/core';

import { AppComponent }                     from './app.component';
import { DbNumbersComponent }               from './db-numbers/db-numbers.component';
import { HttpClientModule }                 from '@angular/common/http';
import { AppRoutingModule }                 from '../app-routing.module';
import { NavigationComponent }              from './navigation/navigation.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IntegersGeneratorComponent }       from './random-generator/integers-generator/integers-generator.component';
import { UuidsGeneratorComponent } from './random-generator/uuids-generator/uuids-generator.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    DbNumbersComponent,
    IntegersGeneratorComponent,
    UuidsGeneratorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

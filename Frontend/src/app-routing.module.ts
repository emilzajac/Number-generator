import { NgModule }                   from '@angular/core';
import { RouterModule, Routes }       from '@angular/router';
import { environment }                from './environments/environment';
import { DbNumbersComponent }         from './app/db-numbers/db-numbers.component';
import { IntegersGeneratorComponent } from './app/random-generator/integers-generator/integers-generator.component';
import { UuidsGeneratorComponent }    from './app/random-generator/uuids-generator/uuids-generator.component';

const routes: Routes = [

  {path: '', component: IntegersGeneratorComponent},
  {path: 'random-integers-generator', component: IntegersGeneratorComponent},
  {path: 'random-uuids-generator', component: UuidsGeneratorComponent},
  {path: 'numbers-from-database/list', component: DbNumbersComponent},

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      useHash: !environment.production
    }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {
}

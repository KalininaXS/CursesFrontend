import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ServiceComponent} from "./service/service/service.component";
import {ChartComponent} from "./chart/chart/chart.component";
import {TableComponent} from "./table/table/table.component";
import {HomeComponent} from "./home/home/home.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'table', component: TableComponent},
  {path: 'chart', component: ChartComponent},
  {path: 'service', component: ServiceComponent},
  {path: '', pathMatch: "full", redirectTo: 'home'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

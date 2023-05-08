import { Component } from '@angular/core';
import {ServiceService} from "../../service.service";


export interface Measurement{
  time: number;
  kz_ia: number;
}
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})

export class TableComponent {
  constructor(private service: ServiceService) {}

  Measurement1 = this.service.downloadA();
  Measurement2 = this.service.downloadB();
  Measurement3 = this.service.downloadC();

  displayedColumns1: string[] = ['time','kz_ia'];
  dataSource1 = this.Measurement1;

  displayedColumns2: string[] = ['time','kz_ib'];
  dataSource2 = this.Measurement2;

  displayedColumns3: string[] = ['time','kz_ic'];
  dataSource3 = this.Measurement3;

}

import { Component } from '@angular/core';

export interface Measurement{
  time: number;
  kz_ia: number;
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend_curses';
}

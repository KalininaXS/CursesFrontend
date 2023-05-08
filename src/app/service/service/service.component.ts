import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.scss']
})
export class ServiceComponent {
  fileName = '';

  constructor(private http: HttpClient) {}

  onFileSelected(event: Event) {
    const target = event.target as HTMLInputElement;
    const files: File = target.files![0];


    if (files) {

      this.fileName = files.name;

      const file = new FormData();

      file.append("file", files);

      const upload$ = this.http.post("http://localhost:8080/data", file);

      upload$.subscribe();
    }
  }
}

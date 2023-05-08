import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent} from "@angular/common/http";
import {Observable} from "rxjs";
import {Measurement} from "./table/table/table.component";

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private server = 'http://localhost:8080';
  constructor(private http: HttpClient) {  }


  upload(formData: FormData): Observable<HttpEvent<string[]>>{
    return this.http.post<string[]>(`${this.server}/data`, formData, {
      reportProgress: true,
      observe: 'events'
    });
  }
  download(): Observable<Measurement[]>{
    return this.http.get<Measurement[]>(`${this.server}/kz`);
  }

  downloadA() {
    return this.http.get<number[]>(`${this.server}/kzA`);
  }
  downloadB(): Observable<number[]>{
    return this.http.get<number[]>(`${this.server}/kzB`);
  }

  downloadC(): Observable<number[]>{
    return this.http.get<number[]>(`${this.server}/kzC`);
  }

  downloadKZA(){
    return this.http.get<number[]>(`${this.server}/kzia`);
  }
  downloadTimeKZA(){
    return this.http.get<number[]>(`${this.server}/timekzia`);
  }
  downloadKZB(){
    return this.http.get<number[]>(`${this.server}/kzib`);
  }
  downloadTimeKZB(){
    return this.http.get<number[]>(`${this.server}/timekzib`);
  }
  downloadKZC(){
    return this.http.get<number[]>(`${this.server}/kzic`);
  }
  downloadTimeKZC(){
    return this.http.get<number[]>(`${this.server}/timekzic`);
  }



}

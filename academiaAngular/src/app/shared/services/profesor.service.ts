import { Injectable } from '@angular/core';
import { MapType } from '@angular/compiler';
import { Alumno } from '../entities/alumno';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Profesor } from '../entities/profesor';

@Injectable({
  providedIn: 'root'
})
export class ProfesorService {
  // aqui va la direccion del servidor al que te conectas
  url = 'http://localhost:8080/academiamvc/services/profesores/';
  // url = 'http://192.168.1.19:8080/academiamvc/services/profesores/';
  constructor(private http: HttpClient) {

  }
  findAll(): Observable<Profesor[]> {
    return this.http.get<Profesor[]>(this.url);
  }
  findById(id: number): Observable<Profesor> {
    return this.http.get<Profesor>(this.url + id);
  }
  create(a: Profesor): Observable<Profesor> {
    return this.http.post<Profesor>(this.url, a);
  }
  delete(id: number): Observable<any> {
    return this.http.delete<Profesor>(this.url + id);
  }
  modificar(a: Profesor): Observable<any> {
    return this.http.put(this.url + a.id, a);
  }
}

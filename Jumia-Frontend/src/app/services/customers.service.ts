import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Customer } from '../model/customer.model'

@Injectable({
  providedIn: 'root'
})
export class CustomersService {

  constructor(private http: HttpClient) {
  }

  customersList(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${environment.baseUrl}/customers`);
  }
}

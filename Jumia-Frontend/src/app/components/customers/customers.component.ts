
import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Subject } from 'rxjs';
import { Customer } from '../../model/customer.model';
import { CustomersService } from '../../services/customers.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DataTableDirective } from 'angular-datatables';
import { DataTablesModule } from 'angular-datatables';

@Component({
  selector: 'app-customers-component',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit , OnDestroy{

  customers: Customer[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();


  constructor(private customersService: CustomersService) {
  
  }

  ngOnInit(): void {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      processing: true
    };
    this.getCustomers(true);
  }
  getCustomers(trigger: boolean): void {
    this.customersService.customersList()
      .subscribe(data => {
        this.customers = data;
        if (trigger) {
          this.dtTrigger.next();
        }
      });
  }
  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }

}

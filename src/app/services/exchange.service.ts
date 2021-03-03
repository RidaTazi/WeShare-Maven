import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExchangeService {

  private _data: any;

  constructor() { }

  set data(data: any) {
    this._data = data;
  }

  get data() {
    return this._data;
  }
}

import { Component, OnInit } from '@angular/core';
import {trigger, state, style, transition, animate} from '@angular/animations';
import { AppStateService } from '../core/app-state.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']

})
export class MainComponent implements OnInit {

  constructor() { }

  toggle = false;
 


  ngOnInit() {
 
  }
  toggleSideMenu(event){
  
    this.toggle = !this.toggle;
  }

}

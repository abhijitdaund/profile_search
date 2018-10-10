import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AppStateService } from '../../core/app-state.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Output() toggleSideMenu  = new EventEmitter<boolean>();
  toggle:boolean = false;

  constructor(private router: Router) { }

  ngOnInit() {
 
  }

  toggleSideBar(){
    this.toggle = !this.toggle;
    this.toggleSideMenu.emit(true);
  }

  logout(){
    this.router.navigate(['/logout']);
    }
}

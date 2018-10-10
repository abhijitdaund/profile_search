import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [SearchBarComponent, HeaderComponent, FooterComponent, SideBarComponent],
  exports:[SearchBarComponent, HeaderComponent, FooterComponent, SideBarComponent]
})
export class SharedModule { }

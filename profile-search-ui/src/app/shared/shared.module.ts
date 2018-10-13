import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { RouterModule } from '@angular/router';
import { AlertComponent } from './alert/alert.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [SearchBarComponent,
                 HeaderComponent,
                  FooterComponent,
                   SideBarComponent,
                    AlertComponent],
  exports:[SearchBarComponent, HeaderComponent, FooterComponent, SideBarComponent,AlertComponent]
})
export class SharedModule { }

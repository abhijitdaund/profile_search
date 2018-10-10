
import { RouterModule } from "@angular/router";

const appRoutes = [
 {
        path: 'auth',
        loadChildren: './auth/auth.module#AuthModule',
 },
    {
        path: 'main',
        loadChildren: './main/main.module#MainModule',
      },
    {
        path:'**',
        redirectTo:'auth'
    }
]

export const routing = RouterModule.forRoot(appRoutes);
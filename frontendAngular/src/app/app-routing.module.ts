import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NotFoundComponent} from './modules/general/not-found/not-found.component';

const routes: Routes = [
    {
        path: '',
        loadChildren: () => import('./modules/general/bug-list/bug.module')
            .then(mod => mod.BugModule)
    },
    {
        path: 'bug-statistic',
        loadChildren: () => import('./modules/general/statistics/statistics.module')
            .then(mod => mod.StatisticsModule)
    },
    {
        path: 'bug-list',
        loadChildren: () => import('./modules/general/bug-list/bug.module')
            .then(mod => mod.BugModule)
    },
    {path: '**', component: NotFoundComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true}),],
    exports: [RouterModule],
    declarations: []
})
export class AppRoutingModule {
}

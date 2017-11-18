import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {TouchComponent} from './touch.component';

@NgModule({
	imports: [RouterModule.forChild([
		{path: '', component: TouchComponent}
	])],
	exports: [RouterModule]
})

export class TouchRoutingModule {
}

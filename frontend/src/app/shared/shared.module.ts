import { NgModule }            from '@angular/core';
import { CommonModule }        from '@angular/common';
import { FormsModule }         from '@angular/forms';
import {LevelChartComponent} from "./level-chart/level-chart.component";
import {TextMaskModule} from "angular2-text-mask";
import {ChartsModule} from "ng2-charts";

@NgModule({
	imports: [
		CommonModule,
		FormsModule,
		ChartsModule,
		TextMaskModule,
	],
	declarations: [
		LevelChartComponent
	],
	exports: [
		CommonModule,
		FormsModule,
		ChartsModule,
		TextMaskModule,
		LevelChartComponent
	]
})

export class SharedModule { }

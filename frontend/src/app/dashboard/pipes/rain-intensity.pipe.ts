import {Pipe, PipeTransform} from "@angular/core";

@Pipe({name: 'rainIntensity'})
export class RainIntensityPipe implements PipeTransform {
	transform(value: string): string {
		switch (value) {
			case "LIGHT":
				return "Leve";
			case "MODERATE":
				return "Moderada";
			case "HEAVY":
				return "Forte";
			case "VERY_STRONG":
				return "Muito forte";
		}
	}
}


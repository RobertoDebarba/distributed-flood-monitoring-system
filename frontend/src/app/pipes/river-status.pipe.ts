import {Pipe, PipeTransform} from "@angular/core";

@Pipe({name: 'riverStatus'})
export class RiverStatusPipe implements PipeTransform {
	transform(value: string): string {
		switch (value) {
			case "NORMAL":
				return "Normal";
			case "ATTENTION":
				return "Atenção";
			case "ALERT":
				return "Alerta";
			case "READINESS":
				return "Prontidão";
		}
	}
}

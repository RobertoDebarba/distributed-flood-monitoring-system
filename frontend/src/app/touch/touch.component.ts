import {Component} from '@angular/core';
import {Touch, TouchService} from './touch.service';
import {Toast, ToasterConfig, ToasterService} from 'angular2-toaster';

@Component({
	templateUrl: 'touch.component.html',
	selector: 'touch'
})
export class TouchComponent {

	public name: string;
	public email: string;
	public message: string;

	public isLoading: boolean;

	public configToaster: ToasterConfig = new ToasterConfig({
		positionClass: 'toast-top-right',
		limit: 1,
		animation: 'fade'
	});

	constructor(private touchService: TouchService, private toasterService: ToasterService) {
	}

	private cleanForm(): void {
		this.name = null;
		this.email = null;
		this.message = null;
	}

	public postTouch(): void {
		this.isLoading = true;

		let touch: Touch = {
			name: this.name,
			email: this.email,
			message: this.message
		};
		this.touchService.postTouch(touch).subscribe(
			() => {
				var toast: Toast = {
					type: 'success',
					title: 'Mensagem enviada',
					body: 'Sua mensagem foi enviada com sucesso!'
				};

				this.cleanForm();
				this.isLoading = false;
				this.toasterService.pop(toast);
			},
			err => {
				var toast: Toast = {
					type: 'error',
					title: 'Erro ao enviar mensagem',
					body: err.text()
				};

				this.isLoading = false;
				this.toasterService.pop(toast);
			});
	}
}

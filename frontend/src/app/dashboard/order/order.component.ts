import {OrderService} from "../shared/service/order.service";
import {ProductService} from "../shared/service/product.services";
import {ClientService} from "../shared/service/client.services";
import {Component, Injectable} from "@angular/core";


@Component({
  templateUrl: 'order.component.html',
  providers: [OrderService, ClientService, ProductService]
})

@Injectable()
export class OrderComponent {
}

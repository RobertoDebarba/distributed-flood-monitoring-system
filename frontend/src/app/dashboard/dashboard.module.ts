import {NgModule} from "@angular/core";
import {ChartsModule} from "ng2-charts/ng2-charts";
import {OrderComponent} from "./order/order.component";
import {DashboardRoutingModule} from "./dashboard-routing.module";
import {ClientComponent} from "./client/client.component";
import {ProductComponent} from "./product/product.component";
import {ModalModule} from "ng2-bootstrap/modal";
import {OrderService} from "./shared/service/order.service";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {TextMaskModule} from "angular2-text-mask";
import {AlertMessageComponent} from "./shared/alert/alert-message.compenent";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    DashboardRoutingModule,
    ChartsModule,
    TextMaskModule,
    ModalModule.forRoot()
  ],
  declarations: [
    OrderComponent,
    ClientComponent,
    ProductComponent,
    AlertMessageComponent
  ],
  providers: [
    OrderService
  ]
})
export class DashboardModule {
}

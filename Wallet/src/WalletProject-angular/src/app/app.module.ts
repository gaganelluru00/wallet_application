import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { ShowBalanceComponent } from './show-balance/show-balance.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { PrintTransactionsComponent } from './print-transactions/print-transactions.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { ShowDetailsComponent } from './show-details/show-details.component';
import { OperationMenuComponent } from './operation-menu/operation-menu.component';
import { HomeComponent } from './home/home.component';
import { UpdateDetailsComponent } from './update-details/update-details.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateAccountComponent,
    ShowBalanceComponent,
    DepositComponent,
    WithdrawComponent,
    FundTransferComponent,
    PrintTransactionsComponent,
    LoginComponent,
    ShowDetailsComponent,
    OperationMenuComponent,
    HomeComponent,
    UpdateDetailsComponent,
    DeleteAccountComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
